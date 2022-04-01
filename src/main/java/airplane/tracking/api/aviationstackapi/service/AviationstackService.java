package airplane.tracking.api.aviationstackapi.service;

import airplane.tracking.api.aviationstackapi.controller.ApiController;
import airplane.tracking.api.db.domain.Airport;
import airplane.tracking.api.db.domain.Flight;
import airplane.tracking.api.db.domain.airplane.Airplane;
import airplane.tracking.api.db.repository.AirplaneRepository;
import airplane.tracking.api.db.repository.AirportRepository;
import airplane.tracking.api.db.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Рабочий сервис обновления данных бд
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AviationstackService implements ApiService {

    private final AirplaneRepository airplaneRepository;
    private final AirportRepository airportRepository;
    private final FlightRepository flightRepository;

    @Qualifier("airplaneApiController")
    private final ApiController<Airplane> airplaneApiController;
    @Qualifier("airportApiController")
    private final ApiController<Airport> airportApiController;

    @Qualifier("flightApiController")
    private final ApiController<Flight> flightApiController;

    @Override
    public void startUpdating() {
        airplaneRepository.saveAll(airplaneApiController.getData());

        airportRepository.saveAll(airportApiController.getData());

        flightRepository.saveAll(flightApiController.getData());
    }
}

