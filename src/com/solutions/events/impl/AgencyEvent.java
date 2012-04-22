package com.solutions.events.impl;

import com.solutions.context.IContext;
import com.solutions.events.Event;


public enum AgencyEvent implements Event {
    //console events
    FILL,
    CLEAR,
    SHOW,
    REDACT,
    SEARCH,
    DELETE;

    private IContext context;

    public IContext getContext() {
        return context;
    }

    public void setContext(IContext context) {
        this.context = context;
    }
}
