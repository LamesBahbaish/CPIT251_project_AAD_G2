package project251_ADD;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner;
    static ArrayList<Reservation> reservations = new ArrayList<>();
    static ArrayList<GolfCar> GolfCars = new ArrayList<>();

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

        // Creating and adding golf cars with specific attributes 
        GolfCar trip1 = new GolfCar(1, 1, 2, "Gate1", "8:00 AM"); // Create a golf car object
        GolfCars.add(trip1); // Add the golf car to the ArrayList
        GolfCar trip2 = new GolfCar(2, 1, 0, "Gate3", "9:30 AM");
        GolfCars.add(trip2); // Add the golf car to the ArrayList
        GolfCar trip3 = new GolfCar(3, 2, 4, "Gate2", "9:00 AM");
        GolfCars.add(trip3);
        GolfCar trip4 = new GolfCar(4, 3, 6, "Gate3", "10:00 AM");
        GolfCars.add(trip4);
        GolfCar trip5 = new GolfCar(5, 4, 8, "Gate4", "11:00 AM");
        GolfCars.add(trip5);
        GolfCar trip6 = new GolfCar(6, 5, 6, "Gate5", "12:00 PM");
        GolfCars.add(trip6);

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
                    boolean flagTrip = false;
                    System.out.println("Making a reservation...");
                    do {
                        System.out.print("Enter golf trip number: ");
                        golfTripNum = scanner.nextInt();
                        for (GolfCar car : GolfCars) {
                            if (car.getGolfTripNum() == golfTripNum) {
                                //flagTrip = true;
                                selectedCar = car;
                                break;
                            }
                        }
                        if (selectedCar == null) {
                            System.out.println("No golf car with the entered number exists. Please try again.");
                        }
                    } while (selectedCar == null);

                    if (selectedCar.getSeats() == 0) {
                        System.out.println("Sorry! No seat available.");
                        System.out.print("Do you want to add your name to the waiting list? (yes/no): ");
                        String addToWaitList = scanner.next().toLowerCase();
                        if (addToWaitList.equals("yes")) {
                            selectedCar.addToWaitList(studentName);
                            System.out.println("Your name has been added to the waiting list.");
                            System.exit(0);
                        }
                        break;
                    }

                    if (selectedCar != null && selectedCar.getSeats() > 0) {
                        CreateReservation(selectedCar, student);
                    }
                    break;

                case 2:
                    // Delete my reservation
                    System.out.println("Cancel a reservation...");
                    // Display all reservations
                    if (!reservations.isEmpty()) {
                        MyReservations();
                        CancelReservation();

                    } else {
                        System.out.println("You don't have any reservations");
                    }

                    break;

                case 3:
                    if (!reservations.isEmpty()) {
                        MyReservations();
                        ModifyReservation();
                    } else {
                        System.out.println("You don't have any reservations");
                    }

                    break;
                case 4:
                    // Print all reservations
                    if (!reservations.isEmpty()) {
                        MyReservations();
                    } else {
                        System.out.println("You don't have any reservations");

                    }
                    break;
                case 5:
                    // Exit
                    System.out.println("Thank you for using Golf car KAU. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        } while (choice != 5);

    }

    public static void PrintSchedule(ArrayList<GolfCar> GolfCars) {

        System.out.println("-------------------------------------------------");
        System.out.println("                Golf Car Schedule                ");
        System.out.println("-------------------------------------------------");
        System.out.println("GolfTripNO | GolfCarNO | Destination | Time     | Seats Number");
        System.out.println("------------------------------------------------------------");
        for (GolfCar car : GolfCars) {
            System.out.printf("%-11d| %-10d| %-12s| %-9s| %-13d%n",
                    car.getGolfTripNum(), car.getGolf_Number(), car.getDestination(), car.getTime(), car.getSeats());
        }
        System.out.println("------------------------------------------------------------");

    }

    public static void displayMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.print("Choose the appropriate number\n");
        System.out.println("1. Make a Reservation");
        System.out.println("2. Cancel My Reservation");
        System.out.println("3. Modify Reservation");
        System.out.println("4. My Reservations");
        System.out.println("5. EXIT");
        System.out.println("-------------------------------------------------");
    }

    public static boolean CheckStudentId(int StudentID) {
        if (String.valueOf(StudentID).length() != 7) {
            System.out.println("Please enter a 7-digit student ID. ");
            return false;
        }
        return true;
    }

    public static void CreateReservation(GolfCar selectedCar, Student student) {
        int seatsToBook;
        boolean checkSeatsFlag = true;
        do {
            System.out.print("Enter number of seats to book:");
            seatsToBook = scanner.nextInt();
            checkSeatsFlag = checkSeats(seatsToBook, selectedCar.getSeats());
        } while (!checkSeatsFlag);
        Reservation reserve = new Reservation(selectedCar.getGolfTripNum(), selectedCar.getGolf_Number(), seatsToBook, student); //reserve
        reservations.add(reserve);
        selectedCar.ReserveSeat(seatsToBook);
        System.out.println("Booking successful! Your Reservation Number: " + reserve.getReservationNum());
    }

    public static boolean checkSeats(int seats, int totalSeats) {

        if (seats <= 0) {
            System.out.println("Invalid number of seats. Please enter a valid number.");
            return false;
        } else if (seats > totalSeats) {
            System.out.println("The seat number is more than the capacity. Please try again.");
            return false;
        }
        return true;
    }

    public static void MyReservations() {

        System.out.println("All reservations:");
        for (int i = 0; i < reservations.size(); i++) {
            System.out.println((i + 1) + ". Reservation Number: " + reservations.get(i).getReservationNum() + ", Trip Number: " + reservations.get(i).getGolfTripNum() + ", Seat Number: " + reservations.get(i).getSeatNum());

        }
    }

    public static void CancelReservation() {
        // Prompt the user to select which reservation to cancel
        System.out.print("Enter the number of the trip reservation you want to cancel: ");
        int tripNumToCancel = scanner.nextInt();
        int reservationNumToCancel = 0;
        boolean found = false;
        for (Reservation res : reservations) {
            if (res.getGolfTripNum() == tripNumToCancel) {
                reservationNumToCancel = res.getReservationNum();
                found = true;
                break;
            }
        }
        if (found) {
            // Remove the reservation
            for (int i = 0; i < reservations.size(); i++) {
                if (reservations.get(i).getReservationNum() == reservationNumToCancel) {
                    Reservation canceledReservation = reservations.remove(i);
                    // Find the corresponding golf car
                    for (GolfCar car : GolfCars) {
                        if (car.getGolfTripNum() == tripNumToCancel) {
                            // Add back the canceled seats to the golf car
                            car.addSeat(canceledReservation.getSeatNum());
                            break;
                        }
                    }
                    System.out.println("Reservation " + reservationNumToCancel + 1 + " canceled successfully.");
                    break;
                }
            }
        } else {
            System.out.println("Invalid trip number or you don't have a reservation for that trip.");
        }
    }

    public static void ModifyReservation() {
        boolean checkSeatsFlag;
        int newSeatNum = 0;
        int oldSeatNum = 0;
        GolfCar selectedCar = null;
        int reservationNumToModify;
        boolean tripFound = false;

        System.out.print("Enter the number of the trip reservation you want to cancel: ");
        int tripNumToModify = scanner.nextInt();

        for (GolfCar car : GolfCars) {
            if (car.getGolfTripNum() == tripNumToModify) {
                selectedCar = car;
                break;
            }
        }
        for (Reservation res : reservations) {
            if (res.getGolfTripNum() == tripNumToModify) {
                reservationNumToModify = res.getReservationNum();
                oldSeatNum = res.getSeatNum();
                tripFound = true;
                break;
            }
        }
        if (tripFound) {
            do {
                System.out.print("Enter number of seats to book:");
                newSeatNum = scanner.nextInt();
                int totalSeat = (selectedCar.getSeats() + oldSeatNum);
                checkSeatsFlag = checkSeats(newSeatNum, totalSeat);
            } while (!checkSeatsFlag);

            selectedCar.addSeat(oldSeatNum);
            selectedCar.ReserveSeat(newSeatNum);

            for (Reservation res : reservations) {
                if (res.getGolfTripNum() == tripNumToModify) {
                    res.setSeatNum(newSeatNum);
                    break;
                }
            }
            System.out.println("Reservation modified successfully.");
        } else {
            System.out.println("Invalid trip number or you don't have a reservation for that trip.");
        }
    }
}