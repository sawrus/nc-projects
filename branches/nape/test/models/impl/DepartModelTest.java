package com.solutions.models.impl;

import com.solutions.context.Context;
import com.solutions.entities.impl.Depart;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class DepartModelTest {

    private Context context = new Context();
    private Depart depart = new Depart();
    private DepartModel departModel = new DepartModel(depart);

    @Before
    public void setUp() throws Exception {
        System.out.println("DepartModelTest started");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("DepartModelTest finished");
    }

    @Test
    public void testFill() throws Exception {
        context.setProperty("name", "First Depart");
        context.setProperty("chief", "Felix");
        departModel.fill(context);
        assertSame(departModel.getEntity().getName(), "First Depart");
        assertSame(departModel.getEntity().getChief(), "Felix");
    }

    @Test
    public void testRedact() throws Exception {
        context.setProperty("name", "Second Depart");
        context.setProperty("chief", "Lavrenty");
        departModel.fill(context);
        assertSame(departModel.getEntity().getName(), "Second Depart");
        assertSame(departModel.getEntity().getChief(), "Lavrenty");
    }
}
