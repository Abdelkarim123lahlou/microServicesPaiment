package com.mpayment.serverconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@EnableConfigServer  // Pour déclarer ce MS comme etant un serveur de config
@SpringBootApplication
public class ServerConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerConfigApplication.class, args);
    }

}
