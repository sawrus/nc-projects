package com.solutions.views.impl;

import com.solutions.controllers.impl.VicarController;
import com.solutions.entities.impl.Vicar;
import com.solutions.events.impl.VicarEvent;
import com.solutions.models.impl.VicarModel;

import java.io.IOException;

public class OfficeConsoleView extends ConsoleView {
    public void fill() throws IOException {
        Vicar vicar = new Vicar();
        VicarModel vicarModel = new VicarModel(vicar);
        VicarConsoleView vicarConsoleView = new VicarConsoleView();
        vicarConsoleView.SetIRead(this.iread);
        VicarController vicarController = new VicarController();
        vicarController.setModel(vicarModel);
        vicarController.setView(vicarConsoleView);
        vicarController.handleEvent(VicarEvent.FILL);
        context.setProperty("check depart", vicar.getDepart());
        context.setProperty("vicar", vicar);
    }

    public void show() throws IOException {    
        context.setProperty("name", iread.readParameter("Vicar name"));    
    }

    public void redact() throws IOException {
        context.setProperty("name", iread.readParameter("Vicar name"));
    }

    public void search() throws IOException {
        context.setProperty("pattern", iread.readParameter("Name(s)?"));
    }
    
    public void delete() throws IOException {
        context.setProperty("name", iread.readParameter("Vicar name"));
    }
}	
