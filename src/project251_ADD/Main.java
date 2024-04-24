package project251_ADD;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID: "); 
        int studentId = scanner.nextInt(); // Read student ID from input
        scanner.nextLine(); // Consume the remaining newline

        System.out.print("Enter student name: "); 
        String studentName = scanner.nextLine(); // Read student name from input
        Student student = new Student(studentId, studentName); // Create a Student object with user input

        System.out.println("Hello " + student.getName() + "!");
        
        ArrayList<GolfCar> GolfCars = new ArrayList<>(); // Creating an ArrayList to store GolfCar objects
        // Creating and adding golf cars with specific attributes 
        GolfCar golfCar1 = new GolfCar(1, 6, "Gate1", "8:00 AM"); // Create a golf car object
        GolfCars.add(golfCar1); // Add the golf car to the ArrayList
        GolfCar golfCar2 = new GolfCar(2, 4, "Gate2", "9:00 AM"); 
        GolfCars.add(golfCar2);
        GolfCar golfCar3 = new GolfCar(3, 6, "Gate3", "10:00 AM"); 
        GolfCars.add(golfCar3);
        GolfCar golfCar4 = new GolfCar(4, 8, "Gate4", "11:00 AM"); 
        GolfCars.add(golfCar4);
        GolfCar golfCar5 = new GolfCar(5, 6, "Gate5", "12:00 PM"); 
        GolfCars.add(golfCar5);

        ArrayList<Reservation> reservations = new ArrayList<>();

        int choice;
        do {
            System.out.println("--------Welcome to Golf car KAU--------");
            PrintSchedule(GolfCars);
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Make a reservation
                    System.out.println("Making a reservation...");
                    System.out.print("Enter golf car number: ");
                    int golfCarNum = scanner.nextInt();
                    System.out.print("Enter seat number: ");
                    int seatNum = scanner.nextInt();

                    GolfCar selectedCar = null;
                    for (GolfCar car : GolfCars) {
                        if (car.getGolf_Number() == golfCarNum) {
                            selectedCar = car;
                            break;
                        }
                    }

                    if (selectedCar != null) {
                        Reservation reservation = new Reservation(golfCarNum, seatNum, student);
                        if (reservation.createReservation(golfCarNum, seatNum, student, selectedCar.getSeats())) {
                            reservations.add(reservation);
                        }
                    } else {
                        System.out.println("No golf car with the entered number exists. Please try again.");
                    }
                    break;
                case 2:
                    // Delete my reservation
                    System.out.println("Deleting a reservation...");
                    System.out.print("Enter reservation number to cancel: ");
                    int reservationNumToCancel = scanner.nextInt();
                    boolean found = false;
                    for (int i = 0; i < reservations.size(); i++) {
                        if (reservations.get(i).getReservationNum() == reservationNumToCancel) {
                            reservations.get(i).cancelReservation(reservationNumToCancel);
                            System.out.println("Reservation cancelled.");
                            reservations.remove(i); // Remove the reservation from the list
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No reservation with the given number exists. Please try again.");
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
        System.out.println("GolfCarNO | Destination | Time     | Seats Number");
        System.out.println("-----------------------------------------------");
        for (GolfCar car : GolfCars) {
            System.out.printf("%-10d| %-12s| %-9s| %-13d%n",
                    car.getGolf_Number(), car.getLocation(), car.getTime(), car.getSeats());
        }
        System.out.println("-----------------------------------------------");
        System.out.print("Choose the appropriate number\n");
        System.out.println("1. Make a reservation");
        System.out.println("2. Delete my reservation");
        System.out.println("3. Modify reservation");
        System.out.println("4. EXIT");
    }

}
