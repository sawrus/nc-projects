package com.solutions.mvc.controllers;

import com.solutions.mvc.context.Context;
import com.solutions.mvc.context.IContext;
import com.solutions.mvc.events.Event;
import com.solutions.mvc.models.IModel;
import com.solutions.mvc.views.IView;

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