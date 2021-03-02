package com.javaegitimleri.rentcar.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car {
    @Id
    @Column
    private Long id;
    @Column
    private String plaka;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private int year;
    @Column
    private int km;

    public Car(Long id, String plaka, String brand, String model, int year, int km) {
        this.id = id;
        this.plaka = plaka;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.km = km;
    }

    public Car() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", plaka='" + plaka + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", km=" + km +
                '}';
    }
}
