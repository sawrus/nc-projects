package com.solutions.samples.mvc.controllers.impl;

import com.solutions.samples.mvc.controllers.AbstractController;
import com.solutions.samples.mvc.entities.impl.Group;
import com.solutions.samples.mvc.entities.impl.Student;
import com.solutions.samples.mvc.events.Event;
import com.solutions.samples.mvc.events.impl.GroupEvent;
import com.solutions.samples.mvc.models.impl.GroupModel;
import com.solutions.samples.mvc.views.impl.GroupConsoleView;

import java.io.IOException;

public class GroupController extends AbstractController<GroupModel, GroupConsoleView> {
    private EventHandler groupEventHandler = new EventHandler() {
        private Group<Student> entity;

        public void handle(Event event) {
            entity = model.getEntity();
            switch ((GroupEvent)event){
                case CLEAR:
                    entity.clear();
                    break;
                case FILL:
                    fillGroup();
                    break;
                case SHOW:
                    view.show();
                    break;
                case ADD_STUDENT:
                    entity.addStudent((Student) context.getProperty("student"));
                    break;
                default:
                    throw new IllegalStateException();
            }
        }

        private void fillGroup() {
            try {
                view.fill();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            entity.setNumber((Integer) view.context.getProperty("number"));
            entity.setName(String.valueOf(view.context.getProperty("name")));
        }
    };

    public void handleEvent(Event event) {
        if (event instanceof GroupEvent){
            groupEventHandler.handle(event);
        }
    }
}
