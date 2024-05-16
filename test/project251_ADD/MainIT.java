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
    // private final PrintStream originalOut = System.out;
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
        GolfCars.add(golfCar);
        Main.reservations.clear();
        Main.GolfCars.clear();
    }

    @After
    public void tearDown() {
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
        Main.CreateReservation(golfCar, student, 1);
        // Verify if the reservation was done correctly
        assertTrue(out.toString().contains("Booking successful!")); // Check if success message is printed
    }

    /**
     * Test of checkSeats method, of class Main.
     */
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
     * Test of StudentID method, of class Main.
     */
    @Test
    public void testCheckStudentId() {
        System.out.println("CheckStudentId");
        int StudentID = 2210510;
        boolean result = Main.CheckStudentId(StudentID);
        assertTrue(result);

    }

    @Test
    public void testCheckStudentId_false() { //<7
        System.out.println("CheckStudentId");
        int StudentID = 22105;
        boolean result = Main.CheckStudentId(StudentID);
        assertFalse(result);
    }

    /**
     * Test of CancelReservation method, of class Main.
     */
    @Test
    public void testCancelReservation() {
        GolfCar golfCar = new GolfCar(1, 1, 2, "Gate1", "8:00 AM");
        // Create a student
        Student student = new Student(1234567, "Joud");
        // Create a reservation and add it
        Reservation reservation = new Reservation(1, 1, 2, student);
        Main.reservations.add(reservation);
        // Simulate user input that selects the reservation to cancel
        String simulatedUserInput = "1\n"; // assuming the reservation number to cancel is 1
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Main.scanner = new Scanner(System.in);
        System.out.println("CancelReservation");
        int initialSize = Main.reservations.size();
        Main.CancelReservation();
        assertEquals("Reservations list should have one less reservation", initialSize - 1, Main.reservations.size());
    }

    /**
     * Test of ModifyReservation method, of class Main.
     */
    @Test
    public void testModifyReservation() {
        GolfCar car = new GolfCar(1, 1, 5, "Gate1", "8:00 AM");
        Student student = new Student(1234567, "Aryam");
        Reservation reservation = new Reservation(1, 1, 2, student);
        Main.GolfCars.add(car);
        Main.reservations.add(reservation); // Add a reservation to modify
        // Input Simulation: Choose reservation to modify and new seat count
        String input = "1\n3\n"; // Choose reservation 1, change seats to 3
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Main.scanner = new Scanner(System.in);
        // Execute the ModifyReservation functionality
        Main.ModifyReservation();
        // Verify the seat number is updated in the reservation
        assertEquals("Expected seat number updated in reservation", 3, reservation.getSeatNum());
        // Reset System.in and System.out to avoid any side effects
        System.setIn(System.in);
        System.setOut(System.out);
    }
}
