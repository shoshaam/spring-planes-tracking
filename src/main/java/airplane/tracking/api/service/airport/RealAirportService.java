package airplane.tracking.api.service.airport;

import airplane.tracking.api.domain.Airport;
import airplane.tracking.api.repository.AirportRepository;
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

    @Override
    public List<Airport> getAll(){
        return airportRepository.findAll();
    }

    @Override
    public Optional<Airport> getById(Long id){
        return airportRepository.findById(id);
    }

    @Override
    public Optional<Airport> getAirplanesInformationById(Long id) {
        return airportRepository.findById(id);
    }
}