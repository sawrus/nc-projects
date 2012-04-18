package com.solutions.entities.impl;

import com.solutions.entities.AbstractEntity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Agency extends AbstractEntity {

    private HashMap<String, Depart> agency = new HashMap<String, Depart>();

    public Agency() {
    }

    public Depart GetDepart(String name) {
        return agency.get(name);
    }

    public void SetDepart(Depart depart) {
        agency.put(depart.getName(), depart);
    }

    public void clear() {
        name = "";
        agency.clear();
    }

    public void DeleteDepart(String name) {
        agency.remove(name);
    }

    public Depart CheckDepart(String title) {
        Collection<Depart> dep = Values();
        Iterator<Depart> itr = dep.iterator();
        while (itr.hasNext()) {
            Depart element = itr.next();
            if (element.getName().compareTo(title) == 0) {
                return element;
            }
        }
        Depart element = new Depart();
        element.setName(title);
        SetDepart(element);
        return element;
    }


    public Collection<Depart> Values() {
        return agency.values();
    }


}
