/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genal;

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
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                    board[i][j] = (int) Math.round(Math.random());
                    
            }
        }
        numOfKnights=calculateNoOfKnights();
        
    }
    
    public ChessBoardB(int[][] board, int knights) {
        super();
        this.board = board;
        this.numOfKnights=knights;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GeneticAlgorithm[] crossover(GeneticAlgorithm obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GeneticAlgorithm mutate(double mutationRate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
