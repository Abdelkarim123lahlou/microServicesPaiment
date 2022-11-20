package produims.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "bootstrap");// pour dire a spring de mire à partire de bootstrap au lieu de application properties
        SpringApplication.run(ComApplication.class, args);

    }

}
