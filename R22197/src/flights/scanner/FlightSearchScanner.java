package flights.scanner;

import flights.manager.FlightList;
import flights.model.Flight;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FlightSearchScanner implements ActionPerformer {
    private FlightList flightList;
    private Scanner scanner;

    @Override
    public void execute(List<Flight> flights) {
        flightList = new FlightList(flights);
        scanner = new Scanner(System.in);

        System.out.println("Seznam letů - Pro přeskočení parametru stiskněte Enter.");

        String departureAirport = getAirportInput("Zadejte výchozí letiště: ");
        String arrivalAirport = getAirportInput("Zadejte cílové letiště: ");
        LocalDate departureDate = getDateInput("Zadejte datum odletu (např. 1.6.2023): ");
        LocalDate arrivalDate = getDateInput("Zadejte datum příletu (např. 1.6.2023): ");

        List<Flight> filteredFlights = flightList.filter(departureAirport, arrivalAirport, departureDate, arrivalDate);

        if (filteredFlights.isEmpty()) {
            System.out.println("\nBohužel nebyly nalezeny žádné lety splňující zadané kritéria.");
        } else {
            System.out.println("\nCelkem nalezeno " + filteredFlights.size() + " letů:");
            for (Flight flight : filteredFlights) {
                System.out.println(flight);
            }
        }
        new FlightPreferencesScanner().execute(filteredFlights);
    }

    private String getAirportInput(String message) {
        System.out.print(message);
        String airport = scanner.nextLine();
        if (!airport.isEmpty() && !flightList.airportExists(airport)) {
            System.out.println("Chyba! Zadané letiště neexistuje, proto parametr nebude použit.");
            return "";
        }
        return airport;
    }

    private LocalDate getDateInput(String message) {
        System.out.print(message);
        String dateString = scanner.nextLine();
        return flightList.validatedDateExists(dateString);
    }
}