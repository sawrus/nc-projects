package com.games.engine.context.impl;

import com.games.engine.context.IContext;
import com.games.engine.context.IMapContext;

import java.util.HashMap;
import java.util.Map;

public class Context extends HashMap implements IMapContext
{
    @Override
    public <T> T getProperty(Object key) {
        return (T) get(key);
    }
}
