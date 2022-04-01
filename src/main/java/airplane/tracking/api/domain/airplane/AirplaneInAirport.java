package airplane.tracking.api.domain.airplane;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.persistence.*;

/**
 * Домэйн класс самолёта в аэропорте (статус приезжает/убывает)
 */
@Getter
@NoArgsConstructor @AllArgsConstructor
@Entity
@SqlResultSetMapping(name = "AirplaneA", classes = @ConstructorResult(targetClass = AirplaneInAirport.class,
        columns = { @ColumnResult(name = "airplane_id", type = Long.class),
                @ColumnResult(name = "production_line", type = String.class),
                @ColumnResult(name = "registration_number", type = String.class),
                @ColumnResult(name = "airplane_status", type = String.class)}))
public class AirplaneInAirport {
    @Id
    @NonNull
    @SerializedName(value = "id")
    private Long airplaneId;

    @NonNull
    @SerializedName(value = "production_line")
    private String productionLine;

    @NonNull
    @SerializedName(value = "registration_number")
    private String registrationNumber;

    @NonNull
    @SerializedName(value = "airplane_status")
    private String airplaneStatus;
}
