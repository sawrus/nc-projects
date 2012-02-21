package com.solutions.samples.mvc.controllers.impl;

import com.solutions.samples.mvc.controllers.AbstractController;
import com.solutions.samples.mvc.entities.impl.Group;
import com.solutions.samples.mvc.entities.impl.Student;
import com.solutions.samples.mvc.events.Event;
import com.solutions.samples.mvc.events.impl.GroupEvent;
import com.solutions.samples.mvc.models.impl.GroupModel;
import com.solutions.samples.mvc.views.impl.GroupConsoleView;

public class GroupController extends AbstractController<GroupModel, GroupConsoleView> {
    private EventHandler groupEventHandler = new EventHandler() {
        public void handle(Event event) {
            switch ((GroupEvent)event){
                case CLEAR:
                    Group<Student> studentGroup = model.getEntity();
                    studentGroup.clear();
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
        if (event instanceof GroupEvent){
            groupEventHandler.handle(event);
        }
    }
}
