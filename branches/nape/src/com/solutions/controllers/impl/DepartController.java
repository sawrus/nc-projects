package com.solutions.mvc.controllers.impl;

import com.solutions.mvc.controllers.AbstractController;
import com.solutions.mvc.events.Event;
import com.solutions.mvc.events.impl.DepartEvent;
import com.solutions.mvc.models.impl.DepartModel;
import com.solutions.mvc.views.impl.DepartConsoleView;

import java.io.IOException;

public class DepartController extends AbstractController<DepartModel, DepartConsoleView> {
    private EventHandler departEventHandler = new EventHandler() {
        public void handle(Event event) {
            switch ((DepartEvent)event){
                case CLEAR:
                    model.clear();
                    break;
                case FILL:
                    try {
                        fillDepart();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case SHOW:
                    try {
                        show();
                    } catch (IOException e) {
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
                default:
                    throw new IllegalStateException();
            }
        }

        private void fillDepart() throws IOException {
            view.fill();
            model.fill(view.context);
        }
    };

    private void show() throws IOException{
        view.context.setProperty("entity", model.getEntity());
        view.show();
    }

    private void redact() throws IOException {
        view.context.setProperty("entity", model.getEntity());
        int n = view.redact();
        model.redact(view.context, n);
    }

    public void handleEvent(Event event) {
        if (event instanceof DepartEvent){
            departEventHandler.handle(event);
        }
    }
}