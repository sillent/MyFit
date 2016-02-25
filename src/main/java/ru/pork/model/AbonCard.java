package ru.pork.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by santa on 25.02.16.
 */
@Entity
@Table(name="AbonCard")
public class AbonCard {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="cardType")
    private byte cardType;

    @Column(name="description")
    private String description;

    @Column(name="expiration_begin")
    private Date expiration_begin;

}
