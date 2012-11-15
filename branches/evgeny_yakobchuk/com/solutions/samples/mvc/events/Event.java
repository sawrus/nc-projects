package com.solutions.samples.mvc.events;


import com.solutions.samples.mvc.context.IContext;

public interface Event {
    IContext getContext();
    void setContext(IContext context);
}
