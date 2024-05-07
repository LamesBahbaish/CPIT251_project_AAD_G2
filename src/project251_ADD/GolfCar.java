package project251_ADD;

import java.util.ArrayList;

/**
 *
 * @author linahani
 */
public class GolfCar {

    private int golfTripNum;
    private int Golf_Number;
    private int seats; //number of seat in golf
    private String Destination; //location of golf
    private String Time;
    private ArrayList<String> waitList;

    public GolfCar(int golfTripNum, int Golf_Number, int seats, String Destination, String Time) {
        this.golfTripNum = golfTripNum;
        this.Golf_Number = Golf_Number;
        this.seats = seats;
        this.Destination = Destination;
        this.Time = Time;
    }

    public void setGolfTripNum(int golfTripNum) {
        this.golfTripNum = golfTripNum;
    }

    public int getGolfTripNum() {
        return golfTripNum;
    }

    public int getGolf_Number() {
        return Golf_Number;
    }

    public int getSeats() {
        return seats;
    }

    public String getDestination() {
        return Destination;
    }

    public String getTime() {
        return Time;
    }

    public void addToWaitList(String name) {
        if (getWaitList() == null) {
            waitList = new ArrayList<>();
        }
        waitList.add(name);
    }

    public ArrayList<String> getWaitList() {
        return waitList;
    }

    public void ReserveSeat(int num) {
        this.seats = seats - num;

    }

    public void addSeat(int num) {
        this.seats = seats + num;
    }

}