package com.solutions.samples.mvc.views.impl;

import com.solutions.samples.mvc.models.impl.GroupModel;
import com.solutions.samples.mvc.views.AbstractView;

public class GroupConsoleView extends AbstractView<GroupModel> {

    public void show() {
        model.getEntity().toString();
    }

    public void hide() {
        model.clear();
        show();
    }
}
