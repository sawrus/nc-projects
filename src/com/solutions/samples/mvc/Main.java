package com.solutions.samples.mvc;

import com.solutions.samples.mvc.context.Context;
import com.solutions.samples.mvc.controllers.impl.GroupController;
import com.solutions.samples.mvc.controllers.impl.StudentController;
import com.solutions.samples.mvc.entities.impl.Group;
import com.solutions.samples.mvc.entities.impl.Student;
import com.solutions.samples.mvc.events.impl.GroupEvent;
import com.solutions.samples.mvc.events.impl.StudentEvent;
import com.solutions.samples.mvc.models.impl.GroupModel;
import com.solutions.samples.mvc.models.impl.StudentModel;
import com.solutions.samples.mvc.views.impl.GroupConsoleView;
import com.solutions.samples.mvc.views.impl.StudentConsoleView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] arguments)
    {
        Student student = new Student();
        Group<Student> group = new Group<Student>();

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

        final Context CONTEXT = new Context() {
            private final Map<String, Object> properties = new HashMap<String, Object>();

            public void setProperty(String name, Object value) {
                properties.put(name, value);
            }

            public Object getProperty(String name) {
                return properties.get(name);
            }
        };

        CONTEXT.setProperty("name", "TGU");
        CONTEXT.setProperty("number", 501);
        GroupEvent FILL_GROUP = GroupEvent.FILL;
        FILL_GROUP.setContext(CONTEXT);
        groupController.handleEvent(FILL_GROUP);

        CONTEXT.setProperty("name","Evgeny");
        CONTEXT.setProperty("secondName", "Isaev");
        CONTEXT.setProperty("lastName", "Alex");
        CONTEXT.setProperty("group", group);
        CONTEXT.setProperty("startLearn", new Date());
        StudentEvent FILL_STUDENT = StudentEvent.FILL;
        FILL_STUDENT.setContext(CONTEXT);
        studentController.handleEvent(FILL_STUDENT);

        CONTEXT.setProperty("student", student);
        GroupEvent ADD_STUDENT = GroupEvent.ADD_STUDENT;
        ADD_STUDENT.setContext(CONTEXT);
        groupController.handleEvent(ADD_STUDENT);

        studentController.handleEvent(StudentEvent.SHOW);
        groupController.handleEvent(GroupEvent.SHOW);
    }
}
