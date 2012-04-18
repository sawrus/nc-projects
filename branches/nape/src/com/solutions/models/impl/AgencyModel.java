package com.solutions.models.impl;

import com.solutions.context.IContext;
import com.solutions.controllers.impl.DepartController;
import com.solutions.entities.impl.Agency;
import com.solutions.entities.impl.Depart;
import com.solutions.events.impl.DepartEvent;
import com.solutions.models.AbstractModel;
import com.solutions.views.IRead;
import com.solutions.views.impl.DepartConsoleView;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgencyModel extends AbstractModel<Agency> {
    public AgencyModel(Agency agency) {
        super(agency);
    }

    public void ShowDepart(String name) {
        Depart depart = entity.GetDepart(name);
        if (depart != null) {
            DepartModel departModel = new DepartModel(depart);
            DepartConsoleView departConsoleView = new DepartConsoleView();
            DepartController departController = new DepartController();
            departController.setModel(departModel);
            departController.setView(departConsoleView);
            departController.handleEvent(DepartEvent.SHOW);
        } else {
            System.out.println("FUUUUUUUUUUUU!");
        }
    }

    public Depart ChangeDepart(String name, IRead iread) {
        ShowDepart(name);
        Depart depart = entity.GetDepart(name);
        entity.DeleteDepart(name);
        if (depart != null) {
            DepartModel departModel = new DepartModel(depart);
            DepartConsoleView departConsoleView = new DepartConsoleView();
            departConsoleView.SetIRead(iread);
            DepartController departController = new DepartController();
            departController.setModel(departModel);
            departController.setView(departConsoleView);
            departController.handleEvent(DepartEvent.REDACT);
        }
        return depart;
    }

    public void SearchDepart(String O) {
        Collection<Depart> field = entity.Values();
        Pattern pat;
        Matcher mat;
        boolean found;
        int x = 0;
        O = O.replace('*', '.');
        O = O.replace("?", ".+");
        System.out.println(O);
        pat = Pattern.compile(O);
        Iterator<Depart> itr = field.iterator();
        Depart Elem = new Depart();
        while (itr.hasNext()) {
            Depart element = itr.next();
            mat = pat.matcher(element.getName());
            found = mat.matches();
            if (found) {
                ShowDepart(element.getName());
                x++;
            }
        }

    }

    public void fill(IContext context) {
        entity.SetDepart((Depart) context.getProperty("depart"));
    }

    public void show(IContext context) {
        ShowDepart(String.valueOf(context.getProperty("title")));
    }

    public void redact(IContext context, IRead iread) {
        entity.SetDepart(ChangeDepart(String.valueOf(context.getProperty("title")), iread));
    }

    public void search(IContext context) {
        SearchDepart(String.valueOf(context.getProperty("pattern")));
    }
}

