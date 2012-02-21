package com.solutions.samples.mvc.context;

public interface Context {
    void setProperty(String name, Object value);
    Object getProperty(String name);
}
