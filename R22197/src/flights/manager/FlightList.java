package flights.manager;

import flights.model.Flight;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class FlightList {
    private final List<Flight> flights;

    public FlightList(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> filter(String departureAirport, String arrivalAirport, LocalDate departureDate, LocalDate arrivalDate) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if ((departureAirport.isEmpty() || flight.getDepartureAirport().equals(departureAirport))
                    && (arrivalAirport.isEmpty() || flight.getArrivalAirport().equals(arrivalAirport))
                    && (departureDate == null || flight.getDepartureDate().equals(departureDate))
                    && (arrivalDate == null || flight.getArrivalDate().equals(arrivalDate))) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

    // Mohlo by se rozdělit na departureAirportExists a arrivalAirportExists.
    public boolean airportExists(String airportName) {
        for (Flight flight : flights) {
            if (flight.getDepartureAirport().equals(airportName) || flight.getArrivalAirport().equals(airportName)) {
                return true;
            }
        }
        return false;
    }

    public LocalDate validatedDateExists(String dateString) {
        if (!dateString.isEmpty()) {
            try {
                LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("d.M.yyyy"));
                boolean isDateFound = false;
                for (Flight flight : flights) {
                    if (flight.getDepartureDate().equals(date) || flight.getArrivalDate().equals(date)) {
                        isDateFound = true;
                        break;
                    }
                }
                if (isDateFound) {
                    return date;
                } else {
                    System.out.println("Chyba! Zadané datum není nalezeno v seznamu letů, proto parametr nebude použit.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Chyba! Zadaný formát data není správný, proto parametr nebude použit.");
            }
        }
        return null;
    }
}