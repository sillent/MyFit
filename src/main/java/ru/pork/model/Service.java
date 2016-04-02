package ru.pork.model;

import java.util.Set;

/**
 * Created by dima on 02.04.16.
 */
public class Service {
    private int id;
    private String name;

    private Set<ClubProgram> programs;
    Service() {
    }

    public Service(int id, String name) {
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

    public Set<ClubProgram> getPrograms() {
        return programs;
    }

    public void setPrograms(Set<ClubProgram> programs) {
        this.programs = programs;
    }
}
