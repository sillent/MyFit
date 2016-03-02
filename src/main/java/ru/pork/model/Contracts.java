package ru.pork.model;

import java.util.Date;

/**
 * Created by santa on 02.03.16.
 */
public class Contracts {
    private int id;

    private Date startDate;
    private int daysActive;
    private int status;

    public Contracts() {}
    public Contracts(int id, Date startDate, int daysActive, int status) {
        this.id = id;
        this.startDate = startDate;
        this.daysActive = daysActive;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDaysActive() {
        return daysActive;
    }

    public void setDaysActive(int daysActive) {
        this.daysActive = daysActive;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
