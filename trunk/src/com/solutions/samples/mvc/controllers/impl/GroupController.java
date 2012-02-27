package com.solutions.samples.mvc.controllers.impl;

import com.solutions.samples.mvc.controllers.AbstractController;
import com.solutions.samples.mvc.events.Event;
import com.solutions.samples.mvc.events.impl.GroupEvent;
import com.solutions.samples.mvc.models.impl.GroupModel;
import com.solutions.samples.mvc.views.impl.GroupConsoleView;

import java.io.IOException;

public class GroupController extends AbstractController<GroupModel, GroupConsoleView> {
    private EventHandler groupEventHandler = new EventHandler() {
        public void handle(Event event) {
            switch ((GroupEvent)event){
                case CLEAR:
                    model.clear();
                    break;
                case FILL:
                    try {
                        fillGroup();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case SHOW:
                    show();
                    break;
                case ADD_STUDENT:
                    model.addStudent(context);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }

        private void fillGroup() throws IOException {
            view.fill();
            model.fill(view.context);
        }
    };

    private void show() {
        view.context.setProperty("entity", model.getEntity());
        view.show();
    }

    public void handleEvent(Event event) {
        if (event instanceof GroupEvent){
            groupEventHandler.handle(event);
        }
    }
}
