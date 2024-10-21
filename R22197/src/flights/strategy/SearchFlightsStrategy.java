package flights.strategy;

import flights.model.Flight;
import java.util.List;

public interface SearchFlightsStrategy {
    List<Flight> execute(List<Flight> flights);
    String getStrategyName();
}