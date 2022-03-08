package airplane.tracking.api.dao.airport;

import airplane.tracking.api.domain.Airplane;
import airplane.tracking.api.domain.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Тестовая реализация дао для аэропорта
 */
@Component
public class MockAirportDAO implements DAOAirportInterface {

    Map<Long, Airport> airports;

    {
        airports = new HashMap<>();
        long id = 0;
        airports.put(++id, Airport.builder().id(1L).iataCode("JND475DS").airportName("Moscow").build());
        airports.put(++id, Airport.builder().id(2L).iataCode("JND55DS").airportName("Minsk").build());

        ArrayList<Airplane> airplanes = new ArrayList<>();
        id = 0;
        airplanes.add(Airplane.builder().id(++id).productionLine("Boeing 737 Classic").registrationNumber("YR-BAC").place("Minsk").build());
        airplanes.add(Airplane.builder().id(++id).productionLine("Airbus A380-800").registrationNumber("A6-EOT").place("Moscow").build());
        airports.get(1L).setAirplanes(airplanes);
    }

    @Override
    public List<Airport> getAll(){
        return new ArrayList<>(airports.values());
    }

    @Override
    public Optional<Airport> getById(long id) {
        return Optional.ofNullable(airports.get(id));
    }

    @Override
    public Optional<Airport> getAirplanesInformationById(Long id) {
        return Optional.ofNullable(airports.get(id));
    }
}

