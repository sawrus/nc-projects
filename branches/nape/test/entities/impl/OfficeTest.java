package com.solutions.entities.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class OfficeTest {

    Office office = new Office();

    @Before
    public void setUp() throws Exception {
        System.out.println("OfficeTest started");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("OfficeTest finished");
    }

    @Test
    public void testSetGetVicar() throws Exception {
        Depart depart = new Depart("X", "Y");
        Vicar vicar = new Vicar("a", depart, "b", "c", "1", 2);
        office.SetVicar(vicar);
        assertSame(office.GetVicar("a"), vicar);
    }

    @Test
    public void testDeleteVicar() throws Exception {
        Depart depart = new Depart("X", "Y");
        Vicar vicar = new Vicar("a", depart, "b", "c", "1", 2);
        office.SetVicar(vicar);
        assertSame(office.GetVicar("a"), vicar);
        office.DeleteVicar("a");
        assertSame(office.GetVicar("a"), null);
    }

    @Test
    public void testValues() throws Exception {
        Depart depart = new Depart("X", "y");
        Depart depart2 = new Depart("Y", "x");
        Vicar vicar = new Vicar("a", depart, "b", "c", "1", 2);
        Vicar vicar2 = new Vicar("x", depart2, "y", "z", "11", 12);
        office.SetVicar(vicar);
        office.SetVicar(vicar2);
        assertSame(office.Values().size(), 2);
        office.DeleteVicar("a");
        assertSame(office.Values().size(), 1);
    }

    @Test
    public void testClear() throws Exception {
        office.clear();
        assertSame(office.getName(), "");
        assertSame(office.Values().size(), 0);
    }
}
