package com.solutions.controllers.impl;

import com.solutions.controllers.AbstractController;
import com.solutions.events.Event;
import com.solutions.events.impl.DepartEvent;
import com.solutions.models.impl.DepartModel;
import com.solutions.views.impl.DepartConsoleView;

import java.io.IOException;

public class DepartController extends AbstractController<DepartModel, DepartConsoleView> {
    private EventHandler departEventHandler = new EventHandler() {
        public void handle(Event event) throws IOException {
            switch ((DepartEvent) event) {
                case CLEAR:
                    model.clear();
                    break;
                case FILL:
                    fillDepart();
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

        private void fillDepart() throws IOException {
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
        view.context.setProperty("chief", model.getEntity().getChief());
        view.redact();
        model.redact(view.context);
    }

    public void handleEvent(Event event) throws IOException {
        if (event instanceof DepartEvent) {
            departEventHandler.handle(event);
        }
    }
}