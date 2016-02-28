package ru.pork.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

//@Entity
//@Table(name="AbonCard")
public class AbonCard {
//    @Id
//    @GeneratedValue
//    @Column(name="id")
    private int id;

//    @Column(name="cardType")
    private byte cardType;

//    @Column(name="description")
    private String description;

//    @Column(name="expiration_begin")
    private Date expiration_begin;

//    @Column(name="expiration_end")
    private Date expiration_end;

//    @Column(name="price")
    private int price;

//    @Column(name="typeOfDiscount")
    private byte typeOfDiscount;

//    @Column(name="discountPercent")
    private int discountPercent;

//    @OneToMany(targetEntity =Person.class,mappedBy = "person",cascade = CascadeType.ALL)
//    private Set<Person> persons;


    AbonCard() {}

    public AbonCard(byte cardType, String description, Date expiration_begin, Date expiration_end, int price, byte typeOfDiscount, int discountPercent) {
        this.cardType = cardType;
        this.description = description;
        this.expiration_begin = expiration_begin;
        this.expiration_end = expiration_end;
        this.price = price;
        this.typeOfDiscount = typeOfDiscount;
        this.discountPercent = discountPercent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getCardType() {
        return cardType;
    }

    public void setCardType(byte cardType) {
        this.cardType = cardType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpiration_begin() {
        return expiration_begin;
    }

    public void setExpiration_begin(Date expiration_begin) {
        this.expiration_begin = expiration_begin;
    }

    public Date getExpiration_end() {
        return expiration_end;
    }

    public void setExpiration_end(Date expiration_end) {
        this.expiration_end = expiration_end;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public byte getTypeOfDiscount() {
        return typeOfDiscount;
    }

    public void setTypeOfDiscount(byte typeOfDiscount) {
        this.typeOfDiscount = typeOfDiscount;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

//    public Set<Person> getPersons() {
//        return persons;
//    }
//
//    public void setPersons(Set<Person> persons) {
//        this.persons = persons;
//    }
}
