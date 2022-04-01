package airplane.tracking.api.aviationstackapi.controller.flight;

import airplane.tracking.api.aviationstackapi.controller.ApiController;
import airplane.tracking.api.aviationstackapi.dto.FlightDTO;
import airplane.tracking.api.aviationstackapi.json.Deserializer;
import airplane.tracking.api.db.domain.Flight;
import airplane.tracking.api.db.repository.AirplaneRepository;
import airplane.tracking.api.db.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Контроллер получения даннных о полётах из стороненного апи
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlightApiController implements ApiController<Flight> {

    private final Deserializer<FlightDTO> flightDeserializer;

    private final AirplaneRepository airplaneRepository;
    private final AirportRepository airportRepository;

    @Override
    public List<Flight> getData() {
        List<Flight> flightList = new ArrayList<>();
        try {
            URL url = new URL("http://api.aviationstack.com/v1/flights?access_key=15f8adef7b604ce5114dfe4ef352d34b&limit=2");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException();
            } else {
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder json = new StringBuilder();
                while (scanner.hasNext()) {
                    json.append(scanner.nextLine());
                }
                scanner.close();
                List<FlightDTO> flightDTOs = flightDeserializer.deserialize(json.toString(), FlightDTO.class);
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

