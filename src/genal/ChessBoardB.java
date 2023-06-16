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
public class ChessBoardB implements GeneticAlgorithm{
    
    private static final int[][] MOVES = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
    {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    //length and numOfKnights can be variable numbers
    int length = 8;
    int numOfKnights;
    int[][] board = new int[length][length];

    public ChessBoardB() {
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(rand.nextBoolean()){
                    board[i][j]=1;                
                }
                else {
                    board[i][j]=0;
                }
                    
            }
        }
        numOfKnights=calculateNoOfKnights();
        
    }
    
    public ChessBoardB(int[][] board) {
        super();
        this.board = board;
        this.numOfKnights = calculateNoOfKnights();
    }

    public int getLength() {
        return length;
    }

    public int getNumOfKnights() {
        return numOfKnights;
    }

    public int[][] getBoard() {
        return board;
    }

    
    private static boolean isValidPosition(int row, int col, int boardSize) {
        return (row >= 0 && row < boardSize && col >= 0 && col < boardSize);
    }

    private int calculateNoOfKnights() {
        int res = 0;
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
        if (attackedCount == 0) {
            return 1.0;
        } else {
            return 1.0 / attackedCount;
        }
    }

    @Override
    public GeneticAlgorithm[] crossover(GeneticAlgorithm obj) {
        ChessBoardB ref = (ChessBoardB) obj;
        int[][] crossOne = new int[this.length][this.length];
        int[][] crossTwo = new int[this.length][this.length];
        Random rand = new Random();
        //go through the board and set parent values while noOfKnights not reached
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                if( rand.nextBoolean()){
                    //we take at random values from first board for first offspring, and from second for second
                    crossOne[i][j] = this.board[i][j];
                    crossTwo[i][j] = ref.board[i][j];
                }
                else{
                    crossOne[i][j] = ref.board[i][j];
                    crossTwo[i][j] = this.board[i][j];
                }          
            }
        }
        
        ChessBoardB[] tmp = {new ChessBoardB(crossOne), new ChessBoardB(crossTwo)};
        return tmp;
    }

    @Override
    public GeneticAlgorithm mutate(double mutationRate) {
        int[][] mutation = new int[this.length][this.length];
        Random rand = new Random();
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                if(rand.nextDouble() <=  mutationRate){
                    mutation[i][j]= (int) Math.round(Math.random());
                }
                else{
                      mutation[i][j] = this.board[i][j];
                }
            }
        }
        ChessBoardA tmp = new ChessBoardA(mutation, numOfKnights); //mutation as in board
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
