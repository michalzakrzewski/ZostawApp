package com.zakrzewski.zostawapp.Services;

import com.zakrzewski.zostawapp.Entities.AdvertisementModel;
import com.zakrzewski.zostawapp.Repositories.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl {

    private AdvertisementRepository advertisementRepository;

    @Autowired
    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    public List<AdvertisementModel> getAllAdvertisement(){
        return advertisementRepository.findAll();
    }

    public AdvertisementModel getOneAdvertisement(Long id){
        return advertisementRepository.findById(id).orElse(null);
    }

    public void addNewAdvertisement(AdvertisementModel advertisementModel){
        advertisementRepository.save(advertisementModel);
    }

    public void editAdvertisement(Long id, AdvertisementModel advertisementModel){
        advertisementRepository.save(advertisementModel);
    }

    public void deleteAdvertisement(Long id){
        advertisementRepository.deleteById(id);
    }


    public AdvertisementModel getAdvertisementBySignature(String signature) {
        return advertisementRepository.findBySignatureAdvertisement(signature);
    }
}
