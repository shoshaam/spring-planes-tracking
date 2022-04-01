package airplane.tracking.api.controller;

import airplane.tracking.api.domain.airplane.AirplaneInAirport;
import airplane.tracking.api.domain.airport.Airport;
import airplane.tracking.api.service.airport.AirportService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("airport")
public class AirportController {

    @Qualifier("realAirportService") @NonNull
    private final AirportService service;

    @GetMapping()
    List<Airport> getAirports(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    Airport getAirportById(@PathVariable Long id) throws ResponseStatusException {
        return service.getById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no airport with this id"));
    }

    @GetMapping("/{id}/airplanes")
    @ResponseBody
    List<AirplaneInAirport> getAirportAirplanesListById(@PathVariable Long id) throws ResponseStatusException {
        return service.getAirplanesInformationById(id);
    }
}
