package com.zakrzewski.zostawapp.Entities;

import javax.persistence.*;

@Entity
@Table(name = "advertisement")
public class AdvertisementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "advertisement_contents", nullable = false)
    private String advertisementContents;

    @Column(name = "advertisement_signature", nullable = false)
    private String signatureAdvertisement;

    @Column(name = "who_add_id")
    private int userWhoAddId;

    public AdvertisementModel() {
    }

    public AdvertisementModel(String advertisementContents, String signatureAdvertisement, int userWhoAddId) {
        this.advertisementContents = advertisementContents;
        this.signatureAdvertisement = signatureAdvertisement;
        this.userWhoAddId = userWhoAddId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdvertisementContents() {
        return advertisementContents;
    }

    public void setAdvertisementContents(String advertisementContents) {
        this.advertisementContents = advertisementContents;
    }

    public String getSignatureAdvertisement() {
        return signatureAdvertisement;
    }

    public void setSignatureAdvertisement(String signatureAdvertisement) {
        this.signatureAdvertisement = signatureAdvertisement;
    }

    public int getUserWhoAddId() {
        return userWhoAddId;
    }

    public void setUserWhoAddId(int userWhoAddId) {
        this.userWhoAddId = userWhoAddId;
    }
}
