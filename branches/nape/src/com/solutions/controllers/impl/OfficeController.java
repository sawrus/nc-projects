package com.solutions.mvc.controllers.impl;

import com.solutions.mvc.controllers.AbstractController;
import com.solutions.mvc.events.Event;
import com.solutions.mvc.events.impl.VicarEvent;
import com.solutions.mvc.events.impl.OfficeEvent;
import com.solutions.mvc.models.impl.OfficeModel;
import com.solutions.mvc.views.impl.OfficeConsoleView;

import java.io.IOException;

public class OfficeController extends AbstractController<OfficeModel, OfficeConsoleView> {
    private final EventHandler officeEventHandler = new EventHandler() {
        public void handle(Event event) {
            switch ((OfficeEvent)event){
                case CLEAR:
                    model.clear();
                    break;
                case FILL:
                    try {
                        System.out.println("yes");
                        fillVicar();
                        System.out.println("yes");
                    } catch (IOException e) {
                        System.out.println("no");
                        throw new RuntimeException(e);
                    }
                    break;
                case SHOW:
                    try {
                        show();
                    }catch (IOException e) {
                       throw new RuntimeException(e);
                    }
                    break;
                case REDACT:
                    try {
                        redact();
                    }catch (IOException e) {
                       throw new RuntimeException(e);
                    }
                    break;
                case SEARCH:
                    try {
                        search();
                    }catch (IOException e) {
                       throw new RuntimeException(e);
                    }
                    break;
                default:
                    throw new IllegalStateException();
            }
        }

        private void fillVicar() throws IOException {
            view.fill();
            model.fill(view.context);
        }
    };

    private void search () throws IOException{
       view.search();
       model.search(view.context);
    }

    private void show() throws IOException {
        view.show();
        model.show(view.context);
    }

    private void redact() throws IOException {
        view.redact();
        model.redact(view.context);
    }

    public void handleEvent(Event event) {
        if (event instanceof OfficeEvent){
            officeEventHandler.handle(event);
        }
    }
}