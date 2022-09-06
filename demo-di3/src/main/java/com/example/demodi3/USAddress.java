package com.example.demodi3;

public class USAddress implements IAddress {

    private String zipcode = "12345";
    private String city = "boston";

    public USAddress(String zipcode, String city) {
        this.zipcode = zipcode;
        this.city = city;
    }

    @Override
    public String getAddressInfo() {
        return zipcode + " " + city;
    }
}
