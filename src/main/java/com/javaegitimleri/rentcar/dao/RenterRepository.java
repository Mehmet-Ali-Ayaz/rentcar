package com.javaegitimleri.rentcar.dao;

import com.javaegitimleri.rentcar.model.Tenant;

import java.util.List;

public interface TenantRepository {

    List<Tenant>findAll();
    Tenant findById(Long Id);
    List<Tenant> findByTenantName(String tenantName);
    void create(Tenant tenant);
    Tenant update(Tenant tenant);
    void delete (long Id);

}
