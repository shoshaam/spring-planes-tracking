package airplane.tracking.api.aviationstackapi.controller.airport;

import airplane.tracking.api.aviationstackapi.controller.ApiController;
import airplane.tracking.api.aviationstackapi.json.Deserializer;
import airplane.tracking.api.db.domain.Airport;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 * Контроллер получения даннных о аэропортах из стороненного апи
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AirportApiController implements ApiController<Airport> {

    private final Deserializer<Airport> airportDeserializer;

    @Override
    public List<Airport> getData() {
        try {
            List<Airport> airportList;
            URL url = new URL("http://api.aviationstack.com/v1/airports?access_key=15f8adef7b604ce5114dfe4ef352d34b&limit=2");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() != 200){
                throw new RuntimeException();
            }
            else {
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder json = new StringBuilder();
                while (scanner.hasNext()){
                    json.append(scanner.nextLine());
                }
                scanner.close();
                airportList = airportDeserializer.deserialize(json.toString(), Airport.class);
                return airportList;
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}

