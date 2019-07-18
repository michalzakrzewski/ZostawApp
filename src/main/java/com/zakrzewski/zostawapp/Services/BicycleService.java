package com.zakrzewski.zostawapp.Services;

import com.zakrzewski.zostawapp.Entities.BicycleModel;
import com.zakrzewski.zostawapp.Repositories.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicycleService {

    private BicycleRepository bicycleRepository;

    @Autowired
    public BicycleService(BicycleRepository bicycleRepository) {
        this.bicycleRepository = bicycleRepository;
    }

    public List<BicycleModel> getAllBicyclesInfo(){
        List<BicycleModel> bicycleModelList = bicycleRepository.findAll();
        return bicycleModelList;
    }

    public BicycleModel getOneBicycleInfo(Long id){
        return bicycleRepository.findById(id).orElse(null);
    }

    public void addNewBicycle(BicycleModel bicycleModel){
        bicycleRepository.save(bicycleModel);
    }

    public void editBicycleInfo(Long id, BicycleModel bicycleModel){
        bicycleRepository.save(bicycleModel);
    }

    public void deleteBicycle(Long id){
        bicycleRepository.deleteById(id);
    }
}
