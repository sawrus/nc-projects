package com.solutions.views.impl;

import java.io.IOException;

public class DepartConsoleView extends ConsoleView {
    public void fill() throws IOException {
        context.setProperty("name", iread.readParameter("Depart name"));
        context.setProperty("chief", iread.readParameter("Chief of Depart"));
    }

    public void redact() throws IOException {

        String Y;
        int l = 0;
        while (true) {
            System.out.println("What you want?");
            System.out.println("1) name");
            System.out.println("2) chief");
            System.out.println("3) exit");
            l = 0;
            Y = iread.readParameter("?");
            l = Integer.valueOf(Y);
            if (l == 1) {
                context.setProperty("name", iread.readParameter("Depart name"));
                continue;
            }
            if (l == 2) {
                context.setProperty("chief", iread.readParameter("Depart chief"));
                continue;
            }
            if (l == 3) {
                break;
            }
        }
    }

}