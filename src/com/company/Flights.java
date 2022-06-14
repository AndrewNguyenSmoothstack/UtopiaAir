package com.company;

public class Flights {
    String flightId;
    String departTime;
    String seatsAvailable;
    String price;
    String arrivalTime;
    String flightNumber;

    Flights(String flightId, String departTime, String seatsAvailable, String price, String arrivalTime, String flightNumber) {
        this.flightId=flightId;
        this.departTime=departTime;
        this.seatsAvailable=seatsAvailable;
        this.price=price;
        this.arrivalTime=arrivalTime;
        this.flightNumber=flightNumber;

    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSeatsAvailable(String seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartTime() {
        return departTime;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getPrice() {
        return price;
    }

    public String getSeatsAvailable() {
        return seatsAvailable;
    }
}
