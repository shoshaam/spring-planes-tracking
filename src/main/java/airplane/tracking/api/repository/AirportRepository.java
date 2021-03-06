package airplane.tracking.api.repository;

import airplane.tracking.api.domain.airport.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}
