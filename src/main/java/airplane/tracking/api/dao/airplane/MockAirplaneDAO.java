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
        airplanesWithPlace.put(++id, Airplane.builder().id(id).productionLine("Boeing 737 Classic").registrationNumber("YR-BAC").place("Minsk").build());
        airplanesWithPlace.put(++id, Airplane.builder().id(id).productionLine("Airbus A380-800").registrationNumber("A6-EOT").place("Moscow").build());
        airplanesWithPlace.put(++id, Airplane.builder().id(id).productionLine("Airbus A380-800").registrationNumber("A9-EKA").build());
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

