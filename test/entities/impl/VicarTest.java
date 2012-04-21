package com.solutions.entities.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: Chaotickgood
 * Date: 21.04.12
 * Time: 21:02
 * To change this template use File | Settings | File Templates.
 */
public class VicarTest {

    private Depart depart = new Depart("X", "Y");
    private Vicar vicar = new Vicar("a", depart, "b", "c", "1", 2);

    @Before
    public void setUp() throws Exception {
        System.out.println("VicarTest started");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("VicarTest finished");
    }

    @Test
    public void testGetDepart() throws Exception {
        assertSame(vicar.getDepart(), depart);
    }

    @Test
    public void testGetSecondName() throws Exception {
        assertSame(vicar.getSecondName(), "b");
    }

    @Test
    public void testGetLastName() throws Exception {
        assertSame(vicar.getLastName(), "c");
    }

    @Test
    public void testGetPhone() throws Exception {
        assertSame(vicar.getPhone(), "1");
    }

    @Test
    public void testGetSalary() throws Exception {
        assertSame(vicar.getSalary(), 2);
    }

    @Test
    public void testSetDepart() throws Exception {
        Depart depart2 = new Depart("A", "I");
        vicar.setDepart(depart2);
        assertSame(vicar.getDepart(), depart2);
    }

    @Test
    public void testSetSecondName() throws Exception {
        vicar.setSecondName("y");
        assertSame(vicar.getSecondName(), "y");
    }

    @Test
    public void testSetLastName() throws Exception {
        vicar.setLastName("z");
        assertSame(vicar.getLastName(), "z");
    }

    @Test
    public void testSetPhone() throws Exception {
        vicar.setPhone("88002000600");
        assertSame(vicar.getPhone(), "88002000600");
    }

    @Test
    public void testSetSalary() throws Exception {
        vicar.setSalary(101);
        assertSame(vicar.getSalary(), 101);
    }

    @Test
    public void testEquals() throws Exception {
        vicar.setDepart(depart);
        assertTrue(vicar.equals(vicar));
        Depart depart2 = new Depart("q", "r");
        Vicar vicar2 = new Vicar("m", depart2, "n", "l", "7", 11230);
        assertFalse(vicar.equals(vicar2));
        vicar.setDepart(depart2);
        vicar.setLastName("l");
        vicar.setPhone("7");
        vicar.setSalary(11230);
        vicar.setSecondName("n");
        vicar.setName("m");
        assertTrue(vicar.equals(vicar2));

    }

    @Test
    public void testClear() throws Exception {
        vicar.clear();
        assertSame(vicar.getName(), "");
        assertSame(vicar.getDepart(), null);
        assertSame(vicar.getSecondName(), "");
        assertSame(vicar.getLastName(), "");
        assertSame(vicar.getPhone(), "");
        assertSame(vicar.getSalary(), 0);
    }
}
