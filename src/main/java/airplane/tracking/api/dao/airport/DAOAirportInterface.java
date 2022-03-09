package airplane.tracking.api.dao.airport;

import airplane.tracking.api.dao.DAO;
import airplane.tracking.api.domain.Airport;
import java.util.Optional;

public interface DAOAirportInterface extends DAO<Airport> {
    Optional<Airport> getAirplanesInformationById(Long id);
}
