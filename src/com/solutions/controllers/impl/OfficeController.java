package com.solutions.controllers.impl;

import com.solutions.controllers.AbstractController;
import com.solutions.events.Event;
import com.solutions.events.impl.OfficeEvent;
import com.solutions.models.impl.OfficeModel;
import com.solutions.views.impl.OfficeConsoleView;

import java.io.IOException;

public class OfficeController extends AbstractController<OfficeModel, OfficeConsoleView> {
    private final EventHandler officeEventHandler = new EventHandler() {
        public void handle(Event event) throws IOException {
            switch ((OfficeEvent) event) {
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
                case SEARCH:
                    search();
                    break;
                case DELETE:
                    delete();
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

    private void search() throws IOException {
        view.search();
        model.search(view.context);
    }

    private void show() throws IOException {
        view.show();
        model.show(view.context);
    }

    private void redact() throws IOException {
        view.redact();
        model.redact(view.context, view.iread);
    }

    private void delete() throws IOException {
        view.delete();
        model.delete(view.context);
    }

    public void handleEvent(Event event) throws IOException {
        if (event instanceof OfficeEvent) {
            officeEventHandler.handle(event);
        }
    }
}