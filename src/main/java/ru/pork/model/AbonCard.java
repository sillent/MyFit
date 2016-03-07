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
//    private int cardType;

//    @Column(name="description")
    private String description;

//    @Column(name="expiration_begin")
//    private Date expiration_begin;

//    @Column(name="expiration_end")
//    private Date expiration_end;

//    @Column(name="price")
    private int price;

//    @Column(name="typeOfDiscount")
//    private int typeOfDiscount;

//    @Column(name="discountPercent")
//    private int discountPercent;

//    @OneToMany(targetEntity =Person.class,mappedBy = "person",cascade = CascadeType.ALL)
//    private Set<Person> persons;


    public AbonCard() {}

    public AbonCard( String description, int price) {
        this.description = description;
        this.price = price;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
