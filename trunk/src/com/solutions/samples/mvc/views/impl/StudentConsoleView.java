package com.solutions.samples.mvc.views.impl;

import com.solutions.samples.mvc.models.impl.StudentModel;
import com.solutions.samples.mvc.views.AbstractView;

public class StudentConsoleView extends AbstractView<StudentModel> {
    public void show() {
        System.out.println(model.getEntity());
    }

    public void hide() {
        model.clear();
        show();
    }
}
