package com.solutions.entities.impl;


import com.solutions.entities.AbstractEntity;

import java.util.Collection;
import java.util.HashMap;


public class Office extends AbstractEntity {

    private HashMap<String, Vicar> office = new HashMap<String, Vicar>();

    public Office() {
    }

    public Vicar GetVicar(String name) {
        return office.get(name);
    }

    public void SetVicar(Vicar vicar) {
        office.put(vicar.getName(), vicar);
    }

    public void clear() {
        name = "";
        office.clear();
    }

    public void DeleteVicar(String name) {
        office.remove(name);
    }

    public Collection<Vicar> Values() {
        return office.values();
    }


}
 