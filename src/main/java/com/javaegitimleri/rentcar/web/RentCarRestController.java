package com.javaegitimleri.rentcar.web;

import com.javaegitimleri.rentcar.exception.InternalServerException;
import com.javaegitimleri.rentcar.model.Renter;
import com.javaegitimleri.rentcar.service.RentCarService;
import com.javaegitimleri.rentcar.exception.RenterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.Link;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class RentCarRestController {
    @Autowired
    private RentCarService rentCarService;

    @RequestMapping(method = RequestMethod.DELETE, value="/renter/{id}")
    public ResponseEntity<?> deleteRenter(@PathVariable("id") Long id) {
        try {
            rentCarService.deleteRenter(id);
            return ResponseEntity.ok().build();
        } catch (RenterNotFoundException exception) {
          throw exception;
        } catch (Exception exception) {
            throw new InternalServerException(exception);
        }
    }
     @RequestMapping(method = RequestMethod.PUT, value = "/renter/{id}")
    public ResponseEntity<?> updateRenter(@PathVariable("id") Long id, @RequestBody Renter renterRequest) {
         try {
             Renter renter = rentCarService.findRenter(id);
             renter.setRenterName(renterRequest.getRenterName());
             rentCarService.update(renter);
             return ResponseEntity.ok().build();
         } catch (RenterNotFoundException exception) {
           return ResponseEntity.ok().build();
         } catch (Exception exception) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
     }

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

/*
    @RequestMapping(method = RequestMethod.GET, value = "/renter/{id}", produces = "application/json")
    public ResponseEntity<?> getRenterAsHateoasResource(@PathVariable("id") Long id){
        try{
            Renter renter = rentCarService.findRenter(id);
            Link self = ControllerLinkBuilder.linkTo(RentCarRestController.class).slash("/renter/" + id).withSelfRel();
            Link create = ControllerLinkBuilder.linkTo(RentCarRestController.class).slash("/renter/" + id).withRel("create");
            Link update = ControllerLinkBuilder.linkTo(RentCarRestController.class).slash("/renter/" + id).withRel("update");
            Link delete = ControllerLinkBuilder.linkTo(RentCarRestController.class).slash("/renter/" + id).withRel("delete");
            Resource<Renter> resource = new Resource<Renter>(renter, self, create, update, delete);
            return ResponseEntity.ok(resource);
        }catch (RenterNotFoundException exception){
            return ResponseEntity.notFound().build();
        }
    }

*/
    @RequestMapping(method = RequestMethod.GET, value = "/renter/{id}")
    public ResponseEntity<Renter> getRenter(@PathVariable("id") Long id){
        try{
        Renter renter = rentCarService.findRenter(id);
        return ResponseEntity.ok(renter);
    }catch (RenterNotFoundException exception){
            return ResponseEntity.notFound().build();
        }

}}
