package com.solutions.samples.mvc.controllers.impl;

import com.solutions.samples.mvc.controllers.AbstractController;
import com.solutions.samples.mvc.entities.impl.Student;
import com.solutions.samples.mvc.events.Event;
import com.solutions.samples.mvc.events.impl.StudentEvent;
import com.solutions.samples.mvc.models.impl.StudentModel;
import com.solutions.samples.mvc.views.impl.StudentConsoleView;

public class StudentController extends AbstractController<StudentModel, StudentConsoleView> {
    private EventHandler studentEventHandler = new EventHandler() {
        public void handle(Event event) {
            switch ((StudentEvent)event){
                case CLEAR:
                    Student entity = model.getEntity();
                    entity.clear();
                    break;
                case FILL:
                    //todo implementation
                    break;
                case SHOW:
                    view.show();
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    };

    public void handleEvent(Event event) {
        if (event instanceof StudentEvent){
            studentEventHandler.handle(event);
        }
    }
}
