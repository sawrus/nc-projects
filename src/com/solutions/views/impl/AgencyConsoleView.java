package com.solutions.mvc.views.impl;

import com.solutions.mvc.controllers.impl.DepartController;
import com.solutions.mvc.entities.impl.Agency;
import com.solutions.mvc.entities.impl.Depart;
import com.solutions.mvc.events.impl.DepartEvent;
import com.solutions.mvc.models.impl.DepartModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AgencyConsoleView extends ConsoleView {
    public void fill() throws IOException {
        Depart depart = new Depart();
        DepartModel departModel = new DepartModel(depart);
        DepartConsoleView departConsoleView = new DepartConsoleView();
        DepartController departController = new DepartController();
        departController.setModel(departModel);
        departController.setView(departConsoleView);
        departController.handleEvent(DepartEvent.FILL);
        context.setProperty("depart", depart);
    }

    public void show() throws IOException {
       //try{
           context.setProperty("title", readParameter("Depart title"));
       //} catch (IOException e){throw new RuntimeException(e);}
    }

    public void redact() throws IOException{
        context.setProperty("title", readParameter("Depart title"));
    }

    public void search() throws IOException{
        context.setProperty("pattern", readParameter("Title(s)?"));
    }
}
