package com.solutions.mvc.controllers.impl;

import com.solutions.mvc.controllers.AbstractController;
import com.solutions.mvc.events.Event;
import com.solutions.mvc.events.impl.VicarEvent;
import com.solutions.mvc.models.impl.VicarModel;
import com.solutions.mvc.views.impl.VicarConsoleView;

import java.io.IOException;

public class VicarController extends AbstractController<VicarModel, VicarConsoleView> {
    private final EventHandler vicarEventHandler = new EventHandler() {
        public void handle(Event event) {
            switch ((VicarEvent)event){
                case CLEAR:
                    model.clear();
                    break;
                case FILL:
                    try {
                        fillVicar();
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

        private void fillVicar() throws IOException {
            view.fill();
            model.fill(view.context);
        }
    };

    private void show()throws IOException {
        view.context.setProperty("entity", model.getEntity());
        view.show();
    }

    private void redact() throws IOException {
        view.context.setProperty("entity", model.getEntity());
        view.redact();
    }

    public void handleEvent(Event event) {
        if (event instanceof VicarEvent){
            vicarEventHandler.handle(event);
        }
    }
}