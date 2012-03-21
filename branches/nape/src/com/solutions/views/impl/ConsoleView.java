package com.solutions.mvc.views.impl;

import com.solutions.mvc.views.AbstractView;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class ConsoleView extends AbstractView{
    protected final DataInputStream input = new DataInputStream(System.in);

    public void show() throws IOException {
        System.out.println(context.getProperty("entity"));
    }

    protected String readParameter(String name) throws IOException {
        System.out.print(name + "=");
        return input.readLine();
    }
}