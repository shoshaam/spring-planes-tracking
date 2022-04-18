package airplane.tracking.api.aviationstackapi.service;
import airplane.tracking.api.db.repository.AirplaneRepository;
import airplane.tracking.api.db.repository.AirportRepository;
import airplane.tracking.api.db.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AviationStackUpdateService implements ApiUpdateService {

    private final ApiDownloadService apiDownloadService;

    private final AirplaneRepository airplaneRepository;
    private final AirportRepository airportRepository;
    private final FlightRepository flightRepository;

    @Override
    public void startUpdating() {
        airplaneRepository.saveAll(apiDownloadService.getAirplaneList());
        airportRepository.saveAll(apiDownloadService.getAirportList());
        flightRepository.saveAll(apiDownloadService.getFlightList());
    }
}
