package com.games.engine.controllers;

import com.games.engine.events.IEvent;
import com.games.engine.models.IModel;
import com.games.engine.views.IView;

public interface IController<TModel extends IModel, TView extends IView, TEvent extends IEvent>
{
    void handleEvent(TEvent event);
}
