package com.games.time.main;

import com.games.engine.context.IContext;
import com.games.engine.context.impl.Context;
import com.games.engine.factories.impl.MVCFactory;
import com.games.time.controllers.impl.TimeController;
import com.games.time.events.TimeEvent;

public class Main {
    public static void main(String[] args){
        IContext context = new Context();

        TimeController timeController = MVCFactory.MVC_FACTORY.getControllerByClass(TimeController.class, context);
        timeController.handleEvent(TimeEvent.MOVE);
        timeController.handleEvent(TimeEvent.BUY);
        timeController.handleEvent(TimeEvent.SHARE);
        timeController.handleEvent(TimeEvent.MAKE);
        timeController.handleEvent(TimeEvent.ASK);
    }
}
