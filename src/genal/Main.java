/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package genal;

/**
 *
 * @author Milica
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int knights = 12;
        int noOfIndividuals = 1000;
        int noOfGen = 3000;
        double mutationRate = 0.25;
        //optionA(knights, noOfIndividuals, noOfGen, mutationRate);
        optionB(noOfIndividuals, noOfGen, mutationRate);

    }

    public static void optionA(int knights, int noOfIndividuals, int noOfGen, double mutationRate) {
        BestMatchA theBest = new BestMatchA();
        //System.out.println("FIRST GENERATION");

        ChessBoardA[] boards = new ChessBoardA[noOfIndividuals];
        GeneticAlgorithm[] gen = new GeneticAlgorithm[noOfIndividuals];
        for (int i = 0; i < noOfIndividuals; i++) {
            boards[i] = new ChessBoardA(knights);
            gen[i] = boards[i];
            //System.out.println(boards[i].toString());
        }
        //temp setting the first bord to be the best.
        theBest.setMatch((ChessBoardA) gen[0]);
        theBest.setIndividual(0);
        theBest.setGeneration(0);
        //System.out.println("NEXT GENERATIONS");
        for (int i = 0; i < noOfGen; i++) {
            Population pop = new Population(gen, mutationRate);
            System.out.println("GENERATION " + i);
            BestMatchA bm = pop.getTheBestA();
            bm.setGeneration(i);
            System.out.println(bm.toString());
            if (bm.getMatch().fitness() > theBest.getMatch().fitness()) {
                theBest = bm;
            }
            //get next gen
            gen = pop.newGeneration();
            //checking next gen - this is termination condition - stops when the first solution is found
            //if any is equal to the target(1) return it
            /*for (int j = 0; j < gen.length; j++) {
                ChessBoardA temp = (ChessBoardA) gen[j];
                //System.out.println(temp.toString());
                if(temp.fitness()==1){
                    theBest.setMatch(temp);
                    //this is for the next gen so it is i+1
                    theBest.setGeneration(i+1);
                    theBest.setIndividual(j);
                    System.out.println("SOLUTION");
                    System.out.println(theBest.toString());
                    return;
                }
            }*/
        }
        System.out.println("BEST OVERALL");
        System.out.println(theBest.toString());
    }

    public static void optionB(int noOfIndividuals, int noOfGen, double mutationRate) {

        ChessBoardB[] boards = new ChessBoardB[noOfIndividuals];
        GeneticAlgorithm[] gen = new GeneticAlgorithm[noOfIndividuals];
        for (int i = 0; i < noOfIndividuals; i++) {
            boards[i] = new ChessBoardB();
            gen[i] = boards[i];
            //System.out.println(boards[i].toString());
        }
        //temp setting the the best from the first pop as 
        Population pop = new Population(gen, mutationRate);
        BestMatchB theBest = pop.getTheBestB();
        //System.out.println("NEXT GENERATIONS");
        for (int i = 0; i < noOfGen; i++) {
            System.out.println("GENERATION " + i);
            BestMatchB bm = pop.getTheBestB();
            if (bm != null) {
                bm.setGeneration(i);
                System.out.println(bm.toString());
                if (theBest != null) {
                    if (bm.getMatch().getNumOfKnights() > theBest.getMatch().getNumOfKnights()) {
                        theBest = bm;
                    }
                }
                else{
                    theBest = bm;
                }
            }
            //get next gen
            gen = pop.newGeneration();
            pop = new Population(gen, mutationRate);
        }
        System.out.println("BEST OVERALL");
        if(theBest!= null){
        System.out.println(theBest.toString());}
        else {
            System.out.println("No solution");
        }

    }

}
