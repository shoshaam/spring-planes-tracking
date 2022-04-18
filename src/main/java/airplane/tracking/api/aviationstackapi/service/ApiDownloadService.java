package airplane.tracking.api.aviationstackapi.service;

import airplane.tracking.api.db.domain.Airport;
import airplane.tracking.api.db.domain.Flight;
import airplane.tracking.api.db.domain.airplane.Airplane;

import java.util.List;

public interface ApiDownloadService {
    List<Airport> getAirportList();
    List<Airplane> getAirplaneList();
    List<Flight> getFlightList();
}
