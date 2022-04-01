package airplane.tracking.api.server.service.airport;

import airplane.tracking.api.db.domain.airplane.AirplaneInAirport;
import airplane.tracking.api.db.domain.Airport;
import airplane.tracking.api.db.repository.AirportRepository;
import airplane.tracking.api.db.repository.StoredProcedureRepository;
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