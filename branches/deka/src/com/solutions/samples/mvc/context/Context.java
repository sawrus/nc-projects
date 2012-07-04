package com.solutions.samples.mvc.context;

import java.util.HashMap;
import java.util.Map;

public class Context implements IContext{
    private final Map<String, Object> properties = new HashMap<String, Object>();

    public void setProperty(String name, Object value) {
        properties.put(name, value);
    }

    public Object getProperty(String name) {
        return properties.get(name);
    }
}
