package com.solutions.mvc.views;

import com.solutions.mvc.context.Context;
import com.solutions.mvc.context.IContext;

public abstract class AbstractView implements IView{
    public final IContext context = new Context();
}
