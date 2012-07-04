package com.solutions.samples.mvc.entities;

public abstract class AbstractEntity implements IEntity{
    protected String name;

    protected AbstractEntity() {
    }

    protected AbstractEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
