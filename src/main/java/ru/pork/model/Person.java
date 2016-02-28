package ru.pork.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by santa on 25.02.16.
 */
//@Entity
//@Table(name = "Person")
public class Person {
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    @Column(name = "id")
    private int id;

//    @Column(name="firstName")
    private String firstName;

//    @Column(name="lastName")
    private String lastName;

//    @Column(name="secondName")
    private String secondName;

//    @Column(name="birthDate")
    private Date birthDate;

//    @Column(name="gender")
    private byte gender;

//    @Column(name="phone")
    private long phone;

//    @Column(name="email")
    private String email;

//    @Column(name="description")
    private String description;

//    @ManyToOne
//    @JoinColumn(name="AbonCard_id")
    private AbonCard abonCard;

    Person(){}

    public Person(String firstName, String lastName, String secondName, Date birthDate, byte gender,
           long phone, String email, String description)
    {
        this.firstName=firstName; this.lastName=lastName; this.secondName=secondName;
        this.birthDate=birthDate; this.gender=gender; this.phone=phone; this.email=email;
        this.description=description;

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

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
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


    public AbonCard getAbonCard() {
        return abonCard;
    }

    public void setAbonCard(AbonCard abonCard) {
        this.abonCard = abonCard;
    }
}

