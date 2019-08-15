package com.zakrzewski.zostawapp.Entities;

import javax.persistence.*;
import java.util.UUID;

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

    public AdvertisementModel() {
    }

    public AdvertisementModel(String advertisementContents, String signatureAdvertisement) {
        this.advertisementContents = advertisementContents;
        this.signatureAdvertisement = signatureAdvertisement;
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
}
