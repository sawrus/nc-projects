package com.solutions.entities.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DepartTest {

    private Depart depart = new Depart("X", "Y");

    @Before
    public void setUp() throws Exception {
        System.out.println("DepartTest started");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("DepartTest finished");
    }

    @Test
    public void testGetChief() throws Exception {
        assertSame(depart.getChief(), "Y");
    }

    @Test
    public void testSetChief() throws Exception {
        depart.setChief("Anaximandr");
        assertSame(depart.getChief(), "Anaximandr");
    }

    @Test
    public void testGetName() throws Exception {
        assertSame(depart.getName(), "X");
    }

    @Test
    public void testSetName() throws Exception {
        depart.setName("Academy");
        assertSame(depart.getName(), "Academy");
    }

    @Test
    public void testClear() throws Exception {
        depart.clear();
        assertSame(depart.getName(), "");
        assertSame(depart.getChief(), null);
    }

    @Test
    public void testEquals() throws Exception {
        depart.setName("A");
        depart.setChief("B");
        assertTrue(depart.equals(depart));
        Depart A = new Depart("A", "B");
        assertTrue(depart.equals(A));
        A.setChief("Z");
        assertFalse(depart.equals(A));
    }
}
