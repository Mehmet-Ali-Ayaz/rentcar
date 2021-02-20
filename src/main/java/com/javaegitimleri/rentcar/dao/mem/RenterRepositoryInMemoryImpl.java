package com.javaegitimleri.rentcar.dao.mem;

import com.javaegitimleri.rentcar.dao.RenterRepository;
import com.javaegitimleri.rentcar.model.Renter;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class RenterRepositoryInMemoryImpl implements RenterRepository {


    private Map<Long, Renter> rentersMap = new HashMap<>();

    public RenterRepositoryInMemoryImpl(){
        Renter renter1 = new Renter();
        renter1.setId(1l);
        renter1.setRenterName("Kenan Sevindik");

        Renter renter2 = new Renter();
        renter2.setId(2l);
        renter2.setRenterName("Ali Ayaz");

        Renter renter3 = new Renter();
        renter3.setId(3l);
        renter3.setRenterName("Nazan Birgul");

        Renter renter4 = new Renter();
        renter4.setId(4l);
        renter4.setRenterName("Kenan Ayaz");

        rentersMap.put(renter1.getId(), renter1);
        rentersMap.put(renter2.getId(), renter2);
        rentersMap.put(renter3.getId(), renter3);
        rentersMap.put(renter4.getId(), renter4);
    }

    @Override
    public List<Renter> findAll() {
        return new ArrayList<>(rentersMap.values());
    }

    @Override
    public Renter findById(Long Id) {
        return rentersMap.get(Id);
    }



    @Override
    public List<Renter> findByrenterName(String renterName) {
        return rentersMap.values().stream().filter(o->o.getRenterName().equals(renterName)).collect(Collectors.toList());
    }

    @Override
    public void create(Renter renter) {
        renter.setId((new Date().getTime()));
    }

    @Override
    public Renter update(Renter renter) {
        rentersMap.replace(renter.getId(), renter);
        return renter;
    }

    @Override
    public void delete(long Id) {
        rentersMap.remove(Id);
    }
}