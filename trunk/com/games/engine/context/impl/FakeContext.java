package com.games.engine.context.impl;

import com.games.engine.context.IContext;

public enum FakeContext implements IContext{
    FAKE_CONTEXT;

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public <TValue> TValue getProperty(Object key) {
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }
}
