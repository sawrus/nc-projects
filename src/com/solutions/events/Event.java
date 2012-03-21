package com.solutions.mvc.events;


import com.solutions.mvc.context.IContext;

public interface Event {
    IContext getContext();
    void setContext(IContext context);
}