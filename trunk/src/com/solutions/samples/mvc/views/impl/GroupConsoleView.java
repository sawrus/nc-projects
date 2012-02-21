package com.solutions.samples.mvc.views.impl;

import com.solutions.samples.mvc.models.impl.GroupModel;
import com.solutions.samples.mvc.views.AbstractView;

import java.io.IOException;

public class GroupConsoleView extends AbstractView<GroupModel> {

    public void show() {
        System.out.println(model.getEntity());
    }

    public void hide() {}

    public void fill() throws IOException {
        context.setProperty("name", readParameter("Group name"));
        context.setProperty("number", new Integer(readParameter("Group number")));
    }
}
