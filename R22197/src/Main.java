import flights.data.FlightsProvider;
import flights.scanner.FlightSearchScanner;

public class Main {
    public static void main(String[] args) {

        FlightSearchScanner flightSearchScanner = new FlightSearchScanner();
        flightSearchScanner.execute(FlightsProvider.getInstance().getFlights());

        /*

        Program umožňuje uživateli vyhledat seznam letů podle zadaných parametrů.
        Poté má možnost, jaký algoritmus chce uživatel použít, případně vyhledat nový list.

        * Pokud nejsou zadány parametry, tak se vypíše celý list letů.

         */

    }
}