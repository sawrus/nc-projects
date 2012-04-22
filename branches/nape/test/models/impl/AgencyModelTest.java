package com.solutions.models.impl;

import com.solutions.context.Context;
import com.solutions.entities.impl.Agency;
import com.solutions.entities.impl.Depart;
import com.solutions.views.IRead;
import junit.framework.Assert;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertSame;

public class AgencyModelTest {

    private Agency S = new Agency();
    private AgencyModel s = new AgencyModel(S);
    private Context p;
    private IRead mock;

    @Before
    public void setUp() throws Exception {
        System.out.println("AgencyModelTest started");
        mock = createMock(IRead.class);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("AgencyModelTest finished");
    }

    @Test
    public void testShowDepart() throws Exception {
        p = new Context();
        Depart r = new Depart("c", "d");
        p.setProperty("depart", r);
        s.fill(p);
        s.ShowDepart("c");
    }

    @Test
    public void testChangeDepart() throws Exception {
        p = new Context();
        Depart r = new Depart("p", "q");
        p.setProperty("depart", r);
        s.fill(p);
        EasyMock.reset(mock);
        System.out.println("3");
        expect(mock.readParameter("Depart title")).andReturn("p");
        expect(mock.readParameter("?")).andReturn("1");
        expect(mock.readParameter("Depart name")).andReturn("Second depart");
        expect(mock.readParameter("?")).andReturn("2");
        expect(mock.readParameter("Depart chief")).andReturn("Adams");
        expect(mock.readParameter("?")).andReturn("3");
        EasyMock.replay(mock);
        r = s.ChangeDepart("p", mock);
        Assert.assertSame(r.getName(), "Second depart");
        Assert.assertSame(r.getChief(), "Adams");

    }

    @Test
    public void testSearchDepart() throws Exception {
        s.SearchDepart("?");
    }

    @Test
    public void testFill() throws Exception {
        p = new Context();
        Depart r = new Depart("x", "y");
        p.setProperty("depart", r);
        s.fill(p);
        assertSame(s.getEntity().GetDepart("x"), r);
    }

    @Test
    public void testShow() throws Exception {
        p = new Context();
        Depart r = new Depart("m", "n");
        p.setProperty("depart", r);
        s.fill(p);
        p.setProperty("title", "m");
        s.show(p);
    }

    @Test
    public void testRedact() throws Exception {
        EasyMock.reset(mock);
        expect(mock.readParameter("Depart title")).andReturn("f");
        expect(mock.readParameter("?")).andReturn("1");
        expect(mock.readParameter("Depart name")).andReturn("Third depart");
        expect(mock.readParameter("?")).andReturn("2");
        expect(mock.readParameter("Depart chief")).andReturn("Beatriss");
        expect(mock.readParameter("?")).andReturn("3");
        EasyMock.replay(mock);
        p = new Context();
        Depart r = new Depart("f", "z");
        p.setProperty("depart", r);
        s.fill(p);
        p.setProperty("title", "f");
        s.redact(p, mock);
        r = s.getEntity().GetDepart("Third depart");
        Assert.assertSame(r.getName(), "Third depart");
        Assert.assertSame(r.getChief(), "Beatriss");
    }

    @Test
    public void testSearch() throws Exception {
        p = new Context();
        p.setProperty("pattern", "*");
        s.search(p);
    }
    
    @Test
    public void testDelete() throws Exception {
        p = new Context();
        Depart q = new Depart("h", "u");
        Vicar r = new Vicar("u", q, "h", "t", "36", 6);
        p.setProperty("vicar", r);
        v.fill(p);
        p.setProperty("name", "u");
        v.delete(p);
        Assert.assertSame(v.getEntity().GetVicar("u"), null);
    }
}
