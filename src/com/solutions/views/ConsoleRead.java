package com.solutions.views;

import java.io.DataInputStream;
import java.io.IOException;

public class ConsoleRead implements IRead {

    protected final DataInputStream input = new DataInputStream(System.in);

    public String readParameter(String name) throws IOException {
        System.out.print(name + "=");
        return input.readLine();
    }
}
