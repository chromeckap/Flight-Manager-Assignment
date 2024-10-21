package flights.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
    private final String departureAirport, arrivalAirport, airline, classType, ID;
    private final LocalDate departureDate, arrivalDate;
    private final LocalTime departureTime, arrivalTime;
    private final int price;

    public Flight(String ID, String departureAirport, String arrivalAirport, LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate, LocalTime arrivalTime, String airline, int price, String classType) {
        this.ID = ID;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.airline = airline;
        this.price = price;
        this.classType = classType;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getAirline() {
        return airline;
    }

    public String getClassType() {
        return classType;
    }

    public String getID() {
        return ID;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Let %s, %s - %s, odlet %s v %s, přílet %s v %s, aerolinka %s, cena %s Kč, třída %s.",
                ID, departureAirport, arrivalAirport, departureDate, departureTime, arrivalDate, arrivalTime, airline, price, classType);
    }
}