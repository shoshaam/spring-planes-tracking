package airplane.tracking.api.db.repository;

import airplane.tracking.api.db.domain.airplane.AirplaneInAirport;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoredProcedureRepository {

    private final EntityManager em;

    public List<AirplaneInAirport> getAirplanesInformationById(Long id) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("airport_airplanes_information", AirplaneInAirport.class);
        spq.registerStoredProcedureParameter("airport_id", Long.class, ParameterMode.IN);
        spq.setParameter("airport_id", id);
        return spq.getResultList();
    }
}
