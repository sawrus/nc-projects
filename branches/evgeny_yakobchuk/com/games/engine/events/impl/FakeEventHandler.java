package com.games.engine.events.impl;

import com.games.engine.events.IEventHandler;

public enum FakeEventHandler implements IEventHandler{
    FAKE_EVENT_HANDLER;

    @Override
    public void handle() {
        System.out.println(getClass().getSimpleName());
    }
}
