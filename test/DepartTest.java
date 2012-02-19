import java.lang.*;
import junit.framework.*;
public class DepartTest extends TestCase {
    public void testDepart(){
        Depart a= new Depart("X","Y");
        Depart b= new Depart("X","Y");
        Depart c= new Depart("Z","K");
        Depart d= new Depart("X","Z");
        assertEquals(a.compareTo(b),0);
        assertFalse(a.compareTo(d)==0);
        assertFalse(a.compareTo(c)==0);
        assertEquals("X",a.getTitle());
        assertEquals("Y",a.getChief());
        d.setChief(b.getChief());
        assertEquals(b.getChief(),d.getChief());
        a.setTitle(c.getTitle());
        assertEquals(c.getTitle(),a.getTitle());
    }
}