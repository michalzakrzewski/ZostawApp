package com.zakrzewski.zostawapp.Repositories;

import com.zakrzewski.zostawapp.Entities.BicycleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicycleRepository extends JpaRepository<BicycleModel, Long> {
}
