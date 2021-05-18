package com.example.jumia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class JumiaApplication {


    public static void main(String[] args) {

        SpringApplication.run(JumiaApplication.class, args);

    }

}
