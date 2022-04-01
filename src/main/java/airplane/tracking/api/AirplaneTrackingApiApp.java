package airplane.tracking.api;

import airplane.tracking.api.aviationstackapi.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AirplaneTrackingApiApp extends SpringBootServletInitializer {

    @Autowired
    ApiService apiService;

    @PostConstruct
    public void getApiData() {
      apiService.startUpdating();
    }

    public static void main(String[] args) {
        SpringApplication.run(AirplaneTrackingApiApp.class, args);
    }
}
