package com.solutions.mvc.models;

import com.solutions.mvc.entities.IEntity;

public interface IModel<TEntity extends IEntity> {
    void clear();
    TEntity getEntity();
}
