package ingjulianvega.ximic.msscasuduration.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "duration")
public class DurationParameters {

    private String api;
}
