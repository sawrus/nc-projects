package com.solutions.views.impl;

import com.solutions.entities.impl.Depart;
import com.solutions.events.impl.DepartEvent;
import com.solutions.views.IRead;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertSame;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;


public class DepartConsoleViewTest {

    private DepartConsoleView departConsoleView = new DepartConsoleView();
    private IRead mock;

    @Before
    public void setUp() throws Exception {
       System.out.println("DepartConsoleView started");
       mock = createMock(IRead.class);
       departConsoleView.SetIRead(mock);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("DepartConsoleView finished");
    }

    @Test
    public void testFill() throws Exception {
        EasyMock.reset(mock);
        expect(mock.readParameter("Depart name")).andReturn("Second depart");
        expect(mock.readParameter("Chief of Depart")).andReturn("Adams");
        EasyMock.replay(mock);
        departConsoleView.fill();
        EasyMock.verify(mock);
        assertSame(String.valueOf(departConsoleView.context.getProperty("name")), "Second depart");
        assertSame(String.valueOf(departConsoleView.context.getProperty("chief")), "Adams");
    }

    @Test
    public void testRedact() throws Exception {
        EasyMock.reset(mock);
        expect(mock.readParameter("?")).andReturn("1");
        expect(mock.readParameter("Depart name")).andReturn("First depart");
        expect(mock.readParameter("?")).andReturn("2");
        expect(mock.readParameter("Depart chief")).andReturn("Sepius I");
        expect(mock.readParameter("?")).andReturn("3");
        EasyMock.replay(mock);
        departConsoleView.redact();
        EasyMock.verify(mock);
        assertSame(String.valueOf(departConsoleView.context.getProperty("name")), "First depart");
        assertSame(String.valueOf(departConsoleView.context.getProperty("chief")), "Sepius I");
    }
}
