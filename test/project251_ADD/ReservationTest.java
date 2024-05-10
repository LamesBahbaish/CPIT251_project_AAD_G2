/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package project251_ADD;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joud Alharbi
 */
public class ReservationTest {
    public Reservation instance;
    public ReservationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Reservation();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of generateReservationNum method, of class Reservation.
     */
    @Test
    public void testGenerateReservationNum() {
        System.out.println("generateReservationNum");
        Reservation instance = null;
        int expResult = 0;
        int result = instance.generateReservationNum();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of modifySeat method, of class Reservation.
     */
    @Test
    public void testModifySeat() {
        System.out.println("modifySeat");
        int golfCarNum = 0;
        int newSeatNum = 0;
        int maxSeats = 0;
        Reservation instance = null;
        boolean expResult = false;
        boolean result = instance.modifySeat(golfCarNum, newSeatNum, maxSeats);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of cancelReservation method, of class Reservation.
     */
    @Test
    public void testCancelReservation() {
        System.out.println("cancelReservation");
        int reservationNum = 0;
        Reservation instance = null;
        boolean expResult = false;
        boolean result = instance.cancelReservation(reservationNum);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getReservationNum method, of class Reservation.
     */
    @Test
    public void testGetReservationNum() {
        System.out.println("getReservationNum");
        Reservation instance = null;
        int expResult = 0;
        int result = instance.getReservationNum();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getGolfCarNum method, of class Reservation.
     */
    @Test
    public void testGetGolfCarNum() {
        System.out.println("getGolfCarNum");
        Reservation instance = null;
        int expResult = 0;
        int result = instance.getGolfCarNum();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getSeatNum method, of class Reservation.
     */
    @Test
    public void testGetSeatNum() {
        System.out.println("getSeatNum");
        Reservation instance = null;
        int expResult = 0;
        int result = instance.getSeatNum();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getStudent method, of class Reservation.
     */
    @Test
    public void testGetStudent() {
        System.out.println("getStudent");
        Reservation instance = null;
        Student expResult = null;
        Student result = instance.getStudent();
        assertEquals(expResult, result);
        
    }
    
}
