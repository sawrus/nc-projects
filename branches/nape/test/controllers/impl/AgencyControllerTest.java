package com.solutions.controllers.impl;

import com.solutions.controllers.impl.AgencyController;
import com.solutions.entities.impl.Agency;
import com.solutions.events.impl.AgencyEvent;
import com.solutions.models.impl.AgencyModel;
import com.solutions.views.IRead;
import com.solutions.views.impl.AgencyConsoleView;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertSame;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

public class AgencyControllerTest {

    private AgencyConsoleView agencyConsoleView;
    private IRead mock;

    Agency Y = new Agency();

    AgencyController agencyController = new AgencyController();
    AgencyModel agencyModel = new AgencyModel(Y);

    @Before
    public void setUp() throws Exception {
        System.out.println("OfficeController Test started");

        mock = createMock(IRead.class);
        agencyConsoleView = new AgencyConsoleView();
        agencyConsoleView.SetIRead(mock);
        agencyController.setModel(agencyModel);
        agencyController.setView(agencyConsoleView);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("AgencyController Test finished");
    }

    @Test
    public void testHandleEvent() throws Exception {

        //test clear()
        agencyController.handleEvent(AgencyEvent.CLEAR);
        assertSame(agencyModel.getEntity().getName(), "");
        assertSame(agencyModel.getEntity().Values().size(), 0);
        EasyMock.reset(mock);
        System.out.println("2");

        //test fill()
        expect(mock.readParameter("Depart name")).andReturn("First depart");
        expect(mock.readParameter("Chief of Depart")).andReturn("Sepius I");
        EasyMock.replay(mock);
        agencyController.handleEvent(AgencyEvent.FILL);
        EasyMock.verify(mock);
        assertSame(agencyModel.getEntity().GetDepart("First depart").getName(), "First depart");
        assertSame(agencyModel.getEntity().GetDepart("First depart").getChief(), "Sepius I");

        //test show()
        EasyMock.reset(mock);
        System.out.println("1");
        expect(mock.readParameter("Depart title")).andReturn("First depart");
        EasyMock.replay(mock);
        agencyController.handleEvent(AgencyEvent.SHOW);
        EasyMock.verify(mock);

        //test redact()
        EasyMock.reset(mock);
        System.out.println("3");
        expect(mock.readParameter("Depart title")).andReturn("First depart");
        expect(mock.readParameter("?")).andReturn("1");
        expect(mock.readParameter("Depart name")).andReturn("Second depart");
        expect(mock.readParameter("?")).andReturn("2");
        expect(mock.readParameter("Depart chief")).andReturn("Adams");
        expect(mock.readParameter("?")).andReturn("3");
        EasyMock.replay(mock);
        agencyController.handleEvent(AgencyEvent.REDACT);
        EasyMock.verify(mock);
        assertSame(agencyModel.getEntity().GetDepart("Second depart").getName(), "Second depart");
        assertSame(agencyModel.getEntity().GetDepart("Second depart").getChief(), "Adams");
        
        //test delete()
        EasyMock.reset(mock);
        expect(mock.readParameter("Depart title")).andReturn("Second depart");
        EasyMock.replay(mock);
        agencyController.handleEvent(AgencyEvent.DELETE);
        EasyMock.verify(mock);
        assertSame(agencyModel.getEntity().GetDepart("Second depart"), null);
    }
}
