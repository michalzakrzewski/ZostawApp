package com.zakrzewski.zostawapp.Controllers;

import com.zakrzewski.zostawapp.Entities.AdvertisementModel;
import com.zakrzewski.zostawapp.Services.AdvertisementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api/v1")
public class AdvertisementController {

    private AdvertisementServiceImpl advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementServiceImpl advertisementService) {
        this.advertisementService = advertisementService;
    }

    @RequestMapping(value = "/get/all-advertisement", method = RequestMethod.GET)
    public List<AdvertisementModel> getAllAdvertisement(){
        List<AdvertisementModel> advertisementModelList =  advertisementService.getAllAdvertisement();
        return advertisementModelList;
    }

    @RequestMapping(value = "/get/advertisement/{id}", method = RequestMethod.GET)
    public AdvertisementModel getOneAdvertisement(@PathVariable Long id){
        return advertisementService.getOneAdvertisement(id);
    }

    @RequestMapping(value = "/add-advertisement", method = RequestMethod.POST)
    public void addNewAdvertisement(@RequestBody AdvertisementModel advertisementModel){
        advertisementService.addNewAdvertisement(advertisementModel);
    }

    @RequestMapping(value = "/edit-advertisement/{id}", method = RequestMethod.PUT)
    public void editAdvertisement(@PathVariable Long id, @RequestBody AdvertisementModel advertisementModel){
        advertisementService.editAdvertisement(id, advertisementModel);
    }

    @RequestMapping(value = "/delete-advertisement/{id}", method = RequestMethod.DELETE)
    public void deleteAdvertisement(@PathVariable Long id){
        advertisementService.deleteAdvertisement(id);
    }
}
