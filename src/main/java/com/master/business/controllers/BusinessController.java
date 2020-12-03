package com.master.business.controllers;

import com.master.business.models.*;
import com.master.business.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/services/business")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    //finds all business
    @GetMapping("/all")
    public ResponseEntity<?>listBusiness() { return new ResponseEntity<>( businessService.listAllBusiness(),HttpStatus.OK); }

    //finds business by moderator id
    @GetMapping("/mod/{moderatorId}")
    public ResponseEntity<?> listBusinessByModId(@PathVariable Long moderatorId) {
        Business buss = businessService.listBusinessByModeratorId(moderatorId);
        return new ResponseEntity<>(buss,HttpStatus.OK);
    }

    //create new business with all the varibales +phones,address,owner
    @PostMapping("/add")
    public ResponseEntity<?> createBusiness(@Valid @RequestBody Business business){
        Business newBuss = businessService.saveBusiness(business);
        return new ResponseEntity<>(newBuss,HttpStatus.OK);
    }

    //delete business by id +phones,address,owner
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        businessService.deleteBusiness(id);
        return "Deleted Successfully";
    }

    //update business by id only the basics and create new phones,address,owner
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBusiness(@RequestBody Business business, @PathVariable Long id) {
        try {
            Business existBusiness = businessService.getBusiness(id);
            business.setId(id);
            businessService.saveBusiness(business);
           // Business UpdatedBusiness = businessService.listBusinessByModeratorId(business.getModeratorId());
            return new ResponseEntity<>("Updated !",HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
