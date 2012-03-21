package com.solutions.mvc.events.impl;

import com.solutions.mvc.context.IContext;
import com.solutions.mvc.events.Event;


public enum DepartEvent implements Event{
    //console events
    FILL,
    CLEAR,
    SHOW,
    REDACT
    ;

    private IContext context;

    public IContext getContext() {
        return context;
    }

    public void setContext(IContext context) {
        this.context = context;
    }
}
