package com.games.engine.factories.impl;

import com.games.engine.context.IContext;
import com.games.engine.controllers.IController;
import com.games.engine.factories.IFactory;

import java.lang.reflect.Constructor;

public enum MVCFactory implements IFactory{
    MVC_FACTORY;

    public <TController extends IController> TController getControllerByClass(Class<TController> controllerClass, IContext context)
    {
        for (Constructor constructor : controllerClass.getConstructors()){
            constructor.setAccessible(true);
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes != null && parameterTypes.length == 3){
                return getController(controllerClass, parameterTypes, context);
            }
        }

        throw new IllegalArgumentException();
    }

    private <TController extends IController> TController getController(Class<TController> controllerClass,
                                                                        Class[] modelAndView,
                                                                        IContext context)
    {
        try {
            Class modelClass = modelAndView[0];
            Constructor modelConstructor = modelClass.getConstructor(IContext.class);
            modelConstructor.setAccessible(true);
            Object model = modelConstructor.newInstance(context);

            Class viewClass = modelAndView[1];
            Constructor viewConstructor = viewClass.getConstructor(IContext.class);
            viewConstructor.setAccessible(true);
            Object view = viewConstructor.newInstance(context);

            Constructor<TController> controllerConstructor = controllerClass.getConstructor(model.getClass(),
                    view.getClass(),
                    IContext.class
            );

            controllerConstructor.setAccessible(true);
            return controllerConstructor.newInstance(model, view, context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
