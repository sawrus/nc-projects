package com.solutions.entities;

import java.io.Serializable;

public interface IEntity extends Serializable{
    public String getName();
    public void clear();
    public String toString();
}