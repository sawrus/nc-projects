package com.solutions.views.impl;

import com.solutions.views.ConsoleRead;
import com.solutions.views.IRead;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;


public class ConsoleViewTest {

     class ConcreteConsoleView extends ConsoleView {
         public IRead GetIRead() {
               return this.iread;
         }
    }

    private ConcreteConsoleView concreteConsoleView = new ConcreteConsoleView();

    private IRead iread = new ConsoleRead();

    @Before
    public void setUp() throws Exception {
        System.out.println("ConsoleViewTest started");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("ConsoleViewTest finished");
    }

    @Test
    public void testSetIRead() throws Exception {
        assertNotSame(concreteConsoleView.GetIRead(),iread);
        concreteConsoleView.SetIRead(iread);
        assertSame(concreteConsoleView.GetIRead(), iread);
    }
}
