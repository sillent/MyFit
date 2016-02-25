package ru.pork.model;

import javax.persistence.*;

/**
 * Created by santa on 25.02.16.
 */
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="secondName")
    private String secondName;


}

