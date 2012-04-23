package com.solutions.controllers.impl;

import com.solutions.controllers.AbstractController;
import com.solutions.events.Event;
import com.solutions.events.impl.VicarEvent;
import com.solutions.models.impl.VicarModel;
import com.solutions.views.impl.VicarConsoleView;

import java.io.IOException;

public class VicarController extends AbstractController<VicarModel, VicarConsoleView> {
    private final EventHandler vicarEventHandler = new EventHandler() {
        public void handle(Event event) throws IOException {
            switch ((VicarEvent) event) {
                case CLEAR:
                    model.clear();
                    break;
                case FILL:
                    fillVicar();
                    break;
                case SHOW:
                    show();
                    break;
                case REDACT:
                    redact();
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

    private void show() throws IOException {
        view.context.setProperty("entity", model.getEntity());
        view.show();
    }

    private void redact() throws IOException {
        view.context.setProperty("entity", model.getEntity());
        view.context.setProperty("name", model.getEntity().getName());
        view.context.setProperty("secondName", model.getEntity().getSecondName());
        view.context.setProperty("lastName", model.getEntity().getLastName());
        view.context.setProperty("depart", model.getEntity().getDepart().getName());
        view.context.setProperty("phone", model.getEntity().getPhone());
        view.context.setProperty("salary", model.getEntity().getSalary());
        view.redact();
        context.setProperty("depart", model.redact(view.context));

    }

    public void handleEvent(Event event) throws IOException {
        if (event instanceof VicarEvent) {
            vicarEventHandler.handle(event);
        }
    }
}