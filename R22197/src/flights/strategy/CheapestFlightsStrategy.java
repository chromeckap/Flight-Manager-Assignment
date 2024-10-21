package flights.strategy;

import flights.model.Flight;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CheapestFlightsStrategy implements SearchFlightsStrategy {
    @Override
    public List<Flight> execute(List<Flight> flights) {
        List<Flight> shortestFlights = new ArrayList<>(flights);

        shortestFlights.sort(Comparator.comparingInt(Flight::getPrice));
        return shortestFlights;
    }

    @Override
    public String getStrategyName() {
        return "Nejlevnější lety";
    }
}