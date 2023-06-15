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
        testMethod();
        
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
        System.out.println(instance3.toString());
        System.out.println(instance2.toString());
        System.out.println(instance3.toString());
        System.out.println(instance4.toString());
        System.out.println(instance5.toString());
        System.out.println(instance6.toString());

        System.out.println("CROSSOVER");
        System.out.println(((ChessBoard) instance1.crossover(instance2)).toString());
        System.out.println(((ChessBoard) instance3.crossover(instance2)).toString());
        System.out.println(((ChessBoard) instance4.crossover(instance2)).toString());
        System.out.println(((ChessBoard) instance5.crossover(instance2)).toString());
        System.out.println(((ChessBoard) instance6.crossover(instance2)).toString());

        System.out.println("MUTATE");
        System.out.println(((ChessBoard) instance1.mutate(0.01)).toString());
        System.out.println(((ChessBoard) instance2.mutate(0.01)).toString());
        System.out.println(((ChessBoard) instance3.mutate(0.01)).toString());
        System.out.println(((ChessBoard) instance4.mutate(0.01)).toString());
        System.out.println(((ChessBoard) instance5.mutate(0.01)).toString());
        System.out.println(((ChessBoard) instance6.mutate(0.01)).toString());
    }
}
