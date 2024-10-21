package flights.strategy;

import flights.model.Flight;
import java.util.ArrayList;
import java.util.List;

public class ComfortableFlightsStrategy implements SearchFlightsStrategy {
    private final String classType;

    public ComfortableFlightsStrategy(String classType) {
        this.classType = classType;
    }

    @Override
    public List<Flight> execute(List<Flight> flights) {
        List<Flight> comfortableFlights = new ArrayList<>();

        // Pokud by byl check box, tak by se mohla použít třída enum.
        if (!classType.equals("ekonomická") && !classType.equals("business")) {
            System.out.println("Špatně zadaná třída.");
            return comfortableFlights;
        }

        for (Flight l : flights) {
            if (l.getClassType().equals(classType)) {
                comfortableFlights.add(l);
            }
        }
        return comfortableFlights;
    }

    @Override
    public String getStrategyName() {
        return "Lety podle třídy";
    }
}