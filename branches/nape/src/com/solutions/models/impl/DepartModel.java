package com.solutions.mvc.models.impl;

import com.solutions.mvc.context.IContext;
import com.solutions.mvc.entities.impl.Depart;
import com.solutions.mvc.entities.impl.Vicar;
import com.solutions.mvc.models.AbstractModel;
import com.solutions.mvc.models.IModel;

public class DepartModel extends AbstractModel<Depart> {
    public DepartModel(Depart depart) {
        super(depart);
        //setParent(parent);
    }

    public void fill(IContext context) {
        entity.setChief(String.valueOf(context.getProperty("chief")));
        //entity.setChief(x);
        entity.setName(String.valueOf(context.getProperty("name")));
    }

    public void redact(IContext context, int n){
      if (n==1){
          entity.setName(String.valueOf(context.getProperty("name")));
          }
      if (n==2){
      entity.setChief(String.valueOf(context.getProperty("chief")));
      }
    }
}
