package com.solutions.samples.mvc.views;

import com.solutions.samples.mvc.context.Context;
import com.solutions.samples.mvc.context.IContext;

public abstract class AbstractView implements IView{
    public final IContext context = new Context();
}
