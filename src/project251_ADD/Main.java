package project251_ADD;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID: "); 
        int studentId = scanner.nextInt(); 
        scanner.nextLine(); // Consume the remaining newline

        System.out.print("Enter student name: "); 
        String studentName = scanner.nextLine(); 
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

        int choice = 0;
        do {
            System.out.println("--------Welcome to Golf car KAU--------");
            PrintSchedule(GolfCars);
            System.out.print("Enter:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Make a reservation");
                    break;
                case 2:
                    System.out.println("Delete my reservation");
                    break;
                case 3:
                    System.out.println("Modify my reservation");
                    break;
                case 4:
                    System.out.println("Thanks");
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
