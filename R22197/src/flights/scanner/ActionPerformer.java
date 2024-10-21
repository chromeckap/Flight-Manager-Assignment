package flights.scanner;

import flights.model.Flight;
import java.util.List;

public interface ActionPerformer {
    void execute(List<Flight> flights);
}
