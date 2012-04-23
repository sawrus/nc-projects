package com.solutions.models;

import com.solutions.entities.IEntity;

public interface IModel<TEntity extends IEntity> {
    void clear();

    TEntity getEntity();
}
