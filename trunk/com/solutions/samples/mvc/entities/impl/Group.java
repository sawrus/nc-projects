package com.solutions.samples.mvc.entities.impl;

import com.solutions.samples.mvc.entities.AbstractEntity;

import java.util.HashMap;
import java.util.Map;

public class Group<TStudent extends Student> extends AbstractEntity {
    private final Map<String, TStudent> students = new HashMap<String, TStudent>();
    private Integer number;

    public Group(){}

    public Group(String name, Integer number) {
        super(name);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void addStudent(TStudent student) {
        students.put(String.valueOf(student.getName()), student);
    }

    public void removeStudentByName(String name) {
        students.remove(name);
    }

    public void clear() {
        students.clear();
    }

    public TStudent getStudentByName(String name) {
        return students.get(name);
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return super.getName() + " Group{" +
                "students=" + students.values() +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (number != null ? !number.equals(group.number) : group.number != null) return false;
        if (!students.equals(group.students)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = students.hashCode();
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
