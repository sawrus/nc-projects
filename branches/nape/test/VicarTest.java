import java.lang.*;
import junit.framework.*;
public class VicarTest extends TestCase {
    public void testVicar(){
        Depart DepartFirst = new Depart("first","not defined");
        Depart DepartSecond = new Depart("second","not defined");
        Vicar a = new Vicar("k","105010",10000);
        Vicar b = new Vicar("k","105010",8000);
        Vicar c = new Vicar("k","88002000600",8000);
        Vicar d = new Vicar("k","105010",10000);
        Vicar e = new Vicar("k","105010",10000);
        Vicar f = new Vicar("f","105010",10000);
        a.setDepart_link(DepartFirst);
        assertEquals(a.getDepart_link().getTitle(), "first");
        b.setDepart_link(DepartFirst);
        assertEquals(b.getDepart_link().getTitle(), "first");
        c.setDepart_link(DepartFirst);
        assertEquals(c.getDepart_link().getTitle(), "first");
        d.setDepart_link(DepartFirst);
        assertEquals(d.getDepart_link().getTitle(), "first");
        e.setDepart_link(DepartSecond);
        assertEquals(e.getDepart_link().getTitle(), "second");
        f.setDepart_link(DepartFirst);
        assertEquals(f.getDepart_link().getTitle(), "first");
        assertEquals(a.compareTo(d), 0);
        assertFalse(a.compareTo(e)==0);
        assertFalse(a.compareTo(c)==0);
        assertFalse(a.compareTo(b)==0);
        assertFalse(a.compareTo(f)==0);
        assertEquals("k",a.getFIO());
        assertEquals("105010",a.getPhone());
        assertEquals((float)10000,a.getSalary());
        a.setFIO(f.getFIO());
        assertEquals(a.getFIO(),"f");
        a.setPhone(c.getPhone());
        assertEquals(a.getPhone(),"88002000600");
        a.setSalary(b.getSalary());
        assertEquals(a.getSalary(),(float)8000);
    }
}