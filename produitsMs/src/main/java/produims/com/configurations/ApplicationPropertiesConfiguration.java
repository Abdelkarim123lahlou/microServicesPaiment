package produims.com.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
@Data
@Component //pour dir a spring de scanner cette classe à la recherche de configuration
@ConfigurationProperties("mes-configs")
@RefreshScope
// précise que cette classe de configuration va récupérer des propriétés dans application.properties dont le préfixe est  mes-configs.
public class ApplicationPropertiesConfiguration {
private int limitDeProduits;

}
