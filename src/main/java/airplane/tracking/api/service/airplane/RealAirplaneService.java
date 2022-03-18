package airplane.tracking.api.service.airplane;

import airplane.tracking.api.domain.Airplane;
import airplane.tracking.api.repository.AirplaneRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для самолётов. Бизнес логика
 */
@Service
@RequiredArgsConstructor
public class RealAirplaneService implements AirplaneService{

    @NonNull
    private AirplaneRepository airplaneRepository;

    @Override
    public List<Airplane> getAll() {
        return airplaneRepository.findAll();
    }

    @Override
    public List<Airplane> getAllWithPlace() {
        return airplaneRepository.findAll();
        //return airplaneRepository.getAllWithPlace();
    }

    @Override
    public Optional<Airplane> getByIdWithPlace(Long id) {
        return airplaneRepository.findById(id);
        //return airplaneRepository.getByIdWithPlace(id);
    }

    @Override
    public Optional<Airplane> getById(Long id) {
        return airplaneRepository.findById(id);
    }
}
