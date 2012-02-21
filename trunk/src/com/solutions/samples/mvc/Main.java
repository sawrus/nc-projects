package com.solutions.samples.mvc;

import com.solutions.samples.mvc.context.Context;
import com.solutions.samples.mvc.controllers.impl.GroupController;
import com.solutions.samples.mvc.controllers.impl.StudentController;
import com.solutions.samples.mvc.entities.impl.Group;
import com.solutions.samples.mvc.entities.impl.Student;
import com.solutions.samples.mvc.events.impl.StudentEvent;
import com.solutions.samples.mvc.models.impl.GroupModel;
import com.solutions.samples.mvc.models.impl.StudentModel;
import com.solutions.samples.mvc.views.impl.GroupConsoleView;
import com.solutions.samples.mvc.views.impl.StudentConsoleView;
import com.sun.deploy.util.Property;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] arguments)
    {
        Student student = new Student();

        Group<Student> group = new Group<Student>();
        group.addStudent(student);

        StudentModel studentModel = new StudentModel();
        studentModel.setEntity(student);

        GroupModel groupModel = new GroupModel();
        groupModel.setEntity(group);

        StudentController studentController = new StudentController();
        GroupController groupController = new GroupController();

        StudentConsoleView studentConsoleView = new StudentConsoleView();
        studentConsoleView.setModel(studentModel);

        GroupConsoleView groupConsoleView = new GroupConsoleView();
        groupConsoleView.setModel(groupModel);

        studentController.setModel(studentModel);
        studentController.setView(studentConsoleView);

        groupController.setModel(groupModel);
        groupController.setView(groupConsoleView);

        studentController.handleEvent(StudentEvent.CLEAR);
        studentController.handleEvent(StudentEvent.SHOW);

        final Context FILL_CONTEXT = new Context() {
            private final Map<String, Property> properties = new HashMap<String, Property>();

            public void setProperty(Property property) {
                properties.put(property.getKey(), property);
            }

            public Property getProperty(String name) {
                return properties.get(name);
            }
        };
        FILL_CONTEXT.setProperty(new Property("name","name"));
        FILL_CONTEXT.setProperty(new Property("secondName","secondName"));
        FILL_CONTEXT.setProperty(new Property("lastName","lastName"));

        StudentEvent FILL_STUDENT = StudentEvent.FILL;
        FILL_STUDENT.setContext(FILL_CONTEXT);
        studentController.handleEvent(FILL_STUDENT);
        studentController.handleEvent(StudentEvent.SHOW);
    }
}
