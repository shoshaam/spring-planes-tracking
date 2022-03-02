package airplane.tracking.api.controller;

import airplane.tracking.api.domain.Airport;
import airplane.tracking.api.service.airport.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("airport")
public class AirportController {

    private final AirportService service;

    @Autowired
    public AirportController(@Qualifier("realAirportService") AirportService service) {
        this.service = service;
    }

    @GetMapping()
    List<Airport> getAirports(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    Optional<Airport> getAirportById(@PathVariable Long id) throws ResponseStatusException {
        Optional<Airport> airport = service.getById(id);
        if (airport.isPresent()){
            return airport;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no airport with this id");
        }
    }

    @GetMapping("/{id}/airplanes")
    Optional<Airport> getAirportAirplanesListById(@PathVariable Long id) throws ResponseStatusException {
        Optional<Airport> airport = service.getAirplanesInformationById(id);
        if (airport.isPresent()){
            return airport;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no airport with this id");
        }
    }
}
