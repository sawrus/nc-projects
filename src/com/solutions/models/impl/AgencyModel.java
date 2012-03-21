package com.solutions.mvc.models.impl;

import com.solutions.mvc.context.IContext;
import com.solutions.mvc.entities.impl.Agency;
import com.solutions.mvc.entities.impl.Depart;
import com.solutions.mvc.models.AbstractModel;
import com.solutions.mvc.models.IModel;

public class AgencyModel extends AbstractModel<Agency> {
    public AgencyModel(Agency agency) {
        super(agency);
        //setParent(parent);
    }

    public void fill(IContext context) {
        entity.SetDepart((Depart) context.getProperty("depart"));
        //entity.setChief(x);
        //entity.setName(String.valueOf(context.getProperty("name")));
    }

    public void show(IContext context){
        entity.ShowDepart(String.valueOf(context.getProperty("title")));
    }

     public void redact(IContext context){
        entity.ChangeDepart(String.valueOf(context.getProperty("title")));
    }

    public void search(IContext context){
        entity.SearchDepart(String.valueOf(context.getProperty("pattern")));
    }

    public Depart checking(String string){
       return entity.CheckDepart(string);
    }
}

