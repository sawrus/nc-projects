import java.lang.*;
import java.beans.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

import Depart.*;
import Vicar.*;
import XMLSer.*;

public class VDView {

    public static void ShowVicar(Vicar N) {
        System.out.println("FIO: " + N.getFIO());
        try {
            System.out.println("Depart: " + N.getDepart_link().getTitle());
        } catch (NullPointerException e) {
            System.out.println("Not defined");
        }
        System.out.println("Phone: " + N.getPhone());
        System.out.println("Salary: " + N.getSalary());
    }

    public static void ShowDepart(Depart N) {
        System.out.println("Title: " + N.getTitle());
        System.out.println("Chief: " + N.getChief());
    }

    public static void Menu(int number) {
        if (number == 0) {
            System.out.println("What you want?");
            System.out.println("1) Redact some vicar");
            System.out.println("2) Redact some depart");
            System.out.println("3) Show information about vicars");
            System.out.println("4) Show information about departs");
            System.out.println("5) Exit");
        }
        if (number == 1) {
            System.out.println("What you want?");
            System.out.println("1) FIO");
            System.out.println("2) Phone");
            System.out.println("3) Depart");
            System.out.println("4) Exit");
        }
        if (number == 2) {
            System.out.println("What you want?");
            System.out.println("1) Title");
            System.out.println("2) Phone");
            System.out.println("3) Exit");
        }
        if (number == 3) {
            System.out.println("What title?");
        }
        if (number == 4) {
            System.out.println("Sorry, such departament being yet\n");
        }
        if (number == 5) {
            System.out.println("What FIO?");
        }
        if (number == 6) {
            System.out.println("Sorry, such vicar being yet\n");
        }
        if (number == -1) {
            System.out.println("INPUT ERROR");
        }
    }

    public static void ShowRedactDepart(int n) {
        if (n == 0) {
            System.out.println("What you want?");
            System.out.println("1) append new depart");
            System.out.println("2) modify old depart");
            System.out.println("3) delete depart");
            System.out.println("4) show depart");
            System.out.println("5) exit");
        }
        if (n == 1) {
            System.out.println("What title do you want?");
        }
        if (n == 2) {
            System.out.println("What chief do you want?");
        }
    }


    public static void ShowRedactVicar(int n) {
        if (n == 0) {
            System.out.println("What you want?");
            System.out.println("1) append new vicar");
            System.out.println("2) modify old vicar");
            System.out.println("3) delete vicar");
            System.out.println("4) show vicar");
            System.out.println("5) exit");
        }
        if (n == 1) {
            System.out.println("What FIO do you want?");
        }
        if (n == 2) {
            System.out.println("What phone do you want?");
        }

        if (n == 3) {
            System.out.println("What salary do you want?");
        }
        if (n == 4) {
            System.out.println("What depart do you want?");
        }
    }

    public static void ShowModifyDepart(int n) {
        if (n == 0) {
            System.out.println("What are you want modificate?");
            System.out.println("1) Title");
            System.out.println("2) Chief");
            System.out.println("3) None");
        }
        if (n == 1) {
            System.out.println("What title do you want?");
        }
        if (n == 2) {
            System.out.println("What chief do you want?");
        }
    }

    public static void ShowModifyVicar(int n) {
        if (n == 0) {
            System.out.println("What are you want modificate?");
            System.out.println("1) FIO");
            System.out.println("2) Phone");
            System.out.println("3) Sslary");
            System.out.println("4) Depart");
            System.out.println("5) None");
        }
        if (n == 1) {
            System.out.println("What FIO do you want?");
        }
        if (n == 2) {
            System.out.println("What phone do you want?");
        }
        if (n == 3) {
            System.out.println("What salary do you want?");
        }
        if (n == 4) {
            System.out.println("What depart do you want?");
        }

    }
}