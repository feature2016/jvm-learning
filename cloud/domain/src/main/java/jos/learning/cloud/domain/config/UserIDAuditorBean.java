package jos.learning.cloud.domain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Created by jos on 2018/6/14.
 */
@Configuration
@Profile({"test","prod"})
public class UserIDAuditorBean implements AuditorAware<String> {
    public Optional<String> getCurrentAuditor() {
        return Optional.of("user:张三");
    }
}