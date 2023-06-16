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
        //testMethod();
        testGen();
        
    }
    
    public static void testGen(){
        BestMatch theBest = new BestMatch();
        System.out.println("FIRST GENERATION");
        int noOfIndividuals = 100;
        ChessBoard[] boards = new ChessBoard[noOfIndividuals];
        GeneticAlgorithm[] gen = new GeneticAlgorithm[noOfIndividuals];
        for (int i = 0; i < noOfIndividuals; i++) {
            boards[i]=new ChessBoard();
            gen[i]= boards[i];
            System.out.println(boards[i].toString());
        }
        //temp setting the first bord to be the best.
        theBest.setMatch((ChessBoard) gen[0]);
        theBest.setIndividual(0);
        theBest.setGeneration(0);
        System.out.println("NEXT GENERATIONS");
        for (int i = 0; i < 300; i++) {
            Population pop = new Population(gen, 0.7);
          BestMatch bm = pop.getTheBest();
          bm.setGeneration(i);
          if(bm.getMatch().fitness()>theBest.getMatch().fitness()){
              theBest=bm;
          }
            //get next gen
            gen = pop.newGeneration();
            //if any is equal to the target(1) return it
            for (int j = 0; j < gen.length; j++) {
                ChessBoard temp = (ChessBoard) gen[j];
                System.out.println(temp.toString());
                if(temp.fitness()==1){
                    System.out.println("SOLUTION");
                    System.out.println("Generation " + i + " individual " + j);
                    return;
                }
            }
        }
        System.out.println(theBest.toString());
    }

    public static void testMethod(){
        int[][] board = {{0, 1, 1, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};
        ChessBoard instance1 = new ChessBoard(board);
        double expectedRes = 14.0;
        double result = instance1.fitness();
        System.out.println("Testing function fitness: " + (expectedRes == result));

        ChessBoard instance2 = new ChessBoard();
        ChessBoard instance3 = new ChessBoard();
        ChessBoard instance4 = new ChessBoard();
        ChessBoard instance5 = new ChessBoard();
        ChessBoard instance6 = new ChessBoard();
        
        System.out.println("BOARDS");
        System.out.println(instance1.toString());

        System.out.println("*******************************************");
        System.out.println(instance2.toString());
        System.out.println(instance3.toString());
        System.out.println(instance4.toString());
        System.out.println(instance5.toString());
        System.out.println(instance6.toString());

        System.out.println("CROSSOVER + MUTATION");
        ChessBoard[] tmp1 = (ChessBoard[]) instance1.crossover(instance2);
        System.out.println("1 + 2");
        System.out.println(tmp1[0].toString() + "\n" + tmp1[1].toString());
        System.out.println(((ChessBoard) tmp1[0].mutate(0.5)).toString());
        System.out.println(((ChessBoard) tmp1[1].mutate(0.5)).toString());
        ChessBoard[] tmp2 = (ChessBoard[]) instance3.crossover(instance2);
        System.out.println("3 + 2");
        System.out.println(tmp2[0].toString() + "\n" + tmp2[1].toString());
        System.out.println(((ChessBoard) tmp2[0].mutate(0.5)).toString());
        System.out.println(((ChessBoard) tmp2[1].mutate(0.5)).toString());
        ChessBoard[] tmp3 = (ChessBoard[]) instance4.crossover(instance2);
        System.out.println("4 + 2");
        System.out.println(tmp3[0].toString() + "\n" + tmp3[1].toString());
        System.out.println(((ChessBoard) tmp3[0].mutate(0.5)).toString());
        System.out.println(((ChessBoard) tmp3[1].mutate(0.5)).toString());
        ChessBoard[] tmp4 = (ChessBoard[]) instance5.crossover(instance2);
        System.out.println("5 + 2");
        System.out.println(tmp4[0].toString() + "\n" + tmp4[1].toString());
        System.out.println(((ChessBoard) tmp4[0].mutate(0.5)).toString());
        System.out.println(((ChessBoard) tmp4[1].mutate(0.5)).toString());
        ChessBoard[] tmp5 = (ChessBoard[]) instance6.crossover(instance2);
        System.out.println("6 + 2");
        System.out.println(tmp5[0].toString() + "\n" + tmp5[1].toString());
        System.out.println(((ChessBoard) tmp5[0].mutate(0.5)).toString());
        System.out.println(((ChessBoard) tmp5[1].mutate(0.5)).toString());
        
        
    }
    
}
