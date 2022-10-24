package com.gym.web.webappsv.DTO;

public class PersonalTrainerDTO {
    private Long id;
    private String name;
    private String gender;
    private String address;
    private String identifyCard;
    private String dob;
    private String phoneNumber;
    private boolean status;
    public PersonalTrainerDTO(Long id, String name, String gender, String address, String identifyCard, String dob, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.identifyCard = identifyCard;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
    }

    public PersonalTrainerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentifyCard() {
        return identifyCard;
    }

    public void setIdentifyCard(String identifyCard) {
        this.identifyCard = identifyCard;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
