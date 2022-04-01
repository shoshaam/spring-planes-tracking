package airplane.tracking.api.aviationstackapi.controller.airplane;

import airplane.tracking.api.aviationstackapi.controller.ApiController;
import airplane.tracking.api.aviationstackapi.json.Deserializer;
import airplane.tracking.api.db.domain.airplane.Airplane;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 * Контроллер получения даннных о самолётах из стороненного апи
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AirplaneApiController implements ApiController<Airplane> {

    private final Deserializer<Airplane> airplaneDeserializer;

    @Override
    public List<Airplane> getData() {
        try {
            List<Airplane> airplaneList;
            URL url = new URL("http://api.aviationstack.com/v1/airplanes?access_key=15f8adef7b604ce5114dfe4ef352d34b&limit=2");
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
                airplaneList = airplaneDeserializer.deserialize(json.toString(), Airplane.class);
                return airplaneList;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

