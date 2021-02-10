package com.javaegitimleri.rentcar.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Tenant {


    private long Id;
    private String tenantName;
    private String rentalFee;
    private Date rentalDate;
    private Date rentalEndDate;

    private Set<Car> cars =new HashSet<>();
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = Id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(String rentalFee) {
        this.rentalFee = rentalFee;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(Date rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Tenants{" +
                "tenantName='" + tenantName + '\'' +
                ", rentalFee='" + rentalFee + '\'' +
                ", rentalDate=" + rentalDate +
                ", rentalEndDate=" + rentalEndDate +
                '}';
    }
}
