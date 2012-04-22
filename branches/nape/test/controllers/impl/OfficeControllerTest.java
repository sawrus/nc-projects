package com.solutions.controllers.impl;

import com.solutions.entities.impl.Agency;
import com.solutions.entities.impl.Office;
import com.solutions.events.impl.OfficeEvent;
import com.solutions.models.impl.AgencyModel;
import com.solutions.models.impl.OfficeModel;
import com.solutions.views.IRead;
import com.solutions.views.impl.OfficeConsoleView;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertSame;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

public class OfficeControllerTest {

    private OfficeConsoleView officeConsoleView;
    private IRead mock;

    Office X = new Office();
    Agency Y = new Agency();

    OfficeController officeController = new OfficeController();
    AgencyModel agencyModel = new AgencyModel(Y);
    OfficeModel officeModel = new OfficeModel(X, agencyModel);

    @Before
    public void setUp() throws Exception {
        System.out.println("OfficeController Test started");

        mock = createMock(IRead.class);
        officeConsoleView = new OfficeConsoleView();
        officeConsoleView.SetIRead(mock);
        officeController.setModel(officeModel);
        officeController.setView(officeConsoleView);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("OfficeController Test finished");
    }

    @Test
    public void testHandleEvent() throws Exception {

        // test clear()
        officeController.handleEvent(OfficeEvent.CLEAR);
        assertSame(officeModel.getEntity().getName(), "");
        assertSame(officeModel.getEntity().Values().size(), 0);
        EasyMock.reset(mock);
        System.out.println("2");

        //test fill()
        expect(mock.readParameter("Vicar name")).andReturn("a");
        expect(mock.readParameter("Vicar secondName")).andReturn("b");
        expect(mock.readParameter("Vicar lastName")).andReturn("c");
        expect(mock.readParameter("Depart")).andReturn("second depart");
        expect(mock.readParameter("Vicar phone")).andReturn("1");
        expect(mock.readParameter("Vicar salary")).andReturn("2");
        EasyMock.replay(mock);
        officeController.handleEvent(OfficeEvent.FILL);
        EasyMock.verify(mock);
        assertSame(officeModel.getEntity().GetVicar("a").getName(), "a");
        assertSame(officeModel.getEntity().GetVicar("a").getDepart().getName(), "second depart");
        assertSame(officeModel.getEntity().GetVicar("a").getSecondName(), "b");
        assertSame(officeModel.getEntity().GetVicar("a").getLastName(), "c");
        assertSame(officeModel.getEntity().GetVicar("a").getPhone(), "1");
        assertSame(officeModel.getEntity().GetVicar("a").getSalary(), 2);

        //test show()
        EasyMock.reset(mock);
        System.out.println("1");
        expect(mock.readParameter("Vicar name")).andReturn("a");
        EasyMock.replay(mock);
        officeController.handleEvent(OfficeEvent.SHOW);
        EasyMock.verify(mock);

        //test redact()
        EasyMock.reset(mock);
        System.out.println("3");
        expect(mock.readParameter("Vicar name")).andReturn("a");
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
        officeController.handleEvent(OfficeEvent.REDACT);
        EasyMock.verify(mock);
        assertSame(officeModel.getEntity().GetVicar("Adam").getName(), "Adam");
        assertSame(officeModel.getEntity().GetVicar("Adam").getDepart().getName(), "third depart");
        assertSame(officeModel.getEntity().GetVicar("Adam").getSecondName(), "Adams");
        assertSame(officeModel.getEntity().GetVicar("Adam").getLastName(), "Adamson");
        assertSame(officeModel.getEntity().GetVicar("Adam").getPhone(), "3");
        assertSame(officeModel.getEntity().GetVicar("Adam").getSalary(), 4);
        
         //test delete()
        EasyMock.reset(mock);
        expect(mock.readParameter("Vicar name")).andReturn("Adam");
        EasyMock.replay(mock);
        officeController.handleEvent(OfficeEvent.DELETE);
        EasyMock.verify(mock);
        assertSame(officeModel.getEntity().GetVicar("Adam"), null);
    }
}
