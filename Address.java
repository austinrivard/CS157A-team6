package com.company;

public class Address
{
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;
    private String country;

    public Address(String streetAddress, String city, String state, int zipCode, String country)
    {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getStreetAddress()
    {
        return this.streetAddress;
    }

    public void setStreetAddress(String streetAddress)
    {
        this.streetAddress = streetAddress;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return this.state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public int getZipCode()
    {
        return this.zipCode;
    }

    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getCountry()
    {
        return this.country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }
}
