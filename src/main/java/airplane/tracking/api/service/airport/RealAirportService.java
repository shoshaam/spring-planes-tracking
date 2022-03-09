package airplane.tracking.api.service.airport;

import airplane.tracking.api.dao.airport.DAOAirportInterface;
import airplane.tracking.api.domain.Airport;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Класс сервиса аэропорта. Бизнес логика
 */
@Service
@RequiredArgsConstructor
public class RealAirportService implements AirportService {

    @NonNull
    private final DAOAirportInterface dao;

    @Override
    public List<Airport> getAll(){
        return dao.getAll();
    }

    @Override
    public Optional<Airport> getById(Long id){
        return dao.getById(id);
    }

    @Override
    public Optional<Airport> getAirplanesInformationById(Long id) {
        return dao.getAirplanesInformationById(id);
    }
}