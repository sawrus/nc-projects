import junit.framework.*;
import java.util.*;
import Vicar.*;
import Depart.*;
import ModelVicar.*;
import ModelDepart.*;
public class ModelVicarTest extends TestCase {
    private static TreeSet<Depart> Office = new TreeSet<Depart>();
    private static TreeSet<Vicar> Personal = new TreeSet<Vicar>();
    public void testModelVicar ()throws Exception{
       Depart A = new Depart("first depart","Nikita Jigurda");
       Depart Z = new Depart("second depart","Ne gusta");
       ModelDepart.AppendDepart(Office,A);
       ModelDepart.AppendDepart(Office,Z);
       Vicar B = new Vicar("Nikita Jigurda","8800200600",(float) 10000);
       B.setDepart_link(A);
       ModelVicar.AppendVicar(Personal, B);
       assertTrue(Personal.contains(B));
       Vicar C = new Vicar("Me gusta","401740",(float) 5000);
       Vicar D = new Vicar("Ne gusta","464615",(float) 5000);
       C.setDepart_link(A);
       D.setDepart_link(Z);
       ModelVicar.AppendVicar(Personal,C);
       ModelVicar.AppendVicar(Personal,D);
       int p = ModelVicar.SearchFIO(Personal, "Nikita Jigurda");
       assertEquals(p, 1);
       p = ModelVicar.SearchFIO(Personal, "*e gusta");
       assertEquals(p, 2);
       p = ModelVicar.SearchFIO(Personal, "?");
       assertEquals(p, 3);
       p = ModelVicar.SearchPhone(Personal, "8800200600");
       assertEquals(p, 1);
       p = ModelVicar.SearchPhone(Personal, "4*****");
       assertEquals(p, 2);
       p = ModelVicar.SearchPhone(Personal, "?0?");
       assertEquals(p, 2);
       p = ModelVicar.SearchDepart(Personal, "first depart");
       assertEquals(p, 2);
       p = ModelVicar.SearchDepart(Personal, "****** depart");
       assertEquals(p, 1);
       p = ModelVicar.SearchDepart(Personal, "?depart");
       assertEquals(p, 3);
       ModelVicar.DepartChecking(C, "second depart", Personal, Office);
       assertEquals(C.getDepart_link().getChief(), "Ne gusta");
       ModelVicar.DepartChecking(C, "third depart", Personal, Office);
       assertEquals(C.getDepart_link().getTitle(),"third depart");
       assertEquals(C.getDepart_link().getChief(),"Me gusta");
       Vicar N = new Vicar();
       N = ModelVicar.SearchVicar(Personal, "Me gusta");
       assertEquals(N.getDepart_link().getTitle(), "third depart");
       ModelVicar.DeleteVicar(Personal, N);
       assertFalse(Personal.contains(C));

    }
}