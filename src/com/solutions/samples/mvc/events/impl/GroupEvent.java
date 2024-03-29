package com.solutions.samples.mvc.events.impl;

import com.solutions.samples.mvc.context.IContext;
import com.solutions.samples.mvc.events.Event;


public enum GroupEvent implements Event{
    //console events
    FILL,
    CLEAR,
    SHOW,
    ;

    private IContext context;

    public IContext getContext() {
        return context;
    }

    public void setContext(IContext context) {
        this.context = context;
    }
}
