package com.solutions.controllers;

import com.solutions.events.Event;
import com.solutions.models.IModel;
import com.solutions.views.IView;

public interface IController<TModel extends IModel, TView extends IView> {
    void setModel(TModel model);
    void setView(TView view);
    void handleEvent(Event event)throws IOException;
}