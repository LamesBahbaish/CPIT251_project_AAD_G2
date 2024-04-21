package project251_ADD;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<GolfCar> GolfCars = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        GolfCar golfCar1 = new GolfCar(1, 6, "Gate3", "10:00 AM");
        GolfCars.add(golfCar1);
        GolfCar golfCar2 = new GolfCar(2, 6, "Gate1", "8:00 AM");
        GolfCars.add(golfCar2);

        int choice = 0;
        do {
            System.out.println("--------Welcome in Golf car KAU--------");
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
