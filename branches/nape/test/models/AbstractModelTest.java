package com.solutions.models;

import com.solutions.entities.IEntity;
import com.solutions.entities.impl.Agency;
import com.solutions.entities.impl.Depart;
import com.solutions.entities.impl.Office;
import com.solutions.entities.impl.Vicar;
import com.solutions.events.Event;
import com.solutions.models.impl.AgencyModel;
import com.solutions.models.impl.DepartModel;
import com.solutions.models.impl.OfficeModel;
import com.solutions.models.impl.VicarModel;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class AbstractModelTest {

    class ConcreteModel<TEntity extends IEntity> extends AbstractModel<TEntity> {

        protected ConcreteModel(TEntity tEntity) {
            super(tEntity);
        }

        public IModel getParent() {
            return this.parent;
        }

        public void handleEvent(Event event) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("AbstractModelTest started");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("AbstractModelTest finished");
    }

    @Test
    public void testSetParent() throws Exception {
        Agency a = new Agency();
        AgencyModel A = new AgencyModel(a);
        Depart b = new Depart();
        DepartModel B = new DepartModel(b);
        Office c = new Office();
        OfficeModel C = new OfficeModel(c);
        Vicar d = new Vicar();
        VicarModel D = new VicarModel(d);
        ConcreteModel q = new ConcreteModel(a);
        q.setParent(A);
        assertSame(q.getParent(), A);
        q.setParent(B);
        assertSame(q.getParent(), B);
        q.setParent(C);
        assertSame(q.getParent(), C);
        q.setParent(D);
        assertSame(q.getParent(), D);
    }

    @Test
    public void testClear() throws Exception {

        Depart b = new Depart("x", "y");
        Vicar d = new Vicar("y", b, "a", "c", "1", 2);
        Agency a = new Agency();
        Office c = new Office();

        a.SetDepart(b);
        c.SetVicar(d);

        ConcreteModel A = new ConcreteModel(a);
        ConcreteModel B = new ConcreteModel(b);
        ConcreteModel C = new ConcreteModel(c);
        ConcreteModel D = new ConcreteModel(d);
        A.clear();
        Assert.assertSame(A.getEntity().getName(), "");
        Assert.assertSame(((Agency) A.getEntity()).Values().size(), 0);
        C.clear();
        Assert.assertSame(C.getEntity().getName(), "");
        Assert.assertSame(((Office) C.getEntity()).Values().size(), 0);
        B.clear();
        Assert.assertSame(B.getEntity().getName(), "");
        Assert.assertSame(((Depart) B.getEntity()).getChief(), null);
        D.clear();
        Assert.assertSame(D.getEntity().getName(), "");
        Assert.assertSame(((Vicar) D.getEntity()).getDepart(), null);
        Assert.assertSame(((Vicar) D.getEntity()).getSecondName(), "");
        Assert.assertSame(((Vicar) D.getEntity()).getLastName(), "");
        Assert.assertSame(((Vicar) D.getEntity()).getPhone(), "");
        Assert.assertSame(((Vicar) D.getEntity()).getSalary(), 0);
    }

    @Test
    public void testGetEntity() throws Exception {
        Agency a = new Agency();
        Depart b = new Depart();
        Office c = new Office();
        Vicar d = new Vicar();
        ConcreteModel A = new ConcreteModel(a);
        ConcreteModel B = new ConcreteModel(b);
        ConcreteModel C = new ConcreteModel(c);
        ConcreteModel D = new ConcreteModel(d);
        assertSame(A.getEntity(), a);
        assertSame(B.getEntity(), b);
        assertSame(C.getEntity(), c);
        assertSame(D.getEntity(), d);
    }
}
