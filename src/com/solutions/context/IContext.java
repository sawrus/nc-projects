package com.solutions.context;

public interface IContext {
    void setProperty(String name, Object value);
    Object getProperty(String name);
}