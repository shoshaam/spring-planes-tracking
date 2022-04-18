package airplane.tracking.api;

import airplane.tracking.api.aviationstackapi.service.ApiUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableFeignClients
public class AirplaneTrackingApiApp extends SpringBootServletInitializer {

    @Autowired
    ApiUpdateService apiUpdateService;

    @PostConstruct
    public void getApiData() {
        apiUpdateService.startUpdating();
    }

    public static void main(String[] args) {
        SpringApplication.run(AirplaneTrackingApiApp.class, args);
    }
}
