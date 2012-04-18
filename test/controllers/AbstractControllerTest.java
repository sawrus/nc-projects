package com.solutions.controllers;

import com.solutions.entities.impl.Agency;
import com.solutions.entities.impl.Depart;
import com.solutions.entities.impl.Office;
import com.solutions.entities.impl.Vicar;
import com.solutions.events.Event;
import com.solutions.models.IModel;
import com.solutions.models.impl.AgencyModel;
import com.solutions.models.impl.DepartModel;
import com.solutions.models.impl.OfficeModel;
import com.solutions.models.impl.VicarModel;
import com.solutions.views.IView;
import com.solutions.views.impl.AgencyConsoleView;
import com.solutions.views.impl.DepartConsoleView;
import com.solutions.views.impl.OfficeConsoleView;
import com.solutions.views.impl.VicarConsoleView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class AbstractControllerTest {

    class ConcreteController<TModel extends IModel, TView extends IView> extends AbstractController<TModel, TView> {
        public TModel getModel() {
            return this.model;
        }

        public TView getView() {
            return this.view;
        }

        public void handleEvent(Event event) {
           //empty method
        }
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("AbstractController Test started");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("AbstractController Test finished");
    }

    @Test
    public void testSetModel() throws Exception {
        Agency a = new Agency();
        AgencyModel A = new AgencyModel(a);
        Depart b = new Depart();
        DepartModel B = new DepartModel(b);
        Office c = new Office();
        OfficeModel C = new OfficeModel(c);
        Vicar d = new Vicar();
        VicarModel D = new VicarModel(d);
        ConcreteController concreteController = new ConcreteController();
        concreteController.setModel(A);
        assertSame(concreteController.getModel(), A);
        concreteController.setModel(B);
        assertSame(concreteController.getModel(), B);
        concreteController.setModel(C);
        assertSame(concreteController.getModel(), C);
        concreteController.setModel(D);
        assertSame(concreteController.getModel(), D);

    }

    @Test
    public void testSetView() throws Exception {
        Agency a = new Agency();
        AgencyConsoleView A = new AgencyConsoleView();
        Depart b = new Depart();
        DepartConsoleView B = new DepartConsoleView();
        Office c = new Office();
        OfficeConsoleView C = new OfficeConsoleView();
        Vicar d = new Vicar();
        VicarConsoleView D = new VicarConsoleView();
        ConcreteController concreteController = new ConcreteController();
        concreteController.setView(A);
        assertSame(concreteController.getView(), A);
        concreteController.setView(B);
        assertSame(concreteController.getView(), B);
        concreteController.setView(C);
        assertSame(concreteController.getView(), C);
        concreteController.setView(D);
        assertSame(concreteController.getView(), D);
    }
}
