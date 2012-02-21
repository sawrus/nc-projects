package com.solutions.samples.mvc.models.impl;

import com.solutions.samples.mvc.context.IContext;
import com.solutions.samples.mvc.entities.impl.Group;
import com.solutions.samples.mvc.entities.impl.Student;
import com.solutions.samples.mvc.models.AbstractModel;

import java.util.Date;

public class StudentModel extends AbstractModel<Student> {
    public void fillPrimaryInformation(IContext context){
        entity.setGroup((Group) context.getProperty("group"));
        entity.setStartLearn((Date) context.getProperty("startLearn"));
    }

    public void fillSecondaryInformation(IContext context){
        entity.setName(String.valueOf(context.getProperty("name")));
        entity.setLastName(String.valueOf(context.getProperty("lastName")));
        entity.setSecondName(String.valueOf(context.getProperty("secondName")));
    }
}
