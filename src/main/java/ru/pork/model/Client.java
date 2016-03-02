package ru.pork.model;

import java.util.Date;
import java.util.Set;

/**
 * Created by santa on 02.03.16.
 */
public class Client {
    private int id;
    private String firstName;

    private String lastName;
    private String secondName;
    private Date birthDate;
    private int gender;
    private long phone;
    private String email;
    private String description;

    private Set contractses;

    private ClubProgram program;

    public Client(){}
    public Client(String description, String email, long phone, int gender, Date birthDate, String secondName, String lastName, String firstName) {
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birthDate = birthDate;
        this.secondName = secondName;
        this.lastName = lastName;
        this.firstName = firstName;
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

    public Set<Contracts> getContractses() {
        return contractses;
    }

    public void setContractses(Set contractses) {
        this.contractses = contractses;
    }

    public ClubProgram getProgram() {
        return program;
    }

    public void setProgram(ClubProgram program) {
        this.program = program;
    }
}
