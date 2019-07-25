package com.zakrzewski.zostawapp.Entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_user", nullable = false, length = 10)
    private String loginUser;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "pesel_number", nullable = false, length = 11)
    private long peselNumber;

    @Column(name = "phone_number", nullable = false, length = 9)
    private long phoneNumber;

    @Column(name = "card_id_number", nullable = false, length = 9)
    private String cardIdNumber;

    public UserModel(String loginUser, Long id, String firstName, String lastName, long peselNumber, long phoneNumber, String cardIdNumber) {
        this.loginUser = loginUser;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselNumber = peselNumber;
        this.phoneNumber = phoneNumber;
        this.cardIdNumber = cardIdNumber;
    }

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(long peselNumber) {
        this.peselNumber = peselNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCardIdNumber() {
        return cardIdNumber;
    }

    public void setCardIdNumber(String cardIdNumber) {
        this.cardIdNumber = cardIdNumber;
    }
}
