package com.javaegitimleri.rentcar.service;

import com.javaegitimleri.rentcar.dao.RenterRepository;
import com.javaegitimleri.rentcar.exception.RenterNotFoundException;
import com.javaegitimleri.rentcar.model.Renter;
import io.swagger.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class RentCarServiceImpl implements RentCarService{

    private RenterRepository renterRepository;
    @Autowired
    public RentCarServiceImpl(RenterRepository renterRepository) {
        this.renterRepository = renterRepository;
    }

    @Autowired
    public void setRenterRepository(RenterRepository renterRepository) {
        this.renterRepository = renterRepository;
    }

    @Override
    public List<Renter> findRenters() {
        return renterRepository.findAll();
    }

    @Override
    public List<Renter> findRenters(String renterName) {
        return renterRepository.findByrenterName(renterName);
    }

    @Override
    public Renter findRenter(Long id) throws RenterNotFoundException {
        Renter renter = renterRepository.findById(id);
        if (renter==null) throw new RenterNotFoundException("Renrer not found with id:" + id);
        return renter;
    }

    @Override
    public void createRenter(Renter renter) {
        renterRepository.create(renter);

    }

    @Override
    public void update(Renter renter) {
        renterRepository.update(renter);

    }

    @Override
    public void deleteRenter(Long id) {
        renterRepository.delete(id);

    }




}
