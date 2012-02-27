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
        group.addStudent(this);
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
        return super.getName() + " Student{" +
                "group=" + (group != null ? group.getName() : "") +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", startLearn=" + startLearn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (group != null ? !group.equals(student.group) : student.group != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        if (secondName != null ? !secondName.equals(student.secondName) : student.secondName != null) return false;
        if (startLearn != null ? !startLearn.equals(student.startLearn) : student.startLearn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = group != null ? group.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (startLearn != null ? startLearn.hashCode() : 0);
        return result;
    }
}
