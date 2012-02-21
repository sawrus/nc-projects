package com.solutions.samples.mvc.context;

import com.sun.deploy.util.Property;

public interface Context {
    void setProperty(Property property);
    Property getProperty(String name);
}
