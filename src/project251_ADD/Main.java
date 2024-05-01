package project251_ADD;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        boolean f = true;
        int studentId = 0;
        do {
            System.out.print("Enter student ID: ");
            studentId = scanner.nextInt(); // Read student ID from input
            scanner.nextLine();
            f = CheckStudentId(studentId);
        } while (f == false);

        // Consume the remaining newline
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine(); // Read student name from input
        Student student = new Student(studentId, studentName); // Create a Student object with user input

        System.out.println("Hello " + student.getName() + "!");

        ArrayList<GolfCar> GolfCars = new ArrayList<>(); // Creating an ArrayList to store GolfCar objects
        // Creating and adding golf cars with specific attributes 
        GolfCar trip1 = new GolfCar(1, 1, 2, "Gate1", "8:00 AM"); // Create a golf car object
        GolfCars.add(trip1); // Add the golf car to the ArrayList
        GolfCar trip2 = new GolfCar(3, 1, 0, "Gate3", "9:30 AM");
        GolfCars.add(trip2); // Add the golf car to the ArrayList
        GolfCar trip3 = new GolfCar(2, 2, 4, "Gate2", "9:00 AM");
        GolfCars.add(trip3);
        GolfCar trip4 = new GolfCar(3, 3, 6, "Gate3", "10:00 AM");
        GolfCars.add(trip4);
        GolfCar trip5 = new GolfCar(4, 4, 8, "Gate4", "11:00 AM");
        GolfCars.add(trip5);
        GolfCar trip6 = new GolfCar(5, 5, 6, "Gate5", "12:00 PM");
        GolfCars.add(trip6);

        ArrayList<Reservation> reservations = new ArrayList<>();
        System.out.println("-------------Welcome to Golf car KAU-------------");
        PrintSchedule(GolfCars);

        int choice;
        int x = 0;
        GolfCar selectedCar = null;

        do {

            displayMenu();
            int golfTripNum;
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    // Make a reservation
                    if (x != 0) { //-------------to print Schedule
                        PrintSchedule(GolfCars);
                    }
                    x += 1;
                    System.out.println("Making a reservation...");
                    do {
                        System.out.print("Enter golf trip number: ");
                        golfTripNum = scanner.nextInt();
                        for (GolfCar car : GolfCars) {
                            if (car.getGolfTripNum() == golfTripNum) {
                                selectedCar = car;
                                break;
                            }
                        }
                        if (selectedCar == null) {
                            System.out.println("No golf car with the entered number exists. Please try again.");
                        } else if (selectedCar.getSeats() == 0) {
                            System.out.println("Sorry! No seat available");
                        }

                    } while (selectedCar == null || selectedCar.getSeats() == 0);

                    int seatsToBook;
                    do {
                        System.out.println("Enter number of seats to book:");
                        seatsToBook = scanner.nextInt();

                        if (seatsToBook <= 0) {
                            System.out.println("Invalid number of seats. Please enter a valid number.");
                        } else if (seatsToBook > selectedCar.getSeats()) {
                            System.out.println("The seat number is more than the capacity. Please try again.");
                        }

                    } while (seatsToBook <= 0 || seatsToBook > selectedCar.getSeats());

                    Reservation reserve = new Reservation(golfTripNum, seatsToBook, student); //reserve
                    reservations.add(reserve);
                    selectedCar.updateSeat(seatsToBook);
                    System.out.println("Booking successful! Your Reservation Number: " + reserve.getReservationNum());
                    break;

                case 2:
                    // Delete my reservation
                    System.out.println("Deleting a reservation...");
                    System.out.print("Enter reservation number to cancel: ");
                    int reservationNumToCancel = scanner.nextInt();
                    boolean found = false;
                    GolfCar selectedGolf = null;
                    int seatNum = 0;
                    int golfCarnum = 0;
                    for (int i = 0; i < reservations.size(); i++) {
                        if (reservations.get(i).getReservationNum() == reservationNumToCancel) {
                            seatNum = reservations.get(i).getSeatNum();
                            golfCarnum = reservations.get(i).getGolfCarNum();
                            reservations.get(i).cancelReservation(reservationNumToCancel);
                            System.out.println("Reservation cancelled.");
                            reservations.remove(i); // Remove the reservation from the list 
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No reservation with the given number exists. Please try again.");
                    } else {
                        for (GolfCar car : GolfCars) {
                            if (car.getGolf_Number() == golfCarnum) {
                                selectedGolf = car;
                                break;
                            }
                        }
                        selectedGolf.addSeat(seatNum);
                    }
                    break;
                case 3:
                    // Modify my reservation
                    System.out.println("Modifying a reservation...");
                    System.out.print("Enter reservation number to modify: ");
                    int modifyNum = scanner.nextInt();
                    System.out.print("Enter new seat number: ");
                    int newSeatNum = scanner.nextInt();

                    boolean reservationFound = false;
                    for (Reservation res : reservations) {
                        if (res.getReservationNum() == modifyNum) {
                            reservationFound = true;
                            GolfCar carToModify = null;
                            for (GolfCar car : GolfCars) {
                                if (car.getGolf_Number() == res.getGolfCarNum()) {
                                    carToModify = car;
                                    break;
                                }
                            }

                            if (carToModify != null && res.modifySeat(res.getGolfCarNum(), newSeatNum, carToModify.getSeats())) {
                                System.out.println("Reservation modified.");
                            } else {
                                System.out.println("Modification failed. The seat number is invalid.");
                            }
                            break;
                        }
                    }
                    if (!reservationFound) {
                        System.out.println("No reservation with the given number exists. Please try again.");
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Thank you for using Golf car KAU. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        } while (choice != 4);

    }

    public static void PrintSchedule(ArrayList<GolfCar> GolfCars) {

        System.out.println("-------------------------------------------------");
        System.out.println("                Golf Car Schedule                ");
        System.out.println("-------------------------------------------------");
        System.out.println("GolfTripNO | GolfCarNO | Destination | Time     | Seats Number");
        System.out.println("------------------------------------------------------------");
        for (GolfCar car : GolfCars) {
            System.out.printf("%-11d| %-10d| %-12s| %-9s| %-13d%n",
                    car.getGolfTripNum(), car.getGolf_Number(), car.getLocation(), car.getTime(), car.getSeats());
        }
        System.out.println("------------------------------------------------------------");

    }

    public static void MakeReservation() {

    }

    public static void displayMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.print("Choose the appropriate number\n");
        System.out.println("1. Make a reservation");
        System.out.println("2. Delete my reservation");
        System.out.println("3. Modify reservation");
        System.out.println("4. EXIT");
        System.out.println("-------------------------------------------------");
    }

    public static boolean CheckStudentId(int StudentID) {
        if (String.valueOf(StudentID).length() != 7) {
            System.out.println("Please enter a 7-digit student ID. ");
            return false;
        }

        return true;
    }
}
