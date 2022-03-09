package airplane.tracking.api.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * Домэйн класс самолёта
 */
@Getter
@Builder(toBuilder = true)
public class Airplane {

    @NonNull
    private Long id;

    @SerializedName(value = "production_line")
    @NonNull
    private String productionLine;

    @SerializedName(value = "registration_number")
    @NonNull
    private String registrationNumber;

    // текущее местонахождение, null по дефолту
    @Builder.Default
    private String place = null;

    // текущий статус (прибывает/отбывает) null по дефолту
    @Builder.Default
    private Status status = null;
}
