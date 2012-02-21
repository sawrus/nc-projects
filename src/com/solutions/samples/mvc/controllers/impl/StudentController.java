package com.solutions.samples.mvc.controllers.impl;

import com.solutions.samples.mvc.context.Context;
import com.solutions.samples.mvc.controllers.AbstractController;
import com.solutions.samples.mvc.entities.impl.Group;
import com.solutions.samples.mvc.entities.impl.Student;
import com.solutions.samples.mvc.events.Event;
import com.solutions.samples.mvc.events.impl.StudentEvent;
import com.solutions.samples.mvc.models.impl.StudentModel;
import com.solutions.samples.mvc.views.impl.StudentConsoleView;

import java.util.Date;

public class StudentController extends AbstractController<StudentModel, StudentConsoleView> {
    private EventHandler studentEventHandler = new EventHandler() {
        private Student entity;
        private Context context;

        public void handle(Event event) {
            entity = model.getEntity();
            context = event.getContext();
            switch ((StudentEvent)event){
                case CLEAR:
                    entity.clear();
                    break;
                case FILL:
                    entity.setGroup((Group) context.getProperty("group"));
                    entity.setStartLearn((Date) context.getProperty("startLearn"));
                    entity.setName(String.valueOf(context.getProperty("name")));
                    entity.setLastName(String.valueOf(context.getProperty("lastName")));
                    entity.setSecondName(String.valueOf(context.getProperty("secondName")));
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
