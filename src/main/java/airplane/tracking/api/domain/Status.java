package airplane.tracking.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Статус самолёта: прибывает/убывает
 */
@AllArgsConstructor
public enum Status {
    DEPARTS("departs"),
    ARRIVES("arrives");

    @Getter
    private final String status;
}
