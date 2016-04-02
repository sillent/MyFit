package ru.pork.model;

import java.util.Date;


public class Contracts {
    private int id;

    private Date startDate;
    private Date contractsBegin;
    private Date endDate;
    private int status;

    public Contracts() {}

    public Contracts(Date startDate, Date contractsBegin, Date endDate, int status) {
        this.startDate = startDate;
        this.contractsBegin = contractsBegin;
        this.endDate = endDate;
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

    public Date getContractsBegin() {
        return contractsBegin;
    }

    public void setContractsBegin(Date contractsBegin) {
        this.contractsBegin = contractsBegin;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
