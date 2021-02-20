package com.javaegitimleri.rentcar;


import org.springframework.context.annotation.Configuration;

@Configuration
public class RentCarConfiguration {

    private RentCarProperties rentCarProperties;

    public void init(){
        System.out.println("Display renters with cars :" + rentCarProperties.isDisplayRentersWithCars());
    }
}
