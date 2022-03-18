package airplane.tracking.api.domain;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.persistence.*;

/**
 * Домэйн класс аэропорта
 */
@Getter
@Builder(toBuilder = true)
@Entity
@Table(name = "airports")
@NoArgsConstructor
@AllArgsConstructor
public class Airport {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @SerializedName(value = "iata_code")
    @NonNull
    @Column(name = "iata_code")
    private String iataCode;

    @SerializedName(value = "airport_name")
    @NonNull
    @Column(name = "airport_name")
    private String airportName;

    //самолёты в аэропорте, по дефолту null
    /*@Setter
    @Builder.Default
    private List<Airplane> airplanes = null;*/
}