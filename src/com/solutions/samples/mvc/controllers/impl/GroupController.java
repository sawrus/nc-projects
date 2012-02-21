package com.solutions.samples.mvc.controllers.impl;

import com.solutions.samples.mvc.context.Context;
import com.solutions.samples.mvc.controllers.AbstractController;
import com.solutions.samples.mvc.entities.impl.Group;
import com.solutions.samples.mvc.entities.impl.Student;
import com.solutions.samples.mvc.events.Event;
import com.solutions.samples.mvc.events.impl.GroupEvent;
import com.solutions.samples.mvc.models.impl.GroupModel;
import com.solutions.samples.mvc.views.impl.GroupConsoleView;

public class GroupController extends AbstractController<GroupModel, GroupConsoleView> {
    private EventHandler groupEventHandler = new EventHandler() {
        private Group<Student> entity;
        private Context context;

        public void handle(Event event) {
            entity = model.getEntity();
            context = event.getContext();
            switch ((GroupEvent)event){
                case CLEAR:
                    entity.clear();
                    break;
                case FILL:
                    entity.setNumber((Integer) context.getProperty("number"));
                    entity.setName(String.valueOf(context.getProperty("name")));
                    break;
                case SHOW:
                    view.show();
                    break;
                case ADD_STUDENT:
                    entity.addStudent((Student)context.getProperty("student"));
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    };

    public void handleEvent(Event event) {
        if (event instanceof GroupEvent){
            groupEventHandler.handle(event);
        }
    }
}
