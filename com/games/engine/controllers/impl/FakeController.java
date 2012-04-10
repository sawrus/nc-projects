package com.games.engine.controllers.impl;

import com.games.engine.context.IContext;
import com.games.engine.context.impl.FakeContext;
import com.games.engine.controllers.IController;
import com.games.engine.events.impl.FakeEvent;
import com.games.engine.models.impl.FakeModel;
import com.games.engine.views.impl.FakeView;

public enum FakeController implements IController<FakeModel, FakeView, FakeEvent>{
    FAKE_CONTROLLER(FakeModel.FAKE_MODEL, FakeView.FAKE_VIEW, FakeContext.FAKE_CONTEXT);

    private FakeController(FakeModel model, FakeView view, IContext context) {}

    @Override
    public void handleEvent(FakeEvent fakeEvent) {
        System.out.println(getClass().getSimpleName());
    }
}
