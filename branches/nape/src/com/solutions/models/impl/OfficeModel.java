package com.solutions.models.impl;

import com.solutions.context.IContext;
import com.solutions.controllers.impl.DepartController;
import com.solutions.controllers.impl.VicarController;
import com.solutions.entities.impl.Agency;
import com.solutions.entities.impl.Depart;
import com.solutions.entities.impl.Office;
import com.solutions.entities.impl.Vicar;
import com.solutions.events.impl.VicarEvent;
import com.solutions.models.AbstractModel;
import com.solutions.models.IModel;
import com.solutions.views.IRead;
import com.solutions.views.impl.DepartConsoleView;
import com.solutions.views.impl.VicarConsoleView;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OfficeModel extends AbstractModel<Office> {
    public OfficeModel(Office office) {
        super(office);
    }

    public OfficeModel(Office office, IModel parent) {
        super(office);
        setParent(parent);
    }

    public void ShowVicar(String name)  throws IOException {
        Vicar vicar = entity.GetVicar(name);
        if (vicar != null) {
            DepartModel departModel = new DepartModel(vicar.getDepart());
            VicarModel vicarModel = new VicarModel(vicar, departModel);
            VicarController vicarController = new VicarController();
            VicarConsoleView vicarConsoleView = new VicarConsoleView();
            vicarController.setModel(vicarModel);
            vicarController.setView(vicarConsoleView);
            DepartController departController = new DepartController();
            DepartConsoleView departConsoleView = new DepartConsoleView();
            departController.setModel(departModel);
            departController.setView(departConsoleView);
            vicarController.handleEvent(VicarEvent.SHOW);
        }
    }

    public Vicar ChangeVicar(String name, IRead iread) throws IOException {
        ShowVicar(name);
        Vicar vicar = new Vicar();
        vicar = entity.GetVicar(name);
        entity.DeleteVicar(name);
        if (vicar != null) {
            DepartModel departModel = new DepartModel(vicar.getDepart());
            VicarModel vicarModel = new VicarModel(vicar, departModel);
            VicarController vicarController = new VicarController();
            VicarConsoleView vicarConsoleView = new VicarConsoleView();
            vicarConsoleView.SetIRead(iread);
            vicarController.setModel(vicarModel);
            vicarController.setView(vicarConsoleView);
            DepartController departController = new DepartController();
            DepartConsoleView departConsoleView = new DepartConsoleView();
            departController.setModel(departModel);
            departController.setView(departConsoleView);
            vicarController.handleEvent(VicarEvent.REDACT);
            String Y = String.valueOf(vicarController.context.getProperty("depart"));
            vicar.setDepart(((Agency) parent.getEntity()).CheckDepart(Y));
        }
        return vicar;
    }

    public void SearchVicar(String O)throws IOException {
        Collection<Vicar> field = entity.Values();
        Pattern pat;
        Matcher mat;
        boolean found;
        int x = 0;
        O = O.replace('*', '.');
        O = O.replace("?", ".+");
        System.out.println(O);
        pat = Pattern.compile(O);
        Iterator<Vicar> itr = field.iterator();
        Vicar Elem = new Vicar();
        while (itr.hasNext()) {
            Vicar element = itr.next();
            mat = pat.matcher(element.getName());
            found = mat.matches();
            if (found) {
                ShowVicar(element.getName());
                x++;
            }
        }

    }

    public void fill(IContext context) {
        Vicar y = (Vicar) context.getProperty("vicar");
        System.out.println(y.getDepart().getName());
        System.out.println(parent.getEntity());
        Depart z = ((Agency) parent.getEntity()).CheckDepart(y.getDepart().getName());
        y.setDepart(z);
        entity.SetVicar((Vicar) context.getProperty("vicar"));
    }

    public void show(IContext context)throws IOException {
        ShowVicar(String.valueOf(context.getProperty("name")));
    }

    public void redact(IContext context, IRead iread)throws IOException {
        entity.SetVicar(ChangeVicar(String.valueOf(context.getProperty("name")), iread));
    }

    public void search(IContext context)throws IOException {
        SearchVicar(String.valueOf(context.getProperty("pattern")));
    }

    public void delete(IContext context) {
        entity.DeleteVicar(String.valueOf(context.getProperty("name")));
    }
}

