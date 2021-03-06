package airplane.tracking.api.service.airport;

import airplane.tracking.api.domain.airplane.AirplaneInAirport;
import airplane.tracking.api.domain.airport.Airport;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Класс тестового сервиса аэропорта. Бизнес логика
 */
@Service
public class MockAirportService implements AirportService {

    Map<Long, Airport> airports;

    //добавление данных
    {
        airports = new HashMap<>();

        long id = 0;
        airports.put(++id, Airport.builder().id(1L).iataCode("JND55DS").airportName("Minsk").build());
        airports.put(++id, Airport.builder().id(2L).iataCode("JND475DS").airportName("Moscow").build());

    }

    @Override
    public List<Airport> getAll(){
        return new ArrayList<>(airports.values());
    }

    @Override
    public Optional<Airport> getById(Long id){
        return Optional.ofNullable(airports.get(id));
    }

    @Override
    public List<AirplaneInAirport> getAirplanesInformationById(Long id) {
        Map<Long, AirplaneInAirport> airplanesWithPlace = new HashMap<>();
        airplanesWithPlace.put(++id, new AirplaneInAirport(220L, "Airbus A380-800", "A6-EOT", "arrives"));
        return new ArrayList<>(airplanesWithPlace.values());
    }
}
