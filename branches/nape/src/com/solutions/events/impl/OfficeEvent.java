package com.solutions.mvc.events.impl;

import com.solutions.mvc.context.IContext;
import com.solutions.mvc.events.Event;


public enum OfficeEvent implements Event{
    //console events
    FILL,
    CLEAR,
    SHOW,
    REDACT,
	SEARCH
    ;

    private IContext context;

    public IContext getContext() {
        return context;
    }

    public void setContext(IContext context) {
        this.context = context;
    }
}
