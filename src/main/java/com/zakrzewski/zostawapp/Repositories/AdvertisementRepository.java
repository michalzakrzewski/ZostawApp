package com.zakrzewski.zostawapp.Repositories;

import com.zakrzewski.zostawapp.Entities.AdvertisementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends JpaRepository<AdvertisementModel, Long> {

    AdvertisementModel findBySignatureAdvertisement(String signature);
}
