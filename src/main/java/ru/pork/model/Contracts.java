package ru.pork.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Contracts {
    private int id;
    private Date creationDate;
    private Date contractBegin;
    private Date contractEnding;
    private int status;

    private Set<ClubProgram> clubPrograms=new HashSet<ClubProgram>(0);


    public Contracts() {}

    public Contracts(Date creationDate, Date contractBegin, Date contractEnding, int status) {
        this.creationDate = creationDate;
        this.contractBegin = contractBegin;
        this.contractEnding = contractEnding;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getContractBegin() {
        return contractBegin;
    }

    public void setContractBegin(Date contractBegin) {
        this.contractBegin = contractBegin;
    }

    public Date getContractEnding() {
        return contractEnding;
    }

    public void setContractEnding(Date contractEnding) {
        this.contractEnding = contractEnding;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<ClubProgram> getClubPrograms() {
        return clubPrograms;
    }

    public void setClubPrograms(Set<ClubProgram> clubPrograms) {
        this.clubPrograms = clubPrograms;
    }

    public boolean equals(Object ob) {
        if (ob==null) return false;
        if (!this.getClass().equals(ob.getClass())) return false;

        Contracts contracts2=(Contracts) ob;
        if (this.id==contracts2.getId()) {
            return true;
        }
        return false;
    }
    public int hashCode() {
        int tmp=0;
        tmp=(id+"contract").hashCode();
        return tmp;
    }
}
