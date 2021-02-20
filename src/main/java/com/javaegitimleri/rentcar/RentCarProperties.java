package com.javaegitimleri.rentcar;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rentcar")
public class RentCarProperties {

    private  boolean displayRentersWithCars=false;

    public boolean isDisplayRentersWithCars(){
        return displayRentersWithCars;
    }

    public void setDisplayRentersWithCars(boolean displayRentersWithCars) {
        this.displayRentersWithCars = displayRentersWithCars;

        }
    }

