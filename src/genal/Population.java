/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genal;

import java.util.Random;

/**
 *
 * @author Milica
 */
public class Population {

    //class that applies all GA functions to the whole population
    private double[] fitnessVal;
    private double[] probability;
    private double[] cumulative;
    private double mutation, totalFitness;
    private GeneticAlgorithm[] population;

    public Population(GeneticAlgorithm[] population, double mutation) {
        this.population = population;
        //at first we dont want any mutation
        this.mutation = -1;
        fitnessVal = new double[population.length];
        probability = new double[population.length];
        cumulative = new double[population.length];
        this.mutation = mutation;
    }

    public void populationFitness() {
        //calculate fitness of whole population
        totalFitness = 0;
        for (int i = 0; i < this.population.length; i++) {
            fitnessVal[i] = population[i].fitness();
            System.out.println("indvidiaul " + i + " fitness: " + fitnessVal[i]);
            totalFitness += fitnessVal[i];
        }
    }

    public void populationProbability() {
        // Calculate probability based on the fitness, probability of particle fintess, helps us chose later
        for (int i = 0; i < population.length; i++) {
            probability[i] = fitnessVal[i] / totalFitness;
            System.out.println("individual " + i + " probability: " + probability[i]);
        }
    }

    public void cumulativeProbability() {
        // Calculate Cumulative probability
        double tmp = 0;
        for (int i = 0; i < population.length; i++) {
            tmp += probability[i];
            cumulative[i] = tmp;
            System.out.println("indvidiual " + i + " cumulative probs: " + tmp);
        }
    }

    public GeneticAlgorithm randomSelect() {
        Random random = new Random();

        //next double generate 0-1 double, if that is less that cumulative it will select that individual. 
        double select = random.nextDouble();
        for (int i = 0; i < population.length; i++) {
            if (cumulative[i] >= select) {
                return population[i];
            }
        }

        return population[random.nextInt(population.length)];
    }

    public GeneticAlgorithm[] newGeneration() {
        populationFitness();
        populationProbability();
        cumulativeProbability();
        GeneticAlgorithm[] tempArr = new GeneticAlgorithm[population.length];
        for (int i = 0; i < population.length; i = i + 2) {
            //we have 2 offsprings
            GeneticAlgorithm parent1 = randomSelect();
            GeneticAlgorithm parent2 = randomSelect();
            GeneticAlgorithm[] offspring = parent1.crossover(parent2);
            tempArr[i] = offspring[0].mutate(mutation);
            tempArr[i + 1] = offspring[1].mutate(mutation);
        }
        return tempArr;
    }

    public BestMatch getTheBest() {
        BestMatch tmp = new BestMatch();
        tmp.setMatch((ChessBoard) population[0]);
        tmp.setIndividual(0);
        for (int i = 1; i < population.length; i++) {
            if (population[i].fitness() > tmp.getMatch().fitness()) {
                tmp.setMatch((ChessBoard) population[i]);
                tmp.setIndividual(i);
            }
        }
        return tmp;
    }

}
