package com.solutions.samples.mvc.controllers.impl;

import com.solutions.samples.mvc.controllers.AbstractController;
import com.solutions.samples.mvc.events.Event;
import com.solutions.samples.mvc.events.impl.StudentEvent;
import com.solutions.samples.mvc.models.impl.StudentModel;
import com.solutions.samples.mvc.views.impl.StudentConsoleView;

import java.io.IOException;

public class StudentController extends AbstractController<StudentModel, StudentConsoleView> {
    private final EventHandler studentEventHandler = new EventHandler() {
        public void handle(Event event) {
            switch ((StudentEvent)event){
                case CLEAR:
                    model.clear();
                    break;
                case FILL:
                    try {
                        fillStudent();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case SHOW:
                    show();
                    break;
                default:
                    throw new IllegalStateException();
            }
        }

        private void fillStudent() throws IOException {
            view.fill();
            model.fillPrimaryInformation(context);
            model.fillSecondaryInformation(view.context);
        }
    };

    private void show() {
        view.context.setProperty("entity", model.getEntity());
        view.show();
    }

    public void handleEvent(Event event) {
        if (event instanceof StudentEvent){
            studentEventHandler.handle(event);
        }
    }
}
