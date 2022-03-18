package airplane.tracking.api.controller;

import airplane.tracking.api.domain.Airplane;
import airplane.tracking.api.service.airplane.AirplaneService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("airplane")
public class AirplaneController {

    @Qualifier("realAirplaneService") @NonNull
    private final AirplaneService service;

    @GetMapping()
    @ResponseBody
    List<Airplane> getAirplanes(){
        return service.getAllWithPlace();
    }

    @GetMapping("/{id}")
    @ResponseBody
    Airplane getAirplanesById(@PathVariable Long id) throws ResponseStatusException {
        return service.getByIdWithPlace(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no airplane with this id"));
    }
}
