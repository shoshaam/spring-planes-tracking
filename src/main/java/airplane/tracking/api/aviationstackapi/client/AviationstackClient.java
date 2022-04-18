package airplane.tracking.api.aviationstackapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "airport-client",
        url = "${api.url}")
public interface AviationstackClient {

    @RequestMapping(method = RequestMethod.GET, value = "/airports?access_key=${api.accesskey}&limit=${api.limit}")
    String getAirports();

    @RequestMapping(method = RequestMethod.GET, value = "/airplanes?access_key=${api.accesskey}&limit=${api.limit}")
    String getAirplanes();

    @RequestMapping(method = RequestMethod.GET, value = "/flights?access_key=${api.accesskey}&limit=${api.limit}")
    String getFligths();

}
