package airplane.tracking.api.aviationstackapi.service;

import airplane.tracking.api.db.domain.Airport;
import airplane.tracking.api.db.domain.Flight;
import airplane.tracking.api.db.domain.airplane.Airplane;
import airplane.tracking.api.db.repository.AirplaneRepository;
import airplane.tracking.api.db.repository.AirportRepository;
import airplane.tracking.api.aviationstackapi.client.AviationstackClient;
import airplane.tracking.api.aviationstackapi.dto.FlightDTO;
import airplane.tracking.api.aviationstackapi.json.Deserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class AviationstackDownloadService implements ApiDownloadService{
    @Autowired
    AviationstackClient aviationstackClient;

    @Autowired
    Deserializer<Airport> airportDeserializer;
    @Autowired
    Deserializer<Airplane> airplaneDeserializer;
    @Autowired
    Deserializer<FlightDTO> flightDeserializer;

    @Autowired
    AirplaneRepository airplaneRepository;
    @Autowired
    AirportRepository airportRepository;

    @Override
    public List<Airport> getAirportList() {
        return airportDeserializer.deserialize(aviationstackClient.getAirports(), Airport.class);
    }

    @Override
    public List<Airplane> getAirplaneList() {
        return airplaneDeserializer.deserialize(aviationstackClient.getAirplanes(), Airplane.class);
    }

    @Override
    public List<Flight> getFlightList() {
        List<Flight> flightList = new ArrayList<>();
        List<FlightDTO> flightDTOs = flightDeserializer.deserialize(aviationstackClient.getFligths(), FlightDTO.class);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        for (FlightDTO flightDTO : flightDTOs) {
            flightList.add(Flight.builder()
                    .id(1L)
                    .depIata(airportRepository.findByIataCode(flightDTO.departure.iata))
                    .depScheduled(LocalDateTime.parse(flightDTO.departure.scheduled, formatter))
                    .arrIata(airportRepository.findByIataCode(flightDTO.arrival.iata))
                    .arrScheduled(LocalDateTime.parse(flightDTO.arrival.scheduled, formatter))
                    .planeRegistrationNumber(airplaneRepository.findByRegistrationNumber(flightDTO.aircraft.registration))
                    .isGround(flightDTO.live.isGround).build());
        }
        return flightList;
    }
}
