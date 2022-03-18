package airplane.tracking.api.domain;

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

    // текущее местонахождение, null по дефолту
    @Builder.Default
    private String place = null;

    // текущий статус (прибывает/отбывает) null по дефолту
    @Builder.Default
    private Status status = null;
}
