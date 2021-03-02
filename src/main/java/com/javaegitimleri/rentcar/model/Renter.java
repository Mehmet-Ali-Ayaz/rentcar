package com.javaegitimleri.rentcar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
//ASAGİDAKİ SATİR JAVA14 HATASİDİR JAVA 8 DE CALİSMAKTADİR
//@XmlRootElement
@Entity
@Table(name="renter")
public class Renter {

    @Id
    private Long id;
    @Column
    private String renterName;
    @Column
    private String rentalFee;
    @Column
    private Date rentalDate;
    @Column
    private Date rentalEndDate;

    private Set<Car> cars =new HashSet<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
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
    @XmlTransient
    @JsonIgnore
    public Set<Car> getCars() {
        return cars;
    }


    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "renters{" +
                "renterName='" + renterName + '\'' +
                ", rentalFee='" + rentalFee + '\'' +
                ", rentalDate=" + rentalDate +
                ", rentalEndDate=" + rentalEndDate +
                '}';
    }
}
