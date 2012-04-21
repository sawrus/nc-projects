package com.solutions.entities.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * Created by IntelliJ IDEA.
 * User: Chaotickgood
 * Date: 21.04.12
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
public class AgencyTest {

    private Agency agency = new Agency();

    @Before
    public void setUp() throws Exception {
        System.out.println("AgencyTest started");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("AgencyTest finished");
    }

    @Test
    public void testSetGetDepart() throws Exception {
        Depart depart = new Depart("X", "y");
        agency.SetDepart(depart);
        assertSame(agency.GetDepart("X"), depart);
    }

    @Test
    public void testClear() throws Exception {
        agency.clear();
        assertSame(agency.getName(), "");
        assertSame(agency.Values().size(), 0);
    }

    @Test
    public void testDeleteDepart() throws Exception {
        Depart depart = new Depart("Y", "x");
        agency.SetDepart(depart);
        agency.DeleteDepart("Y");
        assertSame(agency.GetDepart("Y"), null);
    }

    @Test
    public void testCheckDepart() throws Exception {
        agency.clear();
        agency.CheckDepart("X");
        assertSame(agency.GetDepart("X").getName(), "X");
        assertSame(agency.GetDepart("X").getChief(), null);
        Depart depart = new Depart("Y", "x");
        agency.SetDepart(depart);
        agency.CheckDepart("Y");
        assertSame(agency.GetDepart("Y").getName(), "Y");
        assertSame(agency.GetDepart("Y").getChief(), "x");

    }

    @Test
    public void testValues() throws Exception {
        Depart depart = new Depart("X", "y");
        Depart depart2 = new Depart("Y", "x");
        agency.SetDepart(depart);
        agency.SetDepart(depart2);
        assertSame(agency.Values().size(), 2);
        agency.DeleteDepart("X");
        assertSame(agency.Values().size(), 1);
    }

}
