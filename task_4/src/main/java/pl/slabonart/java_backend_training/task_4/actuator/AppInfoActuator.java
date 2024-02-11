package pl.slabonart.java_backend_training.task_4.actuator;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Endpoint(id = "appInfo")
@RequiredArgsConstructor
public class AppInfoActuator {

    private static final String PROFILES = "PROFILES";
    private static final String DATABASE_URL = "DATABASE_URL";
    private static final String DELIMITER = ", ";

    private final Environment environment;

    @Value("${spring.datasource.url}")
    private String dataBaseUrl;

    @ReadOperation
    public Map<String, String> getAppInfo() {
        return Map.of(
                PROFILES, String.join(DELIMITER, environment.getActiveProfiles()),
                DATABASE_URL, dataBaseUrl
        );
    }
}
