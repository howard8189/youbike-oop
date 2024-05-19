package com.youbikerental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.youbikerental.*")
@EnableJpaRepositories("com.youbikerental.*")
public class YoubikeRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoubikeRentalApplication.class, args);
    }
}


