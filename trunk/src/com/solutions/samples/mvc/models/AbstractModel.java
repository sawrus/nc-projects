package com.solutions.samples.mvc.models;

import com.solutions.samples.mvc.entities.IEntity;

public abstract class AbstractModel<TEntity extends IEntity> implements IModel<TEntity>{
    protected TEntity entity;
    protected IModel parent;

    public void setParent(IModel parent) {
        this.parent = parent;
    }

    protected AbstractModel(TEntity entity) {
        this.entity = entity;
    }

    public void clear() {
        entity.clear();
    }

    public TEntity getEntity() {
        return entity;
    }
}
