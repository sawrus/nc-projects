package com.solutions.views;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Chaotickgood
 * Date: 15.04.12
 * Time: 23:42
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleRead implements IRead {

    protected final DataInputStream input = new DataInputStream(System.in);

    public String readParameter(String name) throws IOException {
        System.out.print(name + "=");
        //return name;
        return input.readLine();
    }
}
