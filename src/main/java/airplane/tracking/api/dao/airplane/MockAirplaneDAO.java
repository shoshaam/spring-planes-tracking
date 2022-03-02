package airplane.tracking.api.dao.airplane;

import airplane.tracking.api.domain.Airplane;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * Тестовая реализация дао для самолёта
 */
@Component
public class MockAirplaneDAO implements DAOAirplaneInterface {

    Map<Long, Airplane> airplanesWithPlace;

    {
        airplanesWithPlace = new HashMap<>();
        long id = 0;
        airplanesWithPlace.put(++id, new Airplane(id, "Boeing 737 Classic", "YR-BAC", "Minsk"));
        airplanesWithPlace.put(++id, new Airplane(id, "Airbus A380-800", "A6-EOT", "Moscow"));
        airplanesWithPlace.put(++id, new Airplane(id, "Airbus A380-800", "A9-EKA"));
    }

    @Override
    public List<Airplane> getAll() {
        return new ArrayList<>(airplanesWithPlace.values());
    }

    @Override
    public Optional<Airplane> getById(long id) {
        return Optional.ofNullable(airplanesWithPlace.get(id));
    }


    @Override
    public List<Airplane> getAllWithPlace() {
        return new ArrayList<>(airplanesWithPlace.values());
    }

    @Override
    public Optional<Airplane> getByIdWithPlace(long id) {
        return Optional.ofNullable(airplanesWithPlace.get(id));
    }
}

