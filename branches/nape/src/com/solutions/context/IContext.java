package com.solutions.mvc.context;

public interface IContext {
    void setProperty(String name, Object value);
    Object getProperty(String name);
}