/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genal;

/**
 *
 * @author Milica
 */
public class BestMatchA {
    ChessBoardA match;
    int generation;
    int individual;

    public BestMatchA(ChessBoardA match, int generation, int individual) {
        this.match = match;
        this.generation = generation;
        this.individual = individual;
    }

    public BestMatchA() {
    }
    
    public BestMatchA(BestMatchA bm) {
        this.match=bm.match;
        this.individual=bm.individual;
        this.generation=bm.generation;
    }

    public ChessBoardA getMatch() {
        return match;
    }

    public void setMatch(ChessBoardA match) {
        this.match = match;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getIndividual() {
        return individual;
    }

    public void setIndividual(int individual) {
        this.individual = individual;
    }

    @Override
    public String toString() {
        String txt= "BEST MATCH\nGeneration "+generation+" individual "+ individual+ " {\n";
        for (int i = 0; i < match.length; i++) {
            for (int j = 0; j < match.length; j++) {
                txt += match.board[i][j] + " ";
            }
            txt += "\n";
        }
        txt += "} with fitness: " + match.fitness();
        txt += " and no of knights: " + match.calculateNoOfKnights();
        return txt;
    }
    
    
    
}
