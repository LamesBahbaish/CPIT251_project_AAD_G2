/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project251_ADD;

/**
 *
 * @author Joud Alharbi
 */
public class Reservation {
    // Attributes

    private int reservationNum;
    private int golfCarNum;
    private int golfTripNum;
    private int seatNum;
    private Student student;

    // Constructor
    public Reservation(int golfTripNum, int golfCarNum, int seatNum, Student student) {
        this.reservationNum = generateReservationNum();
        this.golfCarNum = golfCarNum;
        this.golfTripNum = golfTripNum;
        this.seatNum = seatNum;
        this.student = student;
    }

    // Method to generate a unique reservation number
    public int generateReservationNum() {
        return (int) (Math.random() * 10000);
    }

    // Method to modify the seat number of the reservation
    public boolean modifySeat(int golfCarNum, int newSeatNum, int maxSeats) {
        if (this.golfTripNum == golfCarNum && newSeatNum > 0 && newSeatNum <= maxSeats) {
            this.seatNum = newSeatNum;
            return true; // Modification successful
        }
        return false; // Modification failed
    }

    // Method to cancel the reservation
    public boolean cancelReservation(int reservationNum) {
        if (this.reservationNum == reservationNum) {
            this.golfTripNum = -1; // Indicating that the golf car is no longer associated
            this.seatNum = -1;    // Indicating that the seat is no longer reserved
            return true;          // Indicate that the reservation was successfully cancelled
        }
        return false;            // Indicate that there was no such reservation to cancel
    }

    // Getters and Setters for all attributes...
    public int getReservationNum() {
        return reservationNum;
    }

    public int getGolfCarNum() {
        return golfTripNum;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int newSeatNum) {
        this.seatNum = newSeatNum;
    }

    public Student getStudent() {
        return student;
    }

    public int getGolfTripNum() {
        return golfTripNum;
    }

}
