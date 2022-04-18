package airplane.tracking.api.db.repository;

import airplane.tracking.api.db.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    Airport findByIataCode(String iataCode);
}
