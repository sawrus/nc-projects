package com.solutions.models.impl;

import com.solutions.context.IContext;
import com.solutions.entities.impl.Depart;
import com.solutions.models.AbstractModel;

public class DepartModel extends AbstractModel<Depart> {
    public DepartModel(Depart depart) {
        super(depart);
    }

    public void fill(IContext context) {
        entity.setChief(String.valueOf(context.getProperty("chief")));
        entity.setName(String.valueOf(context.getProperty("name")));
    }

    public void redact(IContext context) {
        entity.setName(String.valueOf(context.getProperty("name")));
        entity.setChief(String.valueOf(context.getProperty("chief")));

    }
}
