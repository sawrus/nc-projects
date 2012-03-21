package com.solutions.mvc.models.impl;

import com.solutions.mvc.context.IContext;
import com.solutions.mvc.entities.impl.Depart;
import com.solutions.mvc.entities.impl.Office;
import com.solutions.mvc.entities.impl.Vicar;
import com.solutions.mvc.entities.impl.Agency;
import com.solutions.mvc.models.AbstractModel;
import com.solutions.mvc.models.IModel;

public class OfficeModel extends AbstractModel<Office> {
    public OfficeModel(Office office) {
        super(office);
        //setParent(parent);
    }

    public OfficeModel(Office office, IModel parent) {
        super(office);
        setParent(parent);
    }

    public void fill(IContext context) {
        Vicar y = (Vicar) context.getProperty("vicar");
        System.out.println(y.getDepart().getName());
        System.out.println(parent.getEntity());
        Depart z = ((Agency)parent.getEntity()).CheckDepart(y.getDepart().getName());
        y.setDepart(z);
        entity.SetVicar((Vicar) context.getProperty("vicar"));
        //entity.setChief(x);
        //entity.setName(String.valueOf(context.getProperty("name")));
    }

    public void show(IContext context){
        entity.ShowVicar(String.valueOf(context.getProperty("name")));
    }

     public void redact(IContext context){
        entity.ChangeVicar(String.valueOf(context.getProperty("name")));
    }

    public void search(IContext context){
        entity.SearchVicar(String.valueOf(context.getProperty("pattern")));
    }
}

