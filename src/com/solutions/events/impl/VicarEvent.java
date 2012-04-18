package com.solutions.events.impl;

import com.solutions.context.IContext;
import com.solutions.events.Event;


public enum VicarEvent implements Event {
    //console events
    CLEAR,
    FILL,
    SHOW,
    REDACT;

    private IContext context;

    public IContext getContext() {
        return context;
    }

    public void setContext(IContext context) {
        this.context = context;
    }
}