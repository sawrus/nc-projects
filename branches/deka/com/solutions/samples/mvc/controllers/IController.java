package com.solutions.samples.mvc.controllers;

import com.solutions.samples.mvc.events.Event;
import com.solutions.samples.mvc.models.IModel;
import com.solutions.samples.mvc.views.IView;

public interface IController<TModel extends IModel, TView extends IView> {
    void setModel(TModel model);
    void setView(TView view);
    void handleEvent(Event event);
}
