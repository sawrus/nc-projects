package com.solutions.models.impl;

import com.solutions.context.Context;
import com.solutions.entities.impl.Agency;
import com.solutions.entities.impl.Depart;
import com.solutions.entities.impl.Office;
import com.solutions.entities.impl.Vicar;
import com.solutions.views.IRead;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertSame;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

public class OfficeModelTest {

    Agency W = new Agency();
    AgencyModel w = new AgencyModel(W);

    Office V = new Office();
    OfficeModel v = new OfficeModel(V, w);

    private Context p;
    private IRead mock;

    @Before
    public void setUp() throws Exception {
        System.out.println("OfficeModelTest started");
        mock = createMock(IRead.class);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("OfficeModelTest finished");
    }

    @Test
    public void testShowVicar() throws Exception {
        p = new Context();
        Depart q = new Depart("y", "z");
        Vicar r = new Vicar("z", q, "e", "b", "30", 300);
        p.setProperty("vicar", r);
        v.fill(p);
        v.ShowVicar("z");
    }

    @Test
    public void testChangeVicar() throws Exception {
        p = new Context();
        Depart q = new Depart("e", "f");
        Vicar r = new Vicar("f", q, "u", "r", "20", 200);
        p.setProperty("vicar", r);
        v.fill(p);
        EasyMock.reset(mock);
        expect(mock.readParameter("?")).andReturn("1");
        expect(mock.readParameter("Vicar name")).andReturn("Adam");
        expect(mock.readParameter("?")).andReturn("2");
        expect(mock.readParameter("Vicar secondName")).andReturn("Adams");
        expect(mock.readParameter("?")).andReturn("3");
        expect(mock.readParameter("Vicar lastName")).andReturn("Adamson");
        expect(mock.readParameter("?")).andReturn("4");
        expect(mock.readParameter("Vicar phone")).andReturn("3");
        expect(mock.readParameter("?")).andReturn("5");
        expect(mock.readParameter("Depart title")).andReturn("third depart");
        expect(mock.readParameter("?")).andReturn("6");
        expect(mock.readParameter("Vicar salary")).andReturn("4");
        expect(mock.readParameter("?")).andReturn("7");
        EasyMock.replay(mock);
        r = v.ChangeVicar("f", mock);
        assertSame(r.getName(), "Adam");
        assertSame(r.getDepart().getName(), "third depart");
        assertSame(r.getSecondName(), "Adams");
        assertSame(r.getLastName(), "Adamson");
        assertSame(r.getPhone(), "3");
        assertSame(r.getSalary(), 4);

    }

    @Test
    public void testSearchVicar() throws Exception {
        v.SearchVicar("?");
    }

    @Test
    public void testFill() throws Exception {
        p = new Context();
        Depart q = new Depart("c", "d");
        Vicar r = new Vicar("d", q, "y", "z", "10", 100);
        p.setProperty("vicar", r);
        v.fill(p);
        org.junit.Assert.assertSame(v.getEntity().GetVicar("d"), r);

    }

    @Test
    public void testShow() throws Exception {
        p = new Context();
        Depart q = new Depart("h", "u");
        Vicar r = new Vicar("u", q, "h", "t", "36", 6);
        p.setProperty("vicar", r);
        v.fill(p);
        p.setProperty("name", "u");
        v.show(p);
    }

    @Test
    public void testRedact() throws Exception {

        EasyMock.reset(mock);
        expect(mock.readParameter("?")).andReturn("1");
        expect(mock.readParameter("Vicar name")).andReturn("Adam");
        expect(mock.readParameter("?")).andReturn("2");
        expect(mock.readParameter("Vicar secondName")).andReturn("Adams");
        expect(mock.readParameter("?")).andReturn("3");
        expect(mock.readParameter("Vicar lastName")).andReturn("Adamson");
        expect(mock.readParameter("?")).andReturn("4");
        expect(mock.readParameter("Vicar phone")).andReturn("3");
        expect(mock.readParameter("?")).andReturn("5");
        expect(mock.readParameter("Depart title")).andReturn("third depart");
        expect(mock.readParameter("?")).andReturn("6");
        expect(mock.readParameter("Vicar salary")).andReturn("4");
        expect(mock.readParameter("?")).andReturn("7");
        EasyMock.replay(mock);


        p = new Context();
        Depart q = new Depart("n", "g");
        Vicar r = new Vicar("g", q, "u", "n", "1", 2);
        p.setProperty("vicar", r);
        v.fill(p);
        p.setProperty("name", "g");
        v.redact(p, mock);
        r = v.getEntity().GetVicar("Adam");
    }

    @Test
    public void testSearch() throws Exception {
        p = new Context();
        p.setProperty("pattern", "*");
        v.search(p);
    }
}
