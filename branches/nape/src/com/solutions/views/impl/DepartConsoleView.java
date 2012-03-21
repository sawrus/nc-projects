package com.solutions.mvc.views.impl;

import com.solutions.mvc.entities.impl.Vicar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DepartConsoleView extends ConsoleView {
    public void fill() throws IOException {
        context.setProperty("name", readParameter("Depart name"));
        context.setProperty("chief",readParameter("Chief of Depart"));
    }

public int redact() throws IOException {

       BufferedReader bReaderM = new BufferedReader(new InputStreamReader(System.in));
        int l=0;
        while (true) {
            System.out.println("What you want?");
            System.out.println("1) name");
            System.out.println("2) chief");
            System.out.println("3) exit");
            l = 0;
            l = Integer.valueOf(bReaderM.readLine());
            if (l == 1) {
                context.setProperty("name", readParameter("Depart name"));
                break;
            }
            if (l == 2) {
                context.setProperty("chief", readParameter("Depart chief"));
                break;
            }
            if (l == 3) {
                break;
            }
        }
        return l;
    }

}