package airplane.tracking.api.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("airplane.tracking.api")
@EnableWebMvc
@RequiredArgsConstructor
public class SpringConfig{

    private final ApplicationContext applicationContext;

}

