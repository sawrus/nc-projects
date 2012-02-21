package com.solutions.samples.mvc.views.impl;

import com.solutions.samples.mvc.models.impl.StudentModel;
import com.solutions.samples.mvc.views.AbstractView;

import java.io.IOException;

public class StudentConsoleView extends AbstractView<StudentModel> {
    public void show() {
        System.out.println(model.getEntity());
    }

    public void hide() {}

    public void fill() throws IOException {
        context.setProperty("name", readParameter("Student name"));
        context.setProperty("secondName", readParameter("Student secondName"));
        context.setProperty("lastName", readParameter("Student lastName"));
    }
}
