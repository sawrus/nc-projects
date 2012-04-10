package com.games.engine.views.impl;

import com.games.engine.context.IContext;
import com.games.engine.context.impl.FakeContext;
import com.games.engine.views.IView;

public enum FakeView implements IView{
    FAKE_VIEW(FakeContext.FAKE_CONTEXT);

    private FakeView(IContext context) {}

    @Override
    public void update() {
        System.out.println(getClass().getSimpleName());
    }
}
