package com.games.engine.controllers.impl;

import com.games.engine.context.IContext;
import com.games.engine.controllers.IController;
import com.games.engine.events.IEvent;
import com.games.engine.events.IEventHandler;
import com.games.engine.models.IModel;
import com.games.engine.views.IView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class AbstractController<TModel extends IModel, TView extends IView, TEvent extends IEvent> 
        implements IController<TModel, TView, TEvent>
{

    protected final TModel model;
    protected final TView view;
    protected final IContext context;
    protected final Map<TEvent, IEventHandler> eventHandlerMap = new HashMap<TEvent, IEventHandler>();

    protected AbstractController(TModel model, TView view, IContext context) {
        this.model = model;
        this.view = view;
        this.context = context;
    }

    @Override
    public void handleEvent(TEvent event) {
        if (eventHandlerMap.containsKey(event))
            eventHandlerMap.get(event).handle();
    }
}
