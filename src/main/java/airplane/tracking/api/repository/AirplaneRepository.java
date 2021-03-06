package airplane.tracking.api.repository;

import airplane.tracking.api.domain.airplane.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM airplanes_with_place")
    List<Airplane> getAllWithPlace();

    @Query(nativeQuery = true,
            value = "SELECT * FROM airplanes_with_place WHERE id = ?1")
    Optional<Airplane> getByIdWithPlace(long id);
}
