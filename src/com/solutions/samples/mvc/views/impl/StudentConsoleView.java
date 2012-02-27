package com.solutions.samples.mvc.views.impl;

import java.io.IOException;
import java.util.Date;

public class StudentConsoleView extends ConsoleView {
    public void fill() throws IOException {
        context.setProperty("startLearn", new Date());
        context.setProperty("name", readParameter("Student name"));
        context.setProperty("secondName", readParameter("Student secondName"));
        context.setProperty("lastName", readParameter("Student lastName"));
    }
}
