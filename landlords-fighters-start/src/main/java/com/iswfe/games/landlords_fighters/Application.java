package com.iswfe.games.landlords_fighters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ImportResource(value = {"classpath:/*.properties"} )
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
