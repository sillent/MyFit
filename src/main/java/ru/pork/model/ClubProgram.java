package ru.pork.model;


import java.util.Set;

public class ClubProgram {
    private int id;
    private String name;
    private String description;
    private int timeUsing;
    private int daysActive;
    private int price;

    private Set<Contracts> contracts;
    private Set<Service> services;

    public ClubProgram() {}

    public ClubProgram(String name,
                       String description,
                       int timeUsing,
                       int daysActive,
                       int price) {
        this.name = name;
        this.description = description;
        this.timeUsing = timeUsing;
        this.daysActive = daysActive;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimeUsing() {
        return timeUsing;
    }

    public void setTimeUsing(int timeUsing) {
        this.timeUsing = timeUsing;
    }

    public int getDaysActive() {
        return daysActive;
    }

    public void setDaysActive(int daysActive) {
        this.daysActive = daysActive;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public Set<Contracts> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contracts> contracts) {
        this.contracts = contracts;
    }
}
