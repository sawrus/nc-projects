package com.solutions.mvc.views.impl;

import com.solutions.mvc.controllers.impl.VicarController;
import com.solutions.mvc.entities.impl.Office;
import com.solutions.mvc.entities.impl.Vicar;
import com.solutions.mvc.events.impl.VicarEvent;
import com.solutions.mvc.models.impl.VicarModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OfficeConsoleView extends ConsoleView {
    public void fill() throws IOException {
        Vicar vicar = new Vicar();
        VicarModel vicarModel = new VicarModel(vicar);
        VicarConsoleView vicarConsoleView = new VicarConsoleView();
        VicarController vicarController = new VicarController();
        vicarController.setModel(vicarModel);
        vicarController.setView(vicarConsoleView);
        vicarController.handleEvent(VicarEvent.FILL);
        context.setProperty("check depart",vicar.getDepart());
        context.setProperty("vicar", vicar);
    }

    public void show() throws IOException {
       //try{
           context.setProperty("name", readParameter("Vicar name"));
       //} catch (IOException e){
           //System.out.println("vse propalo chief, vse propalo!");
           //throw new RuntimeException(e);}
    }

    public void redact() throws IOException{
        context.setProperty("name", readParameter("Vicar name"));
    }

    public void search() throws IOException{
        context.setProperty("pattern", readParameter("Name(s)?"));
    }
}	
