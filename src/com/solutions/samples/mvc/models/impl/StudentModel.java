package com.solutions.samples.mvc.models.impl;

import com.solutions.samples.mvc.context.IContext;
import com.solutions.samples.mvc.entities.impl.Group;
import com.solutions.samples.mvc.entities.impl.Student;
import com.solutions.samples.mvc.models.AbstractModel;
import com.solutions.samples.mvc.models.IModel;

import java.util.Date;

public class StudentModel extends AbstractModel<Student> {
    public StudentModel(Student student, IModel parent) {
        super(student);
        setParent(parent);
    }

    public StudentModel(Student student) {
        super(student);
    }

    public void fill(IContext context){
        entity.setGroup((Group) parent.getEntity());
        entity.setStartLearn((Date) context.getProperty("startLearn"));
        entity.setName(String.valueOf(context.getProperty("name")));
        entity.setLastName(String.valueOf(context.getProperty("lastName")));
        entity.setSecondName(String.valueOf(context.getProperty("secondName")));
    }
}
