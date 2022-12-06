import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

public class Main_airport {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Flight> flights = findPlanesLeavingInTheNextTwoHours(airport);
        flights.forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        LocalDateTime currentTime = LocalDateTime.now();

        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE)
                .filter(flight -> flight.getDate().toInstant().atZone(ZoneId.systemDefault()).
                        toLocalDateTime().isAfter(currentTime) &&
                        flight.getDate().toInstant().atZone(ZoneId.systemDefault()).
                                toLocalDateTime().isBefore(currentTime.plusHours(2)))
                .collect(Collectors.toList());


    }
}