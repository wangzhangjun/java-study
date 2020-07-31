package com.study.patent.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Patent {

    @Transient
    private String year;
    @Transient
    private String option;

    @Id
    private String province;
    private int invent;
    private int practical;
    private int aspect;
    private int total;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getInvent() {
        return invent;
    }

    public void setInvent(int invent) {
        this.invent = invent;
    }

    public int getPractical() {
        return practical;
    }

    public void setPractical(int practical) {
        this.practical = practical;
    }

    public int getAspect() {
        return aspect;
    }

    public void setAspect(int aspect) {
        this.aspect = aspect;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
