package com.solutions.context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertSame;

public class ContextTest {

    Context context = new Context();

    @Before
    public void setUp() throws Exception {
        System.out.println("Context Test started");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Context Test finished");
    }

    @Test
    public void testSetGetProperty() throws Exception {
        Object A = new Object();
        context.setProperty("object", A);
        assertSame(A, context.getProperty("object"));
    }
    
}
