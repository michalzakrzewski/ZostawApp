package com.zakrzewski.zostawapp.Entities;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;

@Entity
@Table(name = "bicycles")
public class BicycleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bicycle_number", nullable = false)
    private Long bicycleNumber;

    @Column(name = "is_free", nullable = false)
    private Boolean isFree;

    @Column(name = "bicycle_owner", nullable = false)
    private Long idOwner;

    public BicycleModel(Long id, Long bicycleNumber, Boolean isFree) {
        this.id = id;
        this.bicycleNumber = bicycleNumber;
        this.isFree = isFree;
        UserModel userModel = new UserModel();
        this.idOwner = userModel.getId();

    }

    public BicycleModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBicycleNumber() {
        return bicycleNumber;
    }

    public void setBicycleNumber(Long bicycleNumber) {
        this.bicycleNumber = bicycleNumber;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }
}
