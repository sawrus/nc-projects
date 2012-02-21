package com.solutions.samples.mvc.controllers;

import com.solutions.samples.mvc.events.Event;
import com.solutions.samples.mvc.models.IModel;
import com.solutions.samples.mvc.views.IView;

public abstract class AbstractController<TModel extends IModel, TView extends IView> implements IController<TModel, TView>{
    protected TModel model;
    protected TView view;

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
