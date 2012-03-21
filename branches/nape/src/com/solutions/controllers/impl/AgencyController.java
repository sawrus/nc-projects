package com.solutions.mvc.controllers.impl;

import com.solutions.mvc.controllers.AbstractController;
import com.solutions.mvc.events.Event;
import com.solutions.mvc.events.impl.VicarEvent;
import com.solutions.mvc.events.impl.AgencyEvent;
import com.solutions.mvc.models.impl.AgencyModel;
import com.solutions.mvc.views.impl.AgencyConsoleView;

import java.io.IOException;

public class AgencyController extends AbstractController<AgencyModel, AgencyConsoleView> {
    private final EventHandler agencyEventHandler = new EventHandler() {
        public void handle(Event event) {
            switch ((AgencyEvent)event){
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

        private void fillDepart() throws IOException {
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
        if (event instanceof AgencyEvent){
            agencyEventHandler.handle(event);
        }
    }
}