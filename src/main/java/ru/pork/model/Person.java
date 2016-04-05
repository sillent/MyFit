package ru.pork.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String secondName;
    private Date birthDate;
    private int state;          // 1-client, 2-administrator
    private int gender;
    private long phone;
    private String email;

    private Set<Contracts> contracts=new HashSet<Contracts>(0);


    public Person(){}

    public Person(String firstName,
                  String lastName,
                  String secondName,
                  Date birthDate,
                  int state,
                  int gender,
                  long phone,
                  String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.state = state;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Contracts> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contracts> contracts) {
        this.contracts = contracts;
    }
}
