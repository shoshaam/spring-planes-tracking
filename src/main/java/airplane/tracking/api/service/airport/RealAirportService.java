package airplane.tracking.api.service.airport;

import airplane.tracking.api.domain.airplane.AirplaneInAirport;
import airplane.tracking.api.domain.airport.Airport;
import airplane.tracking.api.repository.AirportRepository;
import airplane.tracking.api.repository.StoredProcedureRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Класс сервиса аэропорта. Бизнес логика
 */
@Service
@RequiredArgsConstructor
public class RealAirportService implements AirportService {

    @NonNull
    private AirportRepository airportRepository;
    @NonNull
    private StoredProcedureRepository storedProcedureRepository;

    @Override
    public List<Airport> getAll(){
        return airportRepository.findAll();
    }

    @Override
    public Optional<Airport> getById(Long id){
        return airportRepository.findById(id);
    }

    @Override
    public List<AirplaneInAirport> getAirplanesInformationById(Long id) {
        return storedProcedureRepository.getAirplanesInformationById(id);
    }
}