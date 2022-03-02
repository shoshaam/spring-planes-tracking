package airplane.tracking.api.service.airport;

import airplane.tracking.api.dao.airport.DAOAirportInterface;
import airplane.tracking.api.domain.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Класс сервиса аэропорта. Бизнес логика
 */
@Service
public class RealAirportService implements AirportService {
    
    private static DAOAirportInterface dao;

    @Autowired
    public RealAirportService(DAOAirportInterface dao) {
        RealAirportService.dao = dao;
    }

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