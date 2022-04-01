package airplane.tracking.api.aviationstackapi.controller.flight;

import airplane.tracking.api.aviationstackapi.controller.ApiController;
import airplane.tracking.api.db.domain.Airport;
import airplane.tracking.api.db.domain.Flight;
import airplane.tracking.api.db.domain.airplane.Airplane;
import airplane.tracking.api.db.repository.AirplaneRepository;
import airplane.tracking.api.db.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Тестовый контроллер получения данных о полётах
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MockFlightApiController implements ApiController<Flight> {

    private final AirplaneRepository airplaneRepository;
    private final AirportRepository airportRepository;

    @Override
    public List<Flight> getData() {
        Airplane airplane = airplaneRepository.findByRegistrationNumber("Y-BAC");
        Airport airport = airportRepository.findByIataCode("SFO");

        List<Flight> flights = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        flights.add(Flight.builder().id(1L)
                .depIata(airport)
                .depScheduled(LocalDateTime.parse("2019-12-12T04:20:00", formatter))
                .arrIata(airport)
                .arrScheduled(LocalDateTime.parse("2019-12-12T04:20:00", formatter))
                .planeRegistrationNumber(airplane)
                .isGround(false).build());
        return flights;
    }
}
