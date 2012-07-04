package com.games.time.models.impl;

import com.games.engine.context.IContext;
import com.games.engine.models.impl.AbstractModel;
import com.games.time.TimeConstants;
import com.games.time.events.TimeEvent;

public class TimeModel extends AbstractModel{
    private Long time = 86400000L;//24hour
    private Integer x = 0;
    private Integer y = 0;
    private Integer d = 1;//max=3D
    
    private static final Integer DX = 10;
    private static final Integer DY = 10;

    private static final Integer PRICE_LENGTH = 20;
    private static final Integer PRICE_TIME = 2000;

    private static final Integer MOVE_LENGTH = 20;
    private static final Integer MOVE_PRICE = 2000;


    public TimeModel(IContext context) {
        super(context);
    }

    @Override
    public void update() {
        if (context.containsKey(TimeConstants.EVENT)){
            switch ((TimeEvent)context.getProperty(TimeConstants.EVENT)){
                case BUY: buy(); break; 
                case MAKE: make(); break; 
                case ASK: ask(); break; 
                case SHARE: share(); break; 
                case MOVE: move(); break;
            }
        }

        if (context.containsKey(TimeConstants.DEFINITION)){
            d = context.getProperty(TimeConstants.DEFINITION);
        }

        setState();
    }

    private void setState() {
        context.put(TimeConstants.TIME, time);
        context.put(TimeConstants.DEFINITION, d);
        context.put(TimeConstants.X, x);
        context.put(TimeConstants.Y, y);
    }

    private void buy(){
        if (existTime()){
            increaseTIme();
            x -= DX;
        }
    }

    private void make(){
        if (existTime()){
            increaseTIme();
            x += DX;
        }
    }

    private void ask(){
        if (existTime()){
            increaseTIme();
            y -= DY;
        }
    }

    private void share(){
        if (existTime()){
            decreaseTime();
            y += DY;
        }
    }

    private void move(){
        if (existTime()){
            Long moveTime = context.getProperty(TimeConstants.TIME);
            int countMove = (int) (moveTime / MOVE_PRICE);

            if (context.containsKey(TimeConstants.DIRECTION)){
                switch ((TimeConstants.Direction)context.getProperty(TimeConstants.DIRECTION)){
                    case LEFT: x -= MOVE_LENGTH * countMove; break;
                    case RIGHT: x += MOVE_LENGTH * countMove; break;
                    case TOP: y += MOVE_LENGTH * countMove; break;
                    case DOWN: y -= MOVE_LENGTH * countMove; break;
                }
            }
        }
    }


    private void decreaseTime() {
        checkAtPrice();
        time -= (Long)context.getProperty(TimeConstants.TIME);
    }

    private void increaseTIme() {
        checkAtPrice();
        time += (Long)context.getProperty(TimeConstants.TIME);
    }

    private boolean existTime() {
        return context.containsKey(TimeConstants.TIME);
    }

    private void checkAtPrice(){
         if (x % PRICE_LENGTH == 0 || y % PRICE_LENGTH == 0) time += PRICE_TIME;
    }
}
