package com.solutions.mvc.controllers;

import com.solutions.mvc.events.Event;
import com.solutions.mvc.models.IModel;
import com.solutions.mvc.views.IView;

public interface IController<TModel extends IModel, TView extends IView> {
    void setModel(TModel model);
    void setView(TView view);
    void handleEvent(Event event);
}