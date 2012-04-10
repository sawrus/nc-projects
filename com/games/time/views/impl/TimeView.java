package com.games.time.views.impl;

import com.games.engine.context.IContext;
import com.games.engine.views.impl.AbstractView;
import com.games.time.TimeConstants;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TimeView extends AbstractView{
    public TimeView(IContext context) {
        super(context);
    }

    @Override
    public void update() {
        if (context.containsKey(TimeConstants.VIEW_MODE)){
            TimeConstants.ViewMode viewMode = context.getProperty(TimeConstants.VIEW_MODE);
            switch (viewMode){
                case R: read(); break;
                case W: write(); break;
                case RW: readAndWrite(); break;
            }

        }
    }

    private void read() {
        System.out.println(TimeConstants.TIME.toString() + "=" + context.getProperty(TimeConstants.TIME));
        System.out.println(TimeConstants.DEFINITION.toString() + "=" + context.getProperty(TimeConstants.DEFINITION));
        System.out.println(TimeConstants.X.toString() + "=" + context.getProperty(TimeConstants.X));
        System.out.println(TimeConstants.Y.toString() + "=" + context.getProperty(TimeConstants.Y));
        printLength();
    }

    private void printLength(){
        Integer x = Math.abs((Integer)context.getProperty(TimeConstants.X));
        Integer y = Math.abs((Integer) context.getProperty(TimeConstants.X));
        double length = Math.sqrt(x * x + y * y);
        System.out.println("length="+length);
    }

    private void write() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("#");
        if (context.containsKey(TimeConstants.EVENT)){
            System.out.println("event="+context.getProperty(TimeConstants.EVENT));
        }
        try {
            System.out.print(TimeConstants.TIME.toString()+"=");
            Long time = new Long(bufferedReader.readLine());
            context.put(TimeConstants.TIME, time);

            System.out.print(TimeConstants.DEFINITION.toString()+"=");
            Integer definition = new Integer(bufferedReader.readLine());
            context.put(TimeConstants.DEFINITION, definition);

            if (context.containsKey(TimeConstants.DIRECTION)){
                System.out.println("direction:");
                for (TimeConstants.Direction direction: TimeConstants.Direction.values()){
                    System.out.println(direction);
                }
                System.out.print(TimeConstants.DIRECTION.toString()+"=");
                TimeConstants.Direction direction = TimeConstants.Direction.valueOf(bufferedReader.readLine());
                context.put(TimeConstants.DIRECTION, direction);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void readAndWrite() {
        read();
        write();
    }
}
