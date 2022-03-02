package airplane.tracking.api.service.airplane;

import airplane.tracking.api.dao.airplane.DAOAirplaneInterface;
import airplane.tracking.api.domain.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для самолётов. Бизнес логика
 */
@Service
public class RealAirplaneService implements AirplaneService{

    private static DAOAirplaneInterface dao;

    @Autowired
    public RealAirplaneService(DAOAirplaneInterface dao) {
        RealAirplaneService.dao = dao;
    }

    @Override
    public List<Airplane> getAll() {
        return dao.getAll();
    }

    @Override
    public List<Airplane> getAllWithPlace() {
        return dao.getAllWithPlace();
    }

    @Override
    public Optional<Airplane> getByIdWithPlace(Long id) {
        return dao.getByIdWithPlace(id);
    }

    @Override
    public Optional<Airplane> getById(Long id) {
        return dao.getById(id);
    }
}
