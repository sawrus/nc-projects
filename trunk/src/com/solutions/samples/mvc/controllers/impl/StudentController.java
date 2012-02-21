package com.solutions.samples.mvc.controllers.impl;

import com.solutions.samples.mvc.controllers.AbstractController;
import com.solutions.samples.mvc.entities.impl.Group;
import com.solutions.samples.mvc.entities.impl.Student;
import com.solutions.samples.mvc.events.Event;
import com.solutions.samples.mvc.events.impl.StudentEvent;
import com.solutions.samples.mvc.models.impl.StudentModel;
import com.solutions.samples.mvc.views.impl.StudentConsoleView;

import java.io.IOException;
import java.util.Date;

public class StudentController extends AbstractController<StudentModel, StudentConsoleView> {
    private final EventHandler studentEventHandler = new EventHandler() {
        private Student entity;
        public void handle(Event event) {
            entity = model.getEntity();
            switch ((StudentEvent)event){
                case CLEAR:
                    entity.clear();
                    break;
                case FILL:
                    fillStudent();
                    break;
                case SHOW:
                    view.show();
                    break;
                default:
                    throw new IllegalStateException();
            }
        }

        private void fillStudent() {
            try {
                view.fill();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            entity.setGroup((Group) context.getProperty("group"));
            entity.setStartLearn((Date) context.getProperty("startLearn"));

            entity.setName(String.valueOf(view.context.getProperty("name")));
            entity.setLastName(String.valueOf(view.context.getProperty("lastName")));
            entity.setSecondName(String.valueOf(view.context.getProperty("secondName")));
        }
    };

    public void handleEvent(Event event) {
        if (event instanceof StudentEvent){
            studentEventHandler.handle(event);
        }
    }
}
