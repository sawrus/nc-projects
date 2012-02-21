package com.solutions.samples.mvc;

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
        groupController.handleEvent(GroupEvent.FILL);

        studentController.context.setProperty("group", group);
        studentController.context.setProperty("startLearn", new Date());
        studentController.handleEvent(StudentEvent.FILL);

        groupController.context.setProperty("student", student);
        groupController.handleEvent(GroupEvent.ADD_STUDENT);

        studentController.handleEvent(StudentEvent.SHOW);
        groupController.handleEvent(GroupEvent.SHOW);
    }
}
