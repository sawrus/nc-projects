package com.games.engine.models.impl;

import com.games.engine.context.IContext;
import com.games.engine.models.IModel;

public abstract class AbstractModel implements IModel{
    protected final IContext context;

    protected AbstractModel(IContext context) {
        this.context = context;
    }
}
