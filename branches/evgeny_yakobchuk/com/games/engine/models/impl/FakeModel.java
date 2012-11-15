package com.games.engine.models.impl;

import com.games.engine.context.IContext;
import com.games.engine.context.impl.FakeContext;
import com.games.engine.models.IModel;

public enum FakeModel implements IModel{
    FAKE_MODEL(FakeContext.FAKE_CONTEXT);

    private FakeModel(IContext context) {}

    @Override
    public void update() {
        System.out.println(getClass().getSimpleName());
    }
}
