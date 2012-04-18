package com.solutions.entities.impl;

import com.solutions.entities.AbstractEntity;

public class Depart extends AbstractEntity {
    private String chief;

    public Depart(){}

    public Depart(String name, String chief) {
        super(name);
        this.chief = chief;
    }

    public String getChief() {
        return chief;
    }

    public void clear() {
        name = "";
		chief = null;
    }

    public void setChief(String chief) {
        this.chief = chief;
    }

    @Override
    public String toString() {
        return super.getName() + " Depart{" +
                "chief=" + chief +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Depart depart = (Depart) o;

        if (chief != null ? !chief.equals(depart.chief) : depart.chief != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (chief != null ? chief.hashCode() : 0);
        return result;
    }
}
