package com.solutions.mvc.views.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VicarConsoleView extends ConsoleView {
    public void fill() throws IOException {
        context.setProperty("name", readParameter("Vicar name"));
        context.setProperty("secondName", readParameter("Vicar secondName"));
        context.setProperty("lastName", readParameter("Vicar lastName"));
        context.setProperty("depart",readParameter("Depart"));
		context.setProperty("phone", readParameter("Vicar phone"));
		context.setProperty("salary", new Integer(readParameter("Vicar salary")));
		
    }

    public void redact() throws IOException {

       BufferedReader bReaderM = new BufferedReader(new InputStreamReader(System.in));
        int l=0;
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
            l = Integer.valueOf(bReaderM.readLine());
            if (l == 1) {
                context.setProperty("name", readParameter("Vicar name"));
                continue;
            }
            if (l == 2) {
                context.setProperty("secondName", readParameter("Vicar secondName"));
                continue;
            }
            if (l == 3) {
                context.setProperty("lastName", readParameter("Vicar lastName"));
                continue;
            }
            if (l == 4) {
                context.setProperty("phone", readParameter("Vicar phone"));
                continue;
            }
            if (l == 5) {
                break;
            }
            if (l == 6) {
                context.setProperty("salary", new Integer(readParameter("Vicar salary")));
                continue;
            }
            if (l == 7) {
                break;
            }
        }
    }
}