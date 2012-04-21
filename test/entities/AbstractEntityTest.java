package com.solutions.entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * Created by IntelliJ IDEA.
 * User: Chaotickgood
 * Date: 21.04.12
 * Time: 17:06
 * To change this template use File | Settings | File Templates.
 */
public class AbstractEntityTest {

    class ConcreteEntity extends AbstractEntity {

        protected ConcreteEntity(String name) {
            this.name = name;
        }

        public void clear() {
            //To change body of implemented methods use File | Settings | File Templates.
        }
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
