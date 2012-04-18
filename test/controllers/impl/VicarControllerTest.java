package com.solutions.controllers.impl;

import com.solutions.entities.impl.Depart;
import com.solutions.entities.impl.Vicar;
import com.solutions.events.impl.VicarEvent;
import com.solutions.models.impl.VicarModel;
import com.solutions.views.IRead;
import com.solutions.views.impl.VicarConsoleView;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertSame;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

public class VicarControllerTest {

    private VicarConsoleView classUnderTest;
    private IRead mock;

    Depart B = new Depart("F", "John");
    Vicar A = new Vicar("John", B, "Will", "Smith", "88002000600", 15000);


    VicarController vicarController = new VicarController();
    VicarModel vicarModel = new VicarModel(A);

    @Before
    public void setUp() throws Exception {
        System.out.println("VicarController Test started");

        mock = createMock(IRead.class);
        classUnderTest = new VicarConsoleView();
        classUnderTest.SetIRead(mock);
        vicarController.setModel(vicarModel);
        vicarController.setView(classUnderTest);

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("VicarController Test finished");

    }

    @Test
    public void testHandleEvent() throws Exception {

        // test clear()
        vicarController.handleEvent(VicarEvent.CLEAR);
        assertSame(vicarModel.getEntity().getName(), "");
        assertSame(vicarModel.getEntity().getDepart(), null);
        assertSame(vicarModel.getEntity().getSecondName(), "");
        assertSame(vicarModel.getEntity().getLastName(), "");
        assertSame(vicarModel.getEntity().getPhone(), "");
        assertSame(vicarModel.getEntity().getSalary(), 0);
        EasyMock.reset(mock);

        //test fill()
        expect(mock.readParameter("Vicar name")).andReturn("a");
        expect(mock.readParameter("Vicar secondName")).andReturn("b");
        expect(mock.readParameter("Vicar lastName")).andReturn("c");
        expect(mock.readParameter("Depart")).andReturn("second depart");
        expect(mock.readParameter("Vicar phone")).andReturn("1");
        expect(mock.readParameter("Vicar salary")).andReturn("2");
        EasyMock.replay(mock);
        vicarController.handleEvent(VicarEvent.FILL);
        EasyMock.verify(mock);
        assertSame(vicarModel.getEntity().getName(), "a");
        assertSame(vicarModel.getEntity().getDepart().getName(), "second depart");
        assertSame(vicarModel.getEntity().getSecondName(), "b");
        assertSame(vicarModel.getEntity().getLastName(), "c");
        assertSame(vicarModel.getEntity().getPhone(), "1");
        assertSame(vicarModel.getEntity().getSalary(), 2);

        //test show()
        EasyMock.reset(mock);
        vicarController.handleEvent(VicarEvent.SHOW);

        //test redact()
        EasyMock.reset(mock);
        expect(mock.readParameter("?")).andReturn("1");
        expect(mock.readParameter("Vicar name")).andReturn("Adam");
        expect(mock.readParameter("?")).andReturn("2");
        expect(mock.readParameter("Vicar secondName")).andReturn("Adams");
        expect(mock.readParameter("?")).andReturn("3");
        expect(mock.readParameter("Vicar lastName")).andReturn("Adamson");
        expect(mock.readParameter("?")).andReturn("4");
        expect(mock.readParameter("Vicar phone")).andReturn("3");
        expect(mock.readParameter("?")).andReturn("5");
        expect(mock.readParameter("Depart title")).andReturn("third depart");
        expect(mock.readParameter("?")).andReturn("6");
        expect(mock.readParameter("Vicar salary")).andReturn("4");
        expect(mock.readParameter("?")).andReturn("7");
        EasyMock.replay(mock);
        vicarController.handleEvent(VicarEvent.REDACT);
        EasyMock.verify(mock);
        assertSame(vicarModel.getEntity().getName(), "Adam");
        assertSame(vicarController.context.getProperty("depart"), "third depart");
        assertSame(vicarModel.getEntity().getSecondName(), "Adams");
        assertSame(vicarModel.getEntity().getLastName(), "Adamson");
        assertSame(vicarModel.getEntity().getPhone(), "3");
        assertSame(vicarModel.getEntity().getSalary(), 4);

    }
}
