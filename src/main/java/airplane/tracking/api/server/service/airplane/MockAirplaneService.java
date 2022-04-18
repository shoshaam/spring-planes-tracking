package airplane.tracking.api.server.service.airplane;

import airplane.tracking.api.db.domain.airplane.Airplane;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Тестовый сервис для самолётов
 */
@Service
public class MockAirplaneService implements AirplaneService {
    Map<Long, Airplane> airplanesWithPlace;

    {
        airplanesWithPlace = new HashMap<>();
        long id = 0;
        airplanesWithPlace.put(++id, Airplane.builder().id(id).productionLine("Boeing 737 Classic").registrationNumber("YR-BAC").place("Minsk").build());
        airplanesWithPlace.put(++id, Airplane.builder().id(id).productionLine("Airbus A380-800").registrationNumber("A6-EOT").place("Moscow").build());
    }

    @Override
    public List<Airplane> getAll() {
        return new ArrayList<>(airplanesWithPlace.values());
    }

    @Override
    public List<Airplane> getAllWithPlace() {
        return new ArrayList<>(airplanesWithPlace.values());
    }

    @Override
    public Optional<Airplane> getByIdWithPlace(Long id) {
        return Optional.ofNullable(airplanesWithPlace.get(id));
    }

    @Override
    public Optional<Airplane> getById(Long id) {
        return Optional.ofNullable(airplanesWithPlace.get(id));
    }
}
