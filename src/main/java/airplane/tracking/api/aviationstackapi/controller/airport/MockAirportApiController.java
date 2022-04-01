package airplane.tracking.api.aviationstackapi.controller.airport;


import airplane.tracking.api.aviationstackapi.controller.ApiController;
import airplane.tracking.api.db.domain.Airport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Тестовый контроллер получения данных о аэропортах
 */
@Component
public class MockAirportApiController implements ApiController<Airport> {
    @Override
    public List<Airport> getData() {
        List<Airport> airports = new ArrayList<>();
        long id = 0;
        airports.add(Airport.builder().id(++id).iataCode("FO").airportName("Minsk").build());
        airports.add(Airport.builder().id(++id).iataCode("FW").airportName("Moscow").build());
        return airports;
    }
}

