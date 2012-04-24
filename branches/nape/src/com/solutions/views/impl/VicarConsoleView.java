package com.solutions.views.impl;

import java.io.IOException;

public class VicarConsoleView extends ConsoleView {
    public void fill() throws IOException {
        context.setProperty("name", iread.readParameter("Vicar name"));
        context.setProperty("secondName", iread.readParameter("Vicar secondName"));
        context.setProperty("lastName", iread.readParameter("Vicar lastName"));
        context.setProperty("depart", iread.readParameter("Depart"));
        context.setProperty("phone", iread.readParameter("Vicar phone"));
        boolean y = false;
        while (!y) {
            try {
                context.setProperty("salary", new Integer(iread.readParameter("Vicar salary")));
                y = true;
            } catch (NumberFormatException e) {
                System.out.println("You write not number");
            }
        }
    }

    public void redact() throws IOException {

        String Y;
        int l = 0;
        while (true) {
            System.out.println("What you want?");
            System.out.println("1) name");
            System.out.println("2) second name");
            System.out.println("3) last name");
            System.out.println("4) phone");
            System.out.println("5) depart");
            System.out.println("6) salary");
            System.out.println("7) exit");
            l = 0;
            Y = iread.readParameter("?");
            l = Integer.valueOf(Y);
            if (l == 1) {
                context.setProperty("name", iread.readParameter("Vicar name"));
                continue;
            }
            if (l == 2) {
                context.setProperty("secondName", iread.readParameter("Vicar secondName"));
                continue;
            }
            if (l == 3) {
                context.setProperty("lastName", iread.readParameter("Vicar lastName"));
                continue;
            }
            if (l == 4) {
                context.setProperty("phone", iread.readParameter("Vicar phone"));
                continue;
            }
            if (l == 5) {
                context.setProperty("depart", iread.readParameter("Depart title"));
                continue;
            }
            if (l == 6) {
                boolean y = false;
                while (!y) {
                    try {
                        context.setProperty("salary", new Integer(iread.readParameter("Vicar salary")));
                        y = true;
                    } catch (NumberFormatException e) {
                        System.out.println("You write not number");
                    }
                }
                continue;
            }
            if (l == 7) {
                break;
            }
        }
    }
}