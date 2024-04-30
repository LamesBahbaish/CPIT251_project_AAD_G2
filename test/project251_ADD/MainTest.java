/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package project251_ADD;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author linahani
 */
public class MainTest {
    
    public MainTest() {
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
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Main.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PrintSchedule method, of class Main.
     */
    @Test
    public void testPrintSchedule() {
        System.out.println("PrintSchedule");
        ArrayList<GolfCar> GolfCars = null;
        Main.PrintSchedule(GolfCars);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MakeReservation method, of class Main.
     */
    @Test
    public void testMakeReservation() {
        System.out.println("MakeReservation");
        Main.MakeReservation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayMenu method, of class Main.
     */
    @Test
    public void testDisplayMenu() {
        System.out.println("displayMenu");
        Main.displayMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckStudentId method, of class Main.
     */
    @Test
    public void testCheckStudentId() {
        System.out.println("CheckStudentId");
        int StudentID = 2210510;
        boolean result = Main.CheckStudentId(StudentID);
        assertTrue( result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @Test
    public void testCheckStudentId_false() { //<7
        System.out.println("CheckStudentId");
        int StudentID = 22105;
        boolean result = Main.CheckStudentId(StudentID);
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
