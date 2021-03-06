package com.javaegitimleri.rentcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
    @EnableConfigurationProperties(value = RentCarProperties.class )
    public class RentcarApplication {

        public static void main(String[] args) {
            SpringApplication.run(com.javaegitimleri.rentcar.RentcarApplication.class, args);
        }

    }

