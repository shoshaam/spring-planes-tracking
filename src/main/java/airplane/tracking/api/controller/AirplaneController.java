package airplane.tracking.api.controller;

import airplane.tracking.api.domain.Airplane;
import airplane.tracking.api.service.airplane.AirplaneService;
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
@RequestMapping("airplane")
public class AirplaneController {
    private final AirplaneService service;

    @Autowired
    public AirplaneController(@Qualifier("realAirplaneService") AirplaneService airplaneService) {
        this.service = airplaneService;
    }

    @GetMapping()
    List<Airplane> getAirplanes(){
        return service.getAllWithPlace();
    }

    @GetMapping("/{id}")
    Optional<Airplane> getAirplanesById(@PathVariable Long id) throws ResponseStatusException {
        Optional<Airplane> airport = service.getByIdWithPlace(id);
        if (airport.isPresent()){
            return airport;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no airplane with this id");
        }
    }
}
