package airplane.tracking.api.aviationstackapi.controller.airplane;

import airplane.tracking.api.aviationstackapi.controller.ApiController;
import airplane.tracking.api.db.domain.airplane.Airplane;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Тестовый контроллер получения данных о самолётах
 */
@Component
public class MockAirplaneApiController implements ApiController<Airplane> {
    @Override
    public List<Airplane> getData() {
        List<Airplane> airplanes = new ArrayList<>();
        long id = 0;
        airplanes.add(Airplane.builder().id(++id).productionLine("Boeing 737 Classic").registrationNumber("-BAC").build());
        airplanes.add(Airplane.builder().id(++id).productionLine("Boeing 737 Classic").registrationNumber("60AN").build());
        airplanes.add(Airplane.builder().id(++id).productionLine("Airbus A380-800").registrationNumber("-EOT").build());
        return airplanes;
    }
}

