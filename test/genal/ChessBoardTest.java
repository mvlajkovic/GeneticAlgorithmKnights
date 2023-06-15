/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package genal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Milica
 */
public class ChessBoardTest {
    
    public ChessBoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of fitness method, of class ChessBoard.
     */
    @Test
    public void testFitness() {
        System.out.println("fitness");
        int[][] board = {{0,1,1,1,0,1,0,1},{1,0,1,1,0,0,0,0},{1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
        ChessBoard instance = new ChessBoard(board);
        double expResult = 14.0;
        double result = instance.fitness();
        System.out.println(expResult==result);
        assertTrue(expResult==result);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The function failed.");
    }

//    /**
//     * Test of crossover method, of class ChessBoard.
//     */
//    @Test
//    public void testCrossover() {
//        System.out.println("crossover");
//        GeneticAlgorithm obj = null;
//        ChessBoard instance = new ChessBoard();
//        GeneticAlgorithm expResult = null;
//        GeneticAlgorithm result = instance.crossover(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of mutate method, of class ChessBoard.
//     */
//    @Test
//    public void testMutate() {
//        System.out.println("mutate");
//        double mutationRate = 0.0;
//        ChessBoard instance = new ChessBoard();
//        GeneticAlgorithm expResult = null;
//        GeneticAlgorithm result = instance.mutate(mutationRate);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
