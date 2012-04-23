package com.solutions.controllers;

import com.solutions.context.Context;
import com.solutions.context.IContext;
import com.solutions.events.Event;
import com.solutions.models.IModel;
import com.solutions.views.IView;

public abstract class AbstractController<TModel extends IModel, TView extends IView> implements IController<TModel, TView>{
    protected TModel model;
    protected TView view;
    public final IContext context = new Context();

    public void setModel(TModel model) {
        this.model = model;
    }

    public void setView(TView view) {
        this.view = view;
    }

    public static interface EventHandler {
        void handle(Event event);
    }
}