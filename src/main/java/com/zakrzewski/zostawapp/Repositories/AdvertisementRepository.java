package com.zakrzewski.zostawapp.Repositories;

import com.zakrzewski.zostawapp.Entities.AdvertisementModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<AdvertisementModel, Long> {
}
