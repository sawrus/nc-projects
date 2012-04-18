package com.solutions.views.impl;

import com.solutions.views.AbstractView;
import com.solutions.views.ConsoleRead;
import com.solutions.views.IRead;

import java.io.IOException;

public abstract class ConsoleView extends AbstractView {

    public IRead iread = new ConsoleRead();

    public void SetIRead(IRead iread) {
        this.iread = iread;
    }

    public void show() throws IOException {
        System.out.println(context.getProperty("entity"));
    }

}