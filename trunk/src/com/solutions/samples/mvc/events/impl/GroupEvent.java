package com.solutions.samples.mvc.events.impl;

import com.solutions.samples.mvc.context.Context;
import com.solutions.samples.mvc.events.Event;


public enum GroupEvent implements Event{
    ADD_STUDENT,
    REMOVE_STUDENT,
    FILL,
    CLEAR,
    SHOW
    ;

    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
