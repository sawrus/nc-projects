package com.solutions.views.impl;

import com.solutions.controllers.impl.DepartController;
import com.solutions.entities.impl.Depart;
import com.solutions.events.impl.DepartEvent;
import com.solutions.models.impl.DepartModel;

import java.io.IOException;

public class AgencyConsoleView extends ConsoleView {
    public void fill() throws IOException {
        Depart depart = new Depart();
        DepartModel departModel = new DepartModel(depart);
        DepartConsoleView departConsoleView = new DepartConsoleView();
        departConsoleView.SetIRead(this.iread);
        DepartController departController = new DepartController();
        departController.setModel(departModel);
        departController.setView(departConsoleView);
        departController.handleEvent(DepartEvent.FILL);
        context.setProperty("depart", depart);
    }

    public void show() throws IOException {
        
        context.setProperty("title", iread.readParameter("Depart title"));
        
    }

    public void redact() throws IOException {
        context.setProperty("title", iread.readParameter("Depart title"));
    }

    public void search() throws IOException {
        context.setProperty("pattern", iread.readParameter("Title(s)?"));
    }
    
    public void delete() throws IOException {
        context.setProperty("title", iread.readParameter("Depart title"));
    }
}
