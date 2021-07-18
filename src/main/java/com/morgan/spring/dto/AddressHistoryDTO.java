package com.morgan.spring.dto;

import java.time.LocalDate;

public class AddressHistoryDTO {
    int id;
    String city;
    String nation;
    LocalDate date;

    public AddressHistoryDTO(int id, String city, String nation) {
        this.id = id;
        this.city = city;
        this.nation = nation;
        date = LocalDate.now();
    }

    public AddressHistoryDTO() {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
