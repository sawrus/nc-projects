package com.solutions.models.impl;

import com.solutions.context.Context;
import com.solutions.entities.impl.Depart;
import com.solutions.entities.impl.Vicar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class VicarModelTest {

    private Context context = new Context();
    private Depart depart = new Depart();
    private DepartModel departModel = new DepartModel(depart);
    private Vicar vicar = new Vicar();
    private VicarModel vicarModel = new VicarModel(vicar);

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
        context.setProperty("depart", "First Depart");
        context.setProperty("name", "Felix");
        context.setProperty("secondName", "Edmundovich");
        context.setProperty("lastName", "Dzerjinsky");
        context.setProperty("phone", "1917");
        context.setProperty("salary", "0");
        vicarModel.fill(context);
        assertSame(vicarModel.getEntity().getName(), "Felix");
        assertSame(vicarModel.getEntity().getDepart().getName(), "First Depart");
        assertSame(vicarModel.getEntity().getSecondName(), "Edmundovich");
        assertSame(vicarModel.getEntity().getLastName(), "Dzerjinsky");
        assertSame(vicarModel.getEntity().getPhone(), "1917");
        assertTrue(vicarModel.getEntity().getSalary() == 0);
    }

    @Test
    public void testRedact() throws Exception {
        context.setProperty("depart", "Second Depart");
        context.setProperty("name", "Lavrentey");
        context.setProperty("secondName", "Pavlovich");
        context.setProperty("lastName", "Berija");
        context.setProperty("phone", "1937");
        context.setProperty("salary", "1000");
        String t = vicarModel.redact(context);
        assertSame(vicarModel.getEntity().getName(), "Lavrentey");
        assertSame(vicarModel.getEntity().getSecondName(), "Pavlovich");
        assertSame(vicarModel.getEntity().getLastName(), "Berija");
        assertSame(vicarModel.getEntity().getPhone(), "1937");
        assertTrue(vicarModel.getEntity().getSalary() == 1000);
        assertSame(t, "Second Depart");
    }
}
