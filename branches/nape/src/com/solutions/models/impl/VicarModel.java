package com.solutions.models.impl;

import com.solutions.context.IContext;
import com.solutions.entities.impl.Depart;
import com.solutions.entities.impl.Vicar;
import com.solutions.models.AbstractModel;
import com.solutions.models.IModel;

public class VicarModel extends AbstractModel<Vicar> {
    public VicarModel(Vicar vicar, IModel parent) {
        super(vicar);
        setParent(parent);
    }

    public VicarModel(Vicar vicar) {
        super(vicar);
    }

    public void fill(IContext context) {
        Depart x = new Depart();
        x.setName(String.valueOf(context.getProperty("depart")));
        entity.setDepart(x);
        entity.setName(String.valueOf(context.getProperty("name")));
        entity.setLastName(String.valueOf(context.getProperty("lastName")));
        entity.setSecondName(String.valueOf(context.getProperty("secondName")));
        entity.setPhone(String.valueOf(context.getProperty("phone")));
        entity.setSalary(Integer.valueOf(String.valueOf(context.getProperty("salary"))));
    }

    public String redact(IContext context) {
        entity.setName(String.valueOf(context.getProperty("name")));
        entity.setLastName(String.valueOf(context.getProperty("lastName")));
        entity.setSecondName(String.valueOf(context.getProperty("secondName")));
        entity.setPhone(String.valueOf(context.getProperty("phone")));
        entity.setSalary(Integer.valueOf(String.valueOf(context.getProperty("salary"))));
        return String.valueOf(context.getProperty("depart"));
    }
}