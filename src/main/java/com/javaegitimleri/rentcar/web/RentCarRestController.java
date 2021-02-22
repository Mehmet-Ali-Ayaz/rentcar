package com.javaegitimleri.rentcar.web;

import com.javaegitimleri.rentcar.model.Renter;
import com.javaegitimleri.rentcar.service.RentCarService;
import com.javaegitimleri.rentcar.service.RenterNotFoundException;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class RentCarRestController {
    @Autowired
    private RentCarService rentCarService;

    @RequestMapping(method = RequestMethod.POST, value = "/renter")
    public ResponseEntity<URI> createRenter(@RequestBody Renter renter) {
        try {
        rentCarService.createRenter(renter);
        Long id = renter.getId();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }catch(Exception ex){

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    }




    @RequestMapping(method= RequestMethod.GET, value = "/renters")
    public ResponseEntity<List<Renter>> getRenters(){
        List<Renter> renters = rentCarService.findRenters();
        return ResponseEntity.ok(renters);

    }
    @RequestMapping(method= RequestMethod.GET, value = "/renter")
    public ResponseEntity<List<Renter>> getRenters(@RequestParam("ln") String renterName){
    List<Renter> renters=rentCarService.findRenters(renterName);
    return ResponseEntity.ok(renters);


    }
    @RequestMapping(method = RequestMethod.GET, value = "/renter/{id}")
    public ResponseEntity<Renter> getRenter(@PathVariable("id") long id){
        try{
        Renter renter = rentCarService.findRenter(id);
        return ResponseEntity.ok(renter);
    }catch (RenterNotFoundException exception){
            return ResponseEntity.notFound().build();
        }

}}
