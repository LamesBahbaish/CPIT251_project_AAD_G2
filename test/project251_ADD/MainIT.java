/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project251_ADD;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Lames_ASB
 */
public class MainIT {

    
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final ArrayList<GolfCar> GolfCars = new ArrayList<>();
    private final GolfCar golfCar = new GolfCar(1, 1, 2, "Gate1", "8:00 AM");

    public MainIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(out));
        System.setOut(new PrintStream(outContent));
        GolfCars.add(golfCar); 
        
        // Setup the environment
        Main.reservations.clear();
        Main.GolfCars.clear();
        
         // Add a golf car to the list
        GolfCar golfCar = new GolfCar(1, 1, 2, "Gate1", "8:00 AM");
        Main.GolfCars.add(golfCar);

        // Create a student
        Student student = new Student(1234567, "John Doe");

        // Create a reservation and add it
        Reservation reservation = new Reservation(1, 1, 2, student);
        Main.reservations.add(reservation);

        // Simulate user input that selects the reservation to cancel
        String simulatedUserInput = "1\n"; // assuming the reservation number to cancel is 1
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Main.scanner = new Scanner(System.in);
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(System.in);
    }

    /**
     * Test of PrintSchedule_forTest method, of class Main.
     */
    @Test
    public void testPrintSchedule() {
        Main.PrintSchedule(GolfCars);
        String expectedOutput = "-------------------------------------------------" + System.lineSeparator()
                + "                Golf Car Schedule                " + System.lineSeparator()
                + "-------------------------------------------------" + System.lineSeparator()
                + "GolfTripNO | GolfCarNO | Destination | Time     | Seats Number" + System.lineSeparator()
                + "------------------------------------------------------------" + System.lineSeparator()
                + String.format("%-11d| %-10d| %-12s| %-9s| %-13d%n",
                        golfCar.getGolfTripNum(), golfCar.getGolf_Number(), golfCar.getDestination(),
                        golfCar.getTime(), golfCar.getSeats())
                + "------------------------------------------------------------" + System.lineSeparator();
        assertEquals(expectedOutput, out.toString());
    }

    /**
     * Test of CreateReservation method, of class Main.
     */
    @Test
    public void testCreateReservation() {
        // Create a sample GolfCar object
        GolfCar golfCar = new GolfCar(1, 22, 6, "Gate 2", "08:00");
        // Create a sample Student object
        Student student = new Student(1234567, "Lames");
        // Redirect System.in and System.out to simulate user input and output
        String input = "1\n"; // Simulate user input for number of seats to book
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //String expectedOutput = "Booking successful! Your Reservation Number: reserve.getReservationNum())\n";
        // Call the method to be tested
        Main.CreateReservation(golfCar, student,1);
        // Verify if the reservation was done correctly
        assertTrue(out.toString().contains("Booking successful!")); // Check if success message is printed
    }
    
    @Test
    public void testCheckSeats_ValidSeats() {
        boolean result = Main.checkSeats(3, 10);
        assertTrue(result); // Expecting true for valid seats
    }

    @Test
    public void testCheckSeats_ZeroSeats() {
        boolean result = Main.checkSeats(0, 10);
        assertFalse(result); // Expecting false for zero seats
    }

    @Test
    public void testCheckSeats_NegativeSeats() {
        boolean result = Main.checkSeats(-5, 10);
        assertFalse(result); // Expecting false for negative seats
    }

    @Test
    public void testCheckSeats_ExceedTotalSeats() {
        boolean result = Main.checkSeats(15, 10);
        assertFalse(result); // Expecting false for seats exceeding total seats
    }

    @Test
    public void testCheckSeats_EqualSeatsToTotal() {
        boolean result = Main.checkSeats(10, 10);
        assertTrue(result); // Expecting true for seats equal to total seats
    }

    

    /**
     * Test of checkSeats method, of class Main.
     */
    @Test
    public void testCheckStudentId() {
        System.out.println("CheckStudentId");
        int StudentID = 2210510;
        boolean result = Main.CheckStudentId(StudentID);
        assertTrue(result);
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

    /**
     * Test of CancelReservation method, of class Main.
     */
    @Test
    public void testCancelReservation() {
        System.out.println("CancelReservation");
        int initialSize = Main.reservations.size();
        Main.CancelReservation();
        assertEquals("Reservations list should have one less reservation", initialSize - 1, Main.reservations.size());
        assertTrue("Output should confirm cancellation", outContent.toString().contains("canceled successfully"));
    }

    /**
     * Test of ModifyReservation method, of class Main.
     */
    @Test
    public void testModifyReservation() {
        System.out.println("ModifyReservation");
        Main.ModifyReservation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
