package com.solutions.samples.mvc.views;

import com.solutions.samples.mvc.context.Context;
import com.solutions.samples.mvc.context.IContext;
import com.solutions.samples.mvc.models.IModel;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class AbstractView<TModel extends IModel> implements IView<TModel>{
    protected TModel model;
    protected final DataInputStream input = new DataInputStream(System.in);
    public final IContext context = new Context();

    public void setModel(TModel model) {
        this.model = model;
    }

    protected String readParameter(String name) throws IOException {
        System.out.print(name + "=");
        return input.readLine();
    }
}
