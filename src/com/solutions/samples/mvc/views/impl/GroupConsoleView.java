package com.solutions.samples.mvc.views.impl;

import java.io.IOException;

public class GroupConsoleView extends ConsoleView {
    public void fill() throws IOException {
        context.setProperty("name", readParameter("Group name"));
        context.setProperty("number", new Integer(readParameter("Group number")));
    }
}
