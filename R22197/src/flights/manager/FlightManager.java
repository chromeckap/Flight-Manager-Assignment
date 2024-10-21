package flights.manager;

import flights.model.Flight;
import flights.strategy.SearchFlightsStrategy;
import java.util.List;

public class FlightManager {
    private SearchFlightsStrategy searchStrategy;

    public void setSearchStrategy(SearchFlightsStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public List<Flight> execute(List<Flight> flights) {
        return searchStrategy.execute(flights);
    }

    public void printInfo(List<Flight> flights) {
        for (Flight f : flights) {
            System.out.println(f.toString());
        }
    }
}