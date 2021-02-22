package com.javaegitimleri.rentcar.dao;

import com.javaegitimleri.rentcar.model.Renter;

import java.util.List;

public interface RenterRepository {

    List<Renter>findAll();
    Renter findById(Long Id);
    List<Renter> findByrenterName(String renterName);
    void create(Renter renter);
    Renter update(Renter renter);
    void delete (long Id);

}
