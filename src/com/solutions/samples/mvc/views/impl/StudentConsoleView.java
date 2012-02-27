package com.solutions.samples.mvc.views.impl;

import java.io.IOException;

public class StudentConsoleView extends ConsoleView {
    public void fill() throws IOException {
        context.setProperty("name", readParameter("Student name"));
        context.setProperty("secondName", readParameter("Student secondName"));
        context.setProperty("lastName", readParameter("Student lastName"));
    }
}
