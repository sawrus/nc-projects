package com.games.time.controllers.impl;

import com.games.engine.context.IContext;
import com.games.engine.controllers.impl.AbstractController;
import com.games.engine.events.IEventHandler;
import com.games.time.TimeConstants;
import com.games.time.events.TimeEvent;
import com.games.time.models.impl.TimeModel;
import com.games.time.views.impl.TimeView;

public class TimeController extends AbstractController<TimeModel, TimeView, TimeEvent>{
    public TimeController(TimeModel timeModel, TimeView timeView, IContext context) {
        super(timeModel, timeView, context);
        model.update();
    }

    {
        eventHandlerMap.put(TimeEvent.BUY, new IEventHandler() {
            @Override
            public void handle() {
                context.put(TimeConstants.EVENT, TimeEvent.BUY);
                readAndWriteState();
                model.update();
            }
        });

        eventHandlerMap.put(TimeEvent.MAKE, new IEventHandler() {
            @Override
            public void handle() {
                context.put(TimeConstants.EVENT, TimeEvent.MAKE);
                readAndWriteState();
                model.update();
            }
        });


        eventHandlerMap.put(TimeEvent.SHARE, new IEventHandler() {
            @Override
            public void handle() {
                context.put(TimeConstants.EVENT, TimeEvent.SHARE);
                readAndWriteState();
                model.update();
            }
        });


        eventHandlerMap.put(TimeEvent.ASK, new IEventHandler() {
            @Override
            public void handle() {
                context.put(TimeConstants.EVENT, TimeEvent.ASK);
                readAndWriteState();
                model.update();
            }
        });

        eventHandlerMap.put(TimeEvent.MOVE, new IEventHandler() {
            @Override
            public void handle() {
                context.put(TimeConstants.EVENT, TimeEvent.MOVE);
                context.put(TimeConstants.DIRECTION, TimeConstants.DIRECTION);
                readAndWriteState();
                model.update();
            }
        });
    }

    private void readState() {
        context.put(TimeConstants.VIEW_MODE,TimeConstants.ViewMode.R);
        view.update();
    }

    private void writeState() {
        context.put(TimeConstants.VIEW_MODE,TimeConstants.ViewMode.W);
        view.update();
    }

    private void readAndWriteState(){
        readState();
        writeState();
    }
}
