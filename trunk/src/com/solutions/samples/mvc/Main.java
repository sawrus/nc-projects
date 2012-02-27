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

public class Main {
    public static void main(String[] arguments) {
        //entities
        Student student = new Student();
        Group<Student> group = new Group<Student>();

        //models
        GroupModel groupModel = new GroupModel(group);
        StudentModel studentModel = new StudentModel(student, groupModel);

        //views
        StudentConsoleView studentConsoleView = new StudentConsoleView();
        GroupConsoleView groupConsoleView = new GroupConsoleView();

        //controllers
        {
            StudentController studentController = new StudentController();
            studentController.setModel(studentModel);
            studentController.setView(studentConsoleView);

            GroupController groupController = new GroupController();
            groupController.setModel(groupModel);
            groupController.setView(groupConsoleView);

            //handle events and internal manage slave objects type of { 'Model', 'View' }
            {
                studentController.handleEvent(StudentEvent.FILL);
                groupController.handleEvent(GroupEvent.FILL);

                studentController.handleEvent(StudentEvent.SHOW);
                groupController.handleEvent(GroupEvent.SHOW);
            }
        }
    }
}
