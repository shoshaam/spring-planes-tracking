package airplane.tracking.api.controller;

import airplane.tracking.api.domain.Airport;
import airplane.tracking.api.service.airport.AirportService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
    Optional<Airport> getAirportById(@PathVariable Long id) throws ResponseStatusException {
        return Optional.ofNullable(service.getById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no airport with this id")));
    }

    @GetMapping("/{id}/airplanes")
    @ResponseBody
    Optional<Airport> getAirportAirplanesListById(@PathVariable Long id) throws ResponseStatusException {
        return Optional.ofNullable(service.getAirplanesInformationById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no airport with this id")));
    }
}
