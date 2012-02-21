package com.solutions.samples.mvc.models;

import com.solutions.samples.mvc.entities.IEntity;

public abstract class AbstractModel<TEntity extends IEntity> implements IModel<TEntity>{
    protected TEntity entity;

    public void clear() {
        entity.clear();
    }

    public TEntity getEntity() {
        return entity;
    }

    public void setEntity(TEntity entity) {
        this.entity = entity;
    }
}
