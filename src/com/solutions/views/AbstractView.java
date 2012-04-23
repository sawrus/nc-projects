package com.solutions.views;

import com.solutions.context.Context;
import com.solutions.context.IContext;

public abstract class AbstractView implements IView{
    public final IContext context = new Context();
}
