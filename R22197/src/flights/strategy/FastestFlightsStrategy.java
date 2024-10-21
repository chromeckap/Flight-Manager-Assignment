package flights.strategy;

import flights.model.Flight;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FastestFlightsStrategy implements SearchFlightsStrategy {
    @Override
    public List<Flight> execute(List<Flight> flights) {
        List<Flight> fastestFlights = new ArrayList<>(flights);

        Comparator<Flight> comparator = (l1, l2) -> {
            LocalDateTime departureDateTime1 = LocalDateTime.of(l1.getDepartureDate(), l1.getDepartureTime());
            LocalDateTime arrivalDateTime1 = LocalDateTime.of(l1.getArrivalDate(), l1.getArrivalTime());
            Duration duration1 = Duration.between(departureDateTime1, arrivalDateTime1);

            LocalDateTime departureDateTime2 = LocalDateTime.of(l2.getDepartureDate(), l2.getDepartureTime());
            LocalDateTime arrivalDateTime2 = LocalDateTime.of(l2.getArrivalDate(), l2.getArrivalTime());
            Duration duration2 = Duration.between(departureDateTime2, arrivalDateTime2);

            return duration1.compareTo(duration2);
        };
        fastestFlights.sort(comparator);
        return fastestFlights;
    }

    @Override
    public String getStrategyName() {
        return "Nejrychlejší lety";
    }
}