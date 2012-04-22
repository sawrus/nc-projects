package com.solutions.views.impl;

import com.solutions.entities.impl.Depart;
import com.solutions.entities.impl.Vicar;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.solutions.views.IRead;

import static junit.framework.Assert.assertSame;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

public class OfficeConsoleViewTest {

    private OfficeConsoleView officeConsoleView = new OfficeConsoleView();
    private IRead mock;

    @Before
    public void setUp() throws Exception {
        System.out.println("OfficeConsoleView started");
        mock = createMock(IRead.class);
        officeConsoleView.SetIRead(mock);
    }

    @After
    public void tearDown() throws Exception {
       System.out.println("OfficeConsoleView finished");
    }

    @Test
    public void testFill() throws Exception {
        EasyMock.reset(mock);
        expect(mock.readParameter("Vicar name")).andReturn("a");
        expect(mock.readParameter("Vicar secondName")).andReturn("b");
        expect(mock.readParameter("Vicar lastName")).andReturn("c");
        expect(mock.readParameter("Depart")).andReturn("second depart");
        expect(mock.readParameter("Vicar phone")).andReturn("1");
        expect(mock.readParameter("Vicar salary")).andReturn("2");
        EasyMock.replay(mock);
        officeConsoleView.fill();
        EasyMock.verify(mock);
        assertSame(((Vicar) officeConsoleView.context.getProperty("vicar")).getName(), "a");
        assertSame(((Vicar) officeConsoleView.context.getProperty("vicar")).getSecondName(), "b");
        assertSame(((Vicar) officeConsoleView.context.getProperty("vicar")).getLastName(), "c");
        assertSame(((Vicar) officeConsoleView.context.getProperty("vicar")).getPhone(), "1");
        assertSame(((Vicar) officeConsoleView.context.getProperty("vicar")).getSalary(), 2);
        assertSame(((Depart) officeConsoleView.context.getProperty("check depart")).getName(), "second depart");

    }

    @Test
    public void testShow() throws Exception {
        EasyMock.reset(mock);
        expect(mock.readParameter("Vicar name")).andReturn("Show Vicar");
        EasyMock.replay(mock);
        officeConsoleView.show();
        EasyMock.verify(mock);
        assertSame(officeConsoleView.context.getProperty("name"),"Show Vicar");

    }

    @Test
    public void testRedact() throws Exception {
        EasyMock.reset(mock);
        expect(mock.readParameter("Vicar name")).andReturn("Redact Vicar");
        EasyMock.replay(mock);
        officeConsoleView.redact();
        EasyMock.verify(mock);
        assertSame(officeConsoleView.context.getProperty("name"),"Redact Vicar");

    }

    @Test
    public void testSearch() throws Exception {
        EasyMock.reset(mock);
        expect(mock.readParameter("Name(s)?")).andReturn("?li*");
        EasyMock.replay(mock);
        officeConsoleView.search();
        EasyMock.verify(mock);
        assertSame(officeConsoleView.context.getProperty("pattern"),"?li*");

    }
    
    @Test
    public void testDelete() throws Exception {
        EasyMock.reset(mock);
        expect(mock.readParameter("Vicar name")).andReturn("Delete Vicar");
        EasyMock.replay(mock);
        officeConsoleView.redact();
        EasyMock.verify(mock);
        assertSame(officeConsoleView.context.getProperty("name"), "Delete Vicar");

    }
}
