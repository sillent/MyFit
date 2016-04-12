package ru.pork.model;

import java.util.Set;

public class Service {
    private int id;
    private String name;

//    private Set<ClubProgram> programs;
    public Service() {
    }


    public Service( String name) {
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

//    public Set<ClubProgram> getPrograms() {
//        return programs;
//    }

//    public void setPrograms(Set<ClubProgram> programs) {
//        this.programs = programs;
//    }
}
