package com.solutions.samples.mvc.views;

import com.solutions.samples.mvc.models.IModel;

public abstract class AbstractView<TModel extends IModel> implements IView<TModel>{
    protected TModel model;

    public void setModel(TModel model) {
        this.model = model;
    }
}
