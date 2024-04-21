package project251_ADD;

import java.util.ArrayList;

/**
 *
 * @author linahani
 */
public class GolfCar {

    private int Golf_Number;
    private int seats; //number of seat in golf
    private String Location; //location of golf
    private String Time;
    private ArrayList<String> waitList;

    public GolfCar(int Golf_Number, int seats, String Location, String Time, ArrayList<String> waitList) {
        this.Golf_Number = Golf_Number;
        this.seats = seats;
        this.Location = Location;
        this.Time = Time;
        this.waitList = waitList;
    }
    
    public GolfCar(int Golf_Number, int seats, String Location, String Time) {
        this.Golf_Number = Golf_Number;
        this.seats = seats;
        this.Location = Location;
        this.Time = Time;
    }

    public int getGolf_Number() {
        return Golf_Number;
    }

    public int getSeats() {
        return seats;
    }

    public String getLocation() {
        return Location;
    }

    public String getTime() {
        return Time;
    }

    public ArrayList<String> getWaitList() {
        return waitList;
    }

}
