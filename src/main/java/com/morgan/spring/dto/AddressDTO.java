package com.morgan.spring.dto;

public class AddressDTO {
    int id;
    String city;
    String nation;

    public AddressDTO(int id, String city, String nation) {
        this.id = id;
        this.city = city;
        this.nation = nation;
    }

    public AddressDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
