package com.solutions.samples.mvc.context;

public interface IContext {
    void setProperty(String name, Object value);
    Object getProperty(String name);
}
