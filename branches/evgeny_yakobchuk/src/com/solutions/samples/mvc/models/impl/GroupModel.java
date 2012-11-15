package com.solutions.samples.mvc.models.impl;

import com.solutions.samples.mvc.context.IContext;
import com.solutions.samples.mvc.entities.impl.Group;
import com.solutions.samples.mvc.entities.impl.Student;
import com.solutions.samples.mvc.models.AbstractModel;

public class GroupModel extends AbstractModel<Group<Student>> {
    public GroupModel(Group<Student> studentGroup) {
        super(studentGroup);
    }

    public void fill(IContext context) {
        entity.setNumber((Integer) context.getProperty("number"));
        entity.setName(String.valueOf(context.getProperty("name")));
    }
}
