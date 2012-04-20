package com.solutions.views.impl;

import com.solutions.views.IRead;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertSame;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertTrue;


public class VicarConsoleViewTest {

    private VicarConsoleView vicarConsoleView = new VicarConsoleView();
    private IRead mock;

    @Before
    public void setUp() throws Exception {
       System.out.println("DepartConsoleView started");
       mock = createMock(IRead.class);
       vicarConsoleView.SetIRead(mock);
    }

    @After
    public void tearDown() throws Exception {
       System.out.println("DepartConsoleView finished");
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
        vicarConsoleView.fill();
        EasyMock.verify(mock);
        assertSame(String.valueOf(vicarConsoleView.context.getProperty("name")), "a");
        assertSame(String.valueOf(vicarConsoleView.context.getProperty("secondName")), "b");
        assertSame(String.valueOf(vicarConsoleView.context.getProperty("lastName")), "c");
        assertSame(String.valueOf(vicarConsoleView.context.getProperty("phone")), "1");
        assertTrue(((Integer) vicarConsoleView.context.getProperty("salary")) == 2);
        assertSame(String.valueOf(vicarConsoleView.context.getProperty("depart")), "second depart");

    }

    @Test
    public void testRedact() throws Exception {
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
        vicarConsoleView.redact();
        EasyMock.verify(mock);
        assertSame(String.valueOf(vicarConsoleView.context.getProperty("name")), "Adam");
        assertSame(String.valueOf(vicarConsoleView.context.getProperty("secondName")), "Adams");
        assertSame(String.valueOf(vicarConsoleView.context.getProperty("lastName")), "Adamson");
        assertSame(String.valueOf(vicarConsoleView.context.getProperty("phone")), "3");
        assertTrue(((Integer) vicarConsoleView.context.getProperty("salary")) == 4);
        assertSame(String.valueOf(vicarConsoleView.context.getProperty("depart")), "third depart");

    }
}
