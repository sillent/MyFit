package ru.pork.model;

/**
 * Created by santa on 02.03.16.
 */
public class ClubProgram {
    private int id;
    private String name;

    public ClubProgram() {}
    public ClubProgram(int id, String name) {
        this.id = id;
        this.name = name;
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
}
