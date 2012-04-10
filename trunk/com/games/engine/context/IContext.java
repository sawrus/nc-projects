package com.games.engine.context;

public interface IContext{
    Object put(Object key, Object value);
    <TValue> TValue getProperty(Object key);
    boolean containsKey(Object key);
}
