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
public class ChessBoard implements GeneticAlgorithm {

    private static final int[][] MOVES = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
    {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    //length and numOfKnights can be variable numbers
    int length = 8;
    int numOfKnights = 10;
    int[][] board = new int[length][length];

    //target, gene pool?
    public ChessBoard() {
        int counter = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (counter < numOfKnights) {
                    board[i][j] = (int) Math.round(Math.random());
                    if (board[i][j] == 1) {
                        counter++;
                    }
                } else {
                    board[i][j] = 0;
                }
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GeneticAlgorithm mutate(double mutationRate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
