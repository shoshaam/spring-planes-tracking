package airplane.tracking.api.db.domain;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Домэйн класс аэропорта
 */
@Getter
@Builder(toBuilder = true)
@Entity
@Table(name = "airports")
@NoArgsConstructor
@AllArgsConstructor
public class Airport implements Serializable {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @SerializedName(value = "iata_code")
    @NonNull
    @Column(name = "iata_code")
    @NaturalId
    private String iataCode;

    @SerializedName(value = "airport_name")
    @NonNull
    @Column(name = "airport_name")
    private String airportName;
}