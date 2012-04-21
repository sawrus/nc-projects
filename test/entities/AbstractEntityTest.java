package com.solutions.entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;


public class AbstractEntityTest {

    class ConcreteEntity extends AbstractEntity {

        protected ConcreteEntity(String name) {
            this.name = name;
        }

        public void clear() {}
    }

    private ConcreteEntity concreteEntity = new ConcreteEntity("Alpha");

    @Before
    public void setUp() throws Exception {
        System.out.println("AbstractEntityTest started");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("AbstractEntityTest finished");
    }

    @Test
    public void testGetName() throws Exception {
        assertSame(concreteEntity.getName(), "Alpha");
    }

    @Test
    public void testSetName() throws Exception {
        concreteEntity.setName("Beta");
        assertSame(concreteEntity.getName(), "Beta");
    }
}
