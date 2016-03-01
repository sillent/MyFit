package ru.pork.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by santa on 25.02.16.
 */
//@Entity
//@Table(name = "Person")
public class Person {

    private int id;
    private String firstName;

    private String lastName;
    private String secondName;
    private Date birthDate;
    private int gender;
    private long phone;
    private String email;
    private String description;
    private AbonCard abonCard;

    private Date begin_date;
    private Date expire_date;

    public Person(){}

    public Person(String firstName, String lastName, String secondName, Date birthDate, int gender,
           long phone, String email, String description, Date begin_date, Date expire_date)
    {
        this.firstName=firstName; this.lastName=lastName; this.secondName=secondName;
        this.birthDate=birthDate; this.gender=gender; this.phone=phone; this.email=email;
        this.description=description; this.begin_date=begin_date; this.expire_date=expire_date;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public AbonCard getAbonCard() {
        return abonCard;
    }

    public void setAbonCard(AbonCard abonCard) {
        this.abonCard = abonCard;
    }
}

