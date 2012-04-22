package com.solutions.views.impl;

import com.solutions.entities.impl.Depart;
import com.solutions.views.IRead;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertSame;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;


public class AgencyConsoleViewTest {

    private AgencyConsoleView agencyConsoleView = new AgencyConsoleView();
    private IRead mock;

    @Before
    public void setUp() throws Exception {
        System.out.println("AgencyConsoleView started");
        mock = createMock(IRead.class);
        agencyConsoleView.SetIRead(mock);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("AgencyConsoleView finished");
    }

    @Test
    public void testFill() throws Exception {
        EasyMock.reset(mock);
        expect(mock.readParameter("Depart name")).andReturn("Second depart");
        expect(mock.readParameter("Chief of Depart")).andReturn("Adams");
        EasyMock.replay(mock);
        agencyConsoleView.fill();
        EasyMock.verify(mock);
        assertSame(((Depart) agencyConsoleView.context.getProperty("depart")).getName(), "Second depart");
        assertSame(((Depart) agencyConsoleView.context.getProperty("depart")).getChief(), "Adams");


    }

    @Test
    public void testShow() throws Exception {
       EasyMock.reset(mock);
       expect(mock.readParameter("Depart title")).andReturn("ShowDepart");
       EasyMock.replay(mock);
       agencyConsoleView.show();
       EasyMock.verify(mock);
       assertSame(agencyConsoleView.context.getProperty("title"),"ShowDepart");
    }

    @Test
    public void testRedact() throws Exception {
       EasyMock.reset(mock);
       expect(mock.readParameter("Depart title")).andReturn("ChangeDepart");
       EasyMock.replay(mock);
       agencyConsoleView.redact();
       EasyMock.verify(mock);
       assertSame(agencyConsoleView.context.getProperty("title"),"ChangeDepart");
    }

    @Test
    public void testSearch() throws Exception {
       EasyMock.reset(mock);
       expect(mock.readParameter("Title(s)?")).andReturn("F*rst ?");
       EasyMock.replay(mock);
       agencyConsoleView.search();
       EasyMock.verify(mock);
       assertSame(agencyConsoleView.context.getProperty("pattern"),"F*rst ?");
    }
    
    @Test
    public void testDelete() throws Exception {
        EasyMock.reset(mock);
        expect(mock.readParameter("Depart title")).andReturn("DeleteDepart");
        EasyMock.replay(mock);
        agencyConsoleView.redact();
        EasyMock.verify(mock);
        assertSame(agencyConsoleView.context.getProperty("title"), "DeleteDepart");
    }
}
