package com.javaegitimleri.rentcar.dao;

import ch.qos.logback.core.rolling.helper.PeriodicityType;
import com.javaegitimleri.rentcar.model.Car;

import java.util.List;

public interface CarRepository {
       Car findById(Long Id);
       List<Car> findByRenterId(Long renterId);
       void create(Car car);
       Car update(Car car);
       void delete(Long Id);
       void deleteByOwnerId(Long renterId);

}
