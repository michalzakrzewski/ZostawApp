package com.zakrzewski.zostawapp.Entities;

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
    private UserModel userOwner;

    public BicycleModel(Long id, Long bicycleNumber, Boolean isFree, UserModel userOwner) {
        this.id = id;
        this.bicycleNumber = bicycleNumber;
        this.isFree = isFree;
        this.userOwner = userOwner;
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

    public UserModel getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(UserModel userOwner) {
        this.userOwner = userOwner;
    }
}
