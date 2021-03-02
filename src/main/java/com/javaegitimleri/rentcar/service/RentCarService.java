package com.javaegitimleri.rentcar.service;

import com.javaegitimleri.rentcar.exception.RenterNotFoundException;
import com.javaegitimleri.rentcar.model.Renter;

import java.util.List;

public interface RentCarService {

    List<Renter>findRenters();
    List<Renter>findRenters(String renterName);
    Renter findRenter(Long id) throws RenterNotFoundException;

    void createRenter(Renter renter);
    void update(Renter renter);
    void deleteRenter(Long id);





}
