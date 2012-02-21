package com.solutions.samples.mvc.views;

import com.solutions.samples.mvc.models.IModel;

public interface IView<TModel extends IModel> {
    void setModel(TModel model);
    void show();
    void hide();
}
