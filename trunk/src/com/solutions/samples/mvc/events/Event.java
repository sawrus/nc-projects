package com.solutions.samples.mvc.events;


import com.solutions.samples.mvc.context.Context;

public interface Event {
    Context getContext();
    void setContext(Context context);
}
