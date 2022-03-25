package airplane.tracking.api.domain.airplane;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.persistence.*;

/**
 * Домэйн класс самолёта
 */
@Getter
@Builder(toBuilder = true)
@Entity
@Table(name = "airplanes")
@SecondaryTable(name = "airplanes_with_place", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
@NoArgsConstructor @AllArgsConstructor
public class Airplane {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @SerializedName(value = "production_line")
    @NonNull
    @Column(name = "production_line")
    private String productionLine;

    @SerializedName(value = "registration_number")
    @NonNull
    @Column(name = "registration_number")
    private String registrationNumber;

    @SerializedName(value = "place")
    @NonNull
    @Column(name = "where_airplane_is", table = "airplanes_with_place")
    private String place;
}
