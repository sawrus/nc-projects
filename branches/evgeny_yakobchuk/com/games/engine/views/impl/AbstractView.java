package com.games.engine.views.impl;

import com.games.engine.context.IContext;
import com.games.engine.views.IView;

public abstract class AbstractView implements IView{
    protected final IContext context;

    protected AbstractView(IContext context) {
        this.context = context;
    }
}
