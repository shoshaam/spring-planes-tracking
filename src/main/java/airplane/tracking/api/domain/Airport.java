package airplane.tracking.api.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

/**
 * Домэйн класс аэропорта
 */
@Getter
@Builder(toBuilder = true)
public class Airport {

    @NonNull
    private Long id;

    @SerializedName(value = "iata_code")
    @NonNull
    private String iataCode;

    @SerializedName(value = "airport_name")
    @NonNull
    private String airportName;

    //самолёты в аэропорте, по дефолту null
    @Setter
    @Builder.Default
    private List<Airplane> airplanes = null;
}