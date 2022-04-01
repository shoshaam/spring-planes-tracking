package airplane.tracking.api.db.domain;

import airplane.tracking.api.db.domain.airplane.Airplane;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Домэйн класс полёта
 */
@Getter
@Builder(toBuilder = true)
@Entity
@Table(name = "flights")
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @SerializedName(value = "dep_iata")
    @ManyToOne
    @JoinColumn(name="dep_iata", referencedColumnName = "iata_code")
    private Airport depIata;

    @SerializedName(value = "dep_scheduled")
    @NonNull
    @Column(name = "dep_scheduled")
    private LocalDateTime depScheduled;

    @SerializedName(value = "arr_iata")
    @ManyToOne
    @JoinColumn(name="arr_iata", referencedColumnName = "iata_code")
    private Airport arrIata;

    @SerializedName(value = "arr_sheduled")
    @NonNull
    @Column(name = "arr_sheduled")
    private LocalDateTime arrScheduled;

    @SerializedName(value = "plane_registration_number")
    @ManyToOne
    @JoinColumn(name = "plane_registration_number", referencedColumnName = "registration_number")
    private Airplane planeRegistrationNumber;

    @SerializedName(value = "is_ground")
    @NonNull
    @Column(name = "is_ground")
    private boolean isGround;

}
