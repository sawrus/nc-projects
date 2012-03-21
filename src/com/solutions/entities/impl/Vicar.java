package com.solutions.mvc.entities.impl;

import com.solutions.mvc.entities.AbstractEntity;

import java.util.Date;

public class Vicar extends AbstractEntity {
    private Depart depart;

    private String secondName;
    private String lastName;
    private String phone;
	private int salary;

    public Vicar() {}

    public Vicar(String name,Depart depart, String secondName, String lastName, String phone, int salary) {
        super(name);
        this.depart = depart;
        this.secondName = secondName;
        this.lastName = lastName;
        this.phone = phone;
		this.salary = salary;
    }

    public Depart getDepart() {
        return depart;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

	public int getSalary() {
        return salary;
    }
	
    public void setDepart(Depart depart) {
        this.depart = depart;
        //group.addVicar(this);
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

	public void setSalary(int salary) {
        this.salary = salary;
    }
	
    public void clear() {
        this.name = "";
        this.depart = null;
        this.secondName = "";
        this.lastName = "";
        this.phone = "";
		this.salary = 0; 
    }

    @Override
    public String toString() {
        return super.getName() + " Vicar{" +
                "depart=" + (depart != null ? depart.getName() : "") +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone + '\'' +
				", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vicar vicar = (Vicar) o;

        if (depart != null ? !depart.equals(vicar.depart) : vicar.depart != null) return false;
        if (lastName != null ? !lastName.equals(vicar.lastName) : vicar.lastName != null) return false;
        if (secondName != null ? !secondName.equals(vicar.secondName) : vicar.secondName != null) return false;
        if (phone != null ? !phone.equals(vicar.phone) : vicar.phone != null) return false;
		if (salary != 0 ? !(salary==vicar.salary) : vicar.salary != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = depart != null ? depart.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
		//result = 31 * result + (salary !=0 ? salary.hashCode() : 0);
        return result;
    }
}