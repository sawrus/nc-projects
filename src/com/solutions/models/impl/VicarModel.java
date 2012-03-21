package com.solutions.mvc.models.impl;

import com.solutions.mvc.context.IContext;
import com.solutions.mvc.entities.impl.Depart;
import com.solutions.mvc.entities.impl.Vicar;
import com.solutions.mvc.models.AbstractModel;
import com.solutions.mvc.models.IModel;

import java.util.Date;

public class VicarModel extends AbstractModel<Vicar> {
    public VicarModel(Vicar vicar, IModel parent) {
        super(vicar);
        setParent(parent);
    }

    public VicarModel(Vicar vicar) {
        super(vicar);
    }

    public void fill(IContext context){
        Depart x = new Depart();
        x.setName(String.valueOf(context.getProperty("depart")));
        entity.setDepart(x);
        entity.setName(String.valueOf(context.getProperty("name")));
        entity.setLastName(String.valueOf(context.getProperty("lastName")));
        entity.setSecondName(String.valueOf(context.getProperty("secondName")));
		entity.setPhone(String.valueOf(context.getProperty("phone")));
		entity.setSalary(Integer.valueOf(String.valueOf(context.getProperty("salary"))));
    }
}