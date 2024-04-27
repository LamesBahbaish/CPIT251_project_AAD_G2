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

    public void SetSeats(int num) {
        seats = num;
    }

    public String getLocation() {
        return Location;
    }

    public String getTime() {
        return Time;
    }

    public void addToWaitList(String name) {
        waitList.add(name);
    }

    public ArrayList<String> getWaitList() {
        return waitList;
    }

    public void updateSeat(int num) {
        seats = seats - num;
    }

    public void addSeat(int num) {
        seats = seats + num;
    }

}
