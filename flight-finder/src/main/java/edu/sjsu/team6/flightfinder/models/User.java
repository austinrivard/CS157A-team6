package edu.sjsu.team6.flightfinder.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="user")
public class User {
    @Id
    private String username;

    private String password;

    @Formula("concat_ws(' ', firstName, lastName)")
    private String name;

    private String firstName;

    private String lastName;

    private String gender;

    private LocalDate dob;

    private String mobileNumber;

    private String city;

    private String state;

    private String zipCode;

    public User()
    {

    }

    public User(String username, String password, String firstName, String lastName, String gender, LocalDate dob, String mobileNumber, String city, String state, String zipCode)
    {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getUsername() {
		return username;
	}

    public void setUsername(String username) {
		this.username = username;
	}

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
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

    public String getGender(){
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public LocalDate getDOB(){
        return dob;
    }

    public void setDOB(LocalDate dob)
    {
        this.dob = dob;
    }

    public String getMobileNumber(){
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getZipCode(){
        return zipCode;
    }

    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    @Formula("CONCAT(city, ', ', state, ' ', zipCode)")
    private String address;

    @OneToMany(mappedBy = "searchedBy")
    private List<Itinerary> itineraries;

    @OneToMany(mappedBy = "setBy")
    private List<Alert> alerts;
}
