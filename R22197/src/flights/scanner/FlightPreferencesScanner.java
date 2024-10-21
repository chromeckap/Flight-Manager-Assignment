package flights.scanner;

import flights.data.FlightsProvider;
import flights.manager.FlightManager;
import flights.model.Flight;
import flights.strategy.CheapestFlightsStrategy;
import flights.strategy.ComfortableFlightsStrategy;
import flights.strategy.FastestFlightsStrategy;
import flights.strategy.SearchFlightsStrategy;
import java.util.List;
import java.util.Scanner;

public class FlightPreferencesScanner implements ActionPerformer {
    private final FlightManager flightManager;
    private final Scanner scanner;

    public FlightPreferencesScanner() {
        flightManager = new FlightManager();
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute(List<Flight> flights) {
        printMenu();
        int choice = getUserChoice();

        switch (choice) {
            case 1 -> searchAndPrintFlights(new CheapestFlightsStrategy(), flights);
            case 2 -> searchAndPrintFlights(new FastestFlightsStrategy(), flights);
            case 3 -> searchFlightsByClassType(flights);
            case 4 -> new FlightSearchScanner().execute(FlightsProvider.getInstance().getFlights());
            case 5 -> System.out.println("Program byl bezpečně ukončen.");
            default -> {
                System.out.println("Číslo není v seznamu možných výběrů.");
                execute(flights);
            }
        }
    }

    private void printMenu() {
        System.out.println("\nCo pro Vás dále mohu udělat? Vyberte si číslo.");
        System.out.println("1 - Výpis letů od nejlevnějšího.");
        System.out.println("2 - Výpis letů od nejrychlejšího.");
        System.out.println("3 - Výpis letů podle třídy.");
        System.out.println("4 - Zadání nových parametrů pro let.");
        System.out.println("5 - Ukončení programu.");
        System.out.print("Zadejte číslo: ");
    }

    private int getUserChoice() {
        int choice;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            System.out.println("Zadána neplatná hodnota.");
            choice = 0;
        }
        scanner.nextLine();
        return choice;
    }

    private void searchAndPrintFlights(SearchFlightsStrategy strategy, List<Flight> filteredFlights) {
        flightManager.setSearchStrategy(strategy);
        System.out.println(" ");
        System.out.println(strategy.getStrategyName() + ":");
        flightManager.printInfo(flightManager.execute(filteredFlights));
        execute(filteredFlights);
    }

    private void searchFlightsByClassType(List<Flight> filteredFlights) {
        System.out.print("Zadejte jaký typ třídy chcete (business/ekonomická): ");
        String classType = scanner.nextLine();
        ComfortableFlightsStrategy strategy = new ComfortableFlightsStrategy(classType);
        searchAndPrintFlights(strategy, filteredFlights);
    }
}