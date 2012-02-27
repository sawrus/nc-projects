package com.solutions.samples.mvc.models;

import com.solutions.samples.mvc.entities.IEntity;

public interface IModel<TEntity extends IEntity> {
    void clear();
    TEntity getEntity();
}

