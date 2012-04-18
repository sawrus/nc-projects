package com.solutions.controllers.impl;

import com.solutions.entities.impl.Depart;
import com.solutions.events.impl.DepartEvent;
import com.solutions.models.impl.DepartModel;
import com.solutions.views.IRead;
import com.solutions.views.impl.DepartConsoleView;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertSame;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

/**
 * Created by IntelliJ IDEA.
 * User: Chaotickgood
 * Date: 18.04.12
 * Time: 19:07
 * To change this template use File | Settings | File Templates.
 */
public class DepartControllerTest {

    private DepartConsoleView departConsoleView;
    private IRead mock;

    Depart B = new Depart("F", "John");

    DepartController departController = new DepartController();
    DepartModel departModel = new DepartModel(B);


    @Before
    public void setUp() throws Exception {
        System.out.println("VicarController Test started");

        mock = createMock(IRead.class);
        departConsoleView = new DepartConsoleView();
        departConsoleView.SetIRead(mock);
        departController.setModel(departModel);
        departController.setView(departConsoleView);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("DepartController Test finished");
    }

    @Test
    public void testHandleEvent() throws Exception {

        // test clear()
        departController.handleEvent(DepartEvent.CLEAR);
        assertSame(departModel.getEntity().getName(), "");
        assertSame(departModel.getEntity().getChief(), null);
        EasyMock.reset(mock);
        //test fill()
        expect(mock.readParameter("Depart name")).andReturn("First depart");
        expect(mock.readParameter("Chief of Depart")).andReturn("Sepius I");
        EasyMock.replay(mock);
        departController.handleEvent(DepartEvent.FILL);
        EasyMock.verify(mock);
        assertSame(departModel.getEntity().getName(), "First depart");
        assertSame(departModel.getEntity().getChief(), "Sepius I");
        //test show()
        EasyMock.reset(mock);
        departController.handleEvent(DepartEvent.SHOW);
        //test redact()
        EasyMock.reset(mock);
        expect(mock.readParameter("?")).andReturn("1");
        expect(mock.readParameter("Depart name")).andReturn("Second depart");
        expect(mock.readParameter("?")).andReturn("2");
        expect(mock.readParameter("Depart chief")).andReturn("Adams");
        expect(mock.readParameter("?")).andReturn("3");
        EasyMock.replay(mock);
        departController.handleEvent(DepartEvent.REDACT);
        EasyMock.verify(mock);
        assertSame(departModel.getEntity().getName(), "Second depart");
        assertSame(departModel.getEntity().getChief(), "Adams");

    }
}
