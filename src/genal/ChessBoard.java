/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genal;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Milica
 */
public class ChessBoard implements GeneticAlgorithm {

    private static final int[][] MOVES = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
    {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    //length and numOfKnights can be variable numbers
    int length = 8;
    int numOfKnights = 10;
    int[][] board = new int[length][length];

    //target, gene pool?
    public ChessBoard() {
        //create empty board
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                board[i][j] = 0;
            }
        }
        Random random = new Random();
        int counter = 0;
        //set knights at random places
        while (counter < numOfKnights) {
            int i = random.nextInt(length);
            int j = random.nextInt(length);
            if (board[i][j] == 0) {
                board[i][j] = 1;
                counter++;
            }
        }
    }

    public ChessBoard(int[][] board) {
        super();
        this.board = board;
    }

    private static boolean isValidPosition(int row, int col, int boardSize) {
        return (row >= 0 && row < boardSize && col >= 0 && col < boardSize);
    }

    private int calculateNoOfKnights(){
        int res=0;
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                res += this.board[i][j];
            }
        }
        return res;
    }
    @Override
    public double fitness() {
        //this one should calculate the number of attacks
        //this is a fitness function for individual
        int attackedCount = 0;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                if (board[i][j] == 1) {
                    for (int[] move : MOVES) {
                        int nextRow = i + move[0];
                        int nextCol = j + move[1];
                        if (isValidPosition(nextRow, nextCol, this.board.length)) {
                            if (board[nextRow][nextCol] == 1) {
                                attackedCount++;
                                //System.out.println("knight " + i + "," + j + " is attacking knight " + nextRow + "," + nextCol);
                            }
                        }
                    }
                }
            }
            // System.out.println("total after row " + i + ": " + attackedCount);
        }
        return attackedCount;

    }

    @Override
    public GeneticAlgorithm crossover(GeneticAlgorithm obj) {
        ChessBoard ref = (ChessBoard) obj;
        int counter = 0;
        int[][] cross = new int[this.length][this.length];
        Random rand = new Random();
        //go through the board and set parent values while noOfKnights not reached
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                if (counter < this.numOfKnights) {
                    //this will prevent from having more than required num of knights
                    if (rand.nextBoolean()) {
                        //we take at random values from first or second board
                        cross[i][j] = this.board[i][j];

                        counter += this.board[i][j];

                    } else {
                        cross[i][j] = ref.board[i][j];
                        counter += ref.board[i][j];
                    }
                }
                else {
                    cross[i][j] = 0;
                }
            }
        }
        //what happens if we have less than required num of knights?
        //well we will replace random zeroes with 1
        while (counter < numOfKnights) {
            int i = rand.nextInt(length);
            System.out.println("i " + i);
            int j = rand.nextInt(length);
            System.out.println("j " + j);
            if (cross[i][j] == 0) {
                cross[i][j] = 1;
                counter++;
                
            }
            System.out.println("counter " +counter );
        }
        ChessBoard tmp = new ChessBoard(cross);
        return tmp;
    }

    @Override
    public GeneticAlgorithm mutate(double mutationRate) {
        int[][] mutation = new int[this.length][this.length];
        Random rand = new Random();
        int counter = 0;
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                if(counter < this.numOfKnights){
                    if(rand.nextDouble()<= mutationRate){
                        mutation[i][j]=(int) Math.round(Math.random());
                        if (mutation[i][j] == 1) {
                            counter++;
                        }
                    }
                    else{
                        mutation[i][j]=this.board[i][j];
                        if (mutation[i][j] == 1) {
                            counter++;
                        }
                    }
                }
                else {
                    mutation[i][j]=0;
                }
            }
        }
        System.out.println("matrix so far");
        System.out.println(Arrays.deepToString(mutation));
        System.out.println("counter "+ counter);
        //what happens if we have less than required num of knights?
        //well we will replace random zeroes with 1
        while (counter < numOfKnights) {
            int i = rand.nextInt(length);
            System.out.println("i " + i);
            int j = rand.nextInt(length);
            System.out.println("j " + j);
            if (mutation[i][j] == 0) {
                mutation[i][j] = 1;
                counter++;
                
            }
            System.out.println("counter " +counter );
        }
        
        ChessBoard tmp = new ChessBoard(mutation);
        return tmp;
    }

    @Override
    public String toString() {
        String tmp = "ChessBoard{\n";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                tmp += board[i][j] + " ";
            }
            tmp += "\n";
        }
        tmp += "} with fitness: " + fitness() + " num of knights: " + calculateNoOfKnights();
        return tmp;
    }

}
