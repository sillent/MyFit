package ru.pork.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by santa on 25.02.16.
 */
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="secondName")
    private String secondName;

    @Column(name="birthDate")
    private Date birthDate;

    @Column(name="gender")
    private byte gender;

    @Column(name="phone")
    private long phone;

    @Column(name="email")
    private String email;

    @Column(name="description")
    private String description;

    @Column(name="AbonCard_id")
    private AbonCard abonCard;

    Person(){}

    Person(String firstName, String lastName, String secondName, Date birthDate, byte gender,
           long phone, String email, String description, AbonCard abonCard)
    {
        this.firstName=firstName; this.lastName=lastName; this.secondName=secondName;
        this.birthDate=birthDate; this.gender=gender; this.phone=phone; this.email=email;
        this.description=description; this.abonCard=abonCard;

    }

}

