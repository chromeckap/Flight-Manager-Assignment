package flights.data;

import flights.model.Flight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightsProvider {
    private static FlightsProvider instance;
    private final List<Flight> flights;

    private FlightsProvider() {
        flights = new ArrayList<>();
    }

    private static Flight parseFlight(String line) {
        Pattern pattern = Pattern.compile("Let (.*), (.*) - (.*), odlet (.*) v (.*), přílet (.*) v (.*), aerolinka (.*), cena (.*) Kč, třída (.*).");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            return new Flight(
                    matcher.group(1),
                    matcher.group(2),
                    matcher.group(3),
                    LocalDate.parse(matcher.group(4), DateTimeFormatter.ofPattern("d.M.yyyy")),
                    LocalTime.parse(matcher.group(5),DateTimeFormatter.ofPattern("H:mm")),
                    LocalDate.parse(matcher.group(6), DateTimeFormatter.ofPattern("d.M.yyyy")),
                    LocalTime.parse(matcher.group(7),DateTimeFormatter.ofPattern("H:mm")),
                    matcher.group(8),
                    Integer.parseInt(matcher.group(9)),
                    matcher.group(10));
        } else {
            return null;
        }
    }

    public static FlightsProvider getInstance() {
        if (instance == null) {
            instance = new FlightsProvider();
            instance.loadFlights();
        }
        return instance;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    private void loadFlights() {
        List<String> lines = FileProvider.fileToStringLines("FlightsList.txt");
        for (String line : lines) {
            Flight flight = parseFlight(line);
            if (flight != null) {
                flights.add(flight);
            }
        }
    }
}
