package com.solutions.samples.mvc.events.impl;

import com.solutions.samples.mvc.context.Context;
import com.solutions.samples.mvc.events.Event;


public enum StudentEvent implements Event{
    CLEAR,
    FILL,
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
