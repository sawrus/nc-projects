package com.solutions.samples.mvc.entities.impl;

import com.solutions.samples.mvc.entities.AbstractEntity;

import java.util.Date;

public class Student extends AbstractEntity {
    private Group group;

    private String secondName;
    private String lastName;
    private Date startLearn;

    public Student() {}

    public Student(String name, Group group, String secondName, String lastName, Date startLearn) {
        super(name);
        this.group = group;
        this.secondName = secondName;
        this.lastName = lastName;
        this.startLearn = startLearn;
    }

    public Group getGroup() {
        return group;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getStartLearn() {
        return startLearn;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStartLearn(Date startLearn) {
        this.startLearn = startLearn;
    }

    public void clear() {
        this.name = "";
        this.group = null;
        this.secondName = "";
        this.lastName = "";
        this.startLearn = null;
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" +
                "group=" + group +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", startLearn=" + startLearn +
                '}';
    }
}
