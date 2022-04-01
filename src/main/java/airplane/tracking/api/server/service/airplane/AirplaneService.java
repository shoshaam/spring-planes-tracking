package airplane.tracking.api.server.service.airplane;

import airplane.tracking.api.db.domain.airplane.Airplane;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс сервисов самолётов
 */
public interface AirplaneService {
    List<Airplane> getAll();

    List<Airplane> getAllWithPlace();

    Optional<Airplane> getByIdWithPlace(Long id);

    Optional<Airplane> getById(Long id);
}
