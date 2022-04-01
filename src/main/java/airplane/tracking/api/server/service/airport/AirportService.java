package airplane.tracking.api.server.service.airport;

import airplane.tracking.api.db.domain.airplane.AirplaneInAirport;
import airplane.tracking.api.db.domain.Airport;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс сервисов аэропорта
 */
public interface AirportService{

    /**
     * Возвращает список всех объектов
     * @return - коллекция с объектами
     */
    List<Airport> getAll();

    /**
     * Возвращает объект с заданным айди
     * @param id - айди объекта
     * @return - объект
     */
    Optional<Airport> getById(Long id);

    /**
     * Возвращает список какие в данный момент самолёты должны прибыть или убыть из аэропорта
     * @param id - айди объекта
     * @return - объект
     */
    List<AirplaneInAirport> getAirplanesInformationById(Long id);

}

