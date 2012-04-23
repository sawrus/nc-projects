package com.solutions.events;


import com.solutions.context.IContext;

public interface Event {
    IContext getContext();
    void setContext(IContext context);
}