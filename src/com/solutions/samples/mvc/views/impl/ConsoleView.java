package com.solutions.samples.mvc.views.impl;

import com.solutions.samples.mvc.views.AbstractView;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class ConsoleView extends AbstractView{
    protected final DataInputStream input = new DataInputStream(System.in);

    public void show() {
        System.out.println(context.getProperty("entity"));
    }

    protected String readParameter(String name) throws IOException {
        System.out.print(name + "=");
        return input.readLine();
    }
}
