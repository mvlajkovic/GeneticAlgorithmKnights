/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package genal;

/**
 *
 * @author Milica
 */
public interface GeneticAlgorithm {
    //create gen al with two functions
    double fitness();
    
    //crossover with object that called fuction
    GeneticAlgorithm crossover(GeneticAlgorithm obj);
    //same object using mutation - to change its properties, rate 0 - 100
    GeneticAlgorithm mutate(double mutationRate);
}
