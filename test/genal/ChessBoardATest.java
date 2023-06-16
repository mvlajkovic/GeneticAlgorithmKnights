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
public class ChessBoardATest {
    
    public ChessBoardATest() {
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
     * Test of fitness method, of class ChessBoardA.
     */
    @Test
    public void testFitness() {
        System.out.println("fitness");
        int[][] board = {{0,1,1,1,0,1,0,1},{1,0,1,1,0,0,0,0},{1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
        ChessBoardA instance = new ChessBoardA(board, 10);
        double expResult = 14.0;
        double result = instance.fitness();
        System.out.println(expResult==result);
        assertTrue(expResult==result);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The function failed.");
    }

//    /**
//     * Test of crossover method, of class ChessBoardA.
//     */
//    @Test
//    public void testCrossover() {
//        System.out.println("crossover");
//        GeneticAlgorithm obj = null;
//        ChessBoardA instance = new ChessBoardA();
//        GeneticAlgorithm expResult = null;
//        GeneticAlgorithm result = instance.crossover(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of mutate method, of class ChessBoardA.
//     */
//    @Test
//    public void testMutate() {
//        System.out.println("mutate");
//        double mutationRate = 0.0;
//        ChessBoardA instance = new ChessBoardA();
//        GeneticAlgorithm expResult = null;
//        GeneticAlgorithm result = instance.mutate(mutationRate);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
