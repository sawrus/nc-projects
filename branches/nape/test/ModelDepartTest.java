import junit.framework.*;
import sun.org.mozilla.javascript.internal.ast.Yield;

import java.util.*;
public class ModelDepartTest extends TestCase {
    private static TreeSet<Depart> Office = new TreeSet<Depart>();
    private static TreeSet<Vicar> Personal = new TreeSet<Vicar>();
    public void testModelDepart ()throws Exception{
        Depart A = new Depart("first depart","Nikita Jigurda");
        ModelDepart.AppendDepart(Office,A);
        assertTrue(Office.contains(A));
        Depart B = new Depart("second depart","Yazz");
        ModelDepart.AppendDepart(Office,B);
        Depart C = new Depart("third depart","Cereal guy");
        ModelDepart.AppendDepart(Office,C);
        Vicar X = new Vicar("Nikita Jigurda","112112",(float)10000);
        X.setDepart_link(A);
        ModelVicar.AppendVicar(Personal,X);
        Vicar Y = new Vicar("YAZZ","112112",(float)10000);
        Y.setDepart_link(B);
        ModelVicar.AppendVicar(Personal,Y);
        Vicar Z = new Vicar("Cereal guy","112112",(float)10000);
        Z.setDepart_link(C);
        ModelVicar.AppendVicar(Personal,Z);
        Vicar K = new Vicar("Me gusta","112112",(float)10000);
        ModelVicar.AppendVicar(Personal,K);
        int p = ModelDepart.SearchTitle(Office, "first depart");
        assertEquals(p, 1);
        p = ModelDepart.SearchTitle(Office,"***** depart");
        assertEquals(p, 2);
        p = ModelDepart.SearchTitle(Office,"?");
        assertEquals(p, 3);
        p = ModelDepart.SearchChief(Office, "Yazz");
        assertEquals(p, 1);
        p = ModelDepart.SearchChief(Office, "*i*i****i***d*");
        assertEquals(p, 1);
        p = ModelDepart.SearchChief(Office, "?");
        assertEquals(p, 3);
        A.setChief("Me gusta");
        ModelDepart.VicarChecking(A, Personal, Office);
        assertEquals(K.getDepart_link().getTitle(), "first depart");
        B.setChief("Trollface");
        ModelDepart.VicarChecking(B, Personal, Office);
        Vicar W = new Vicar();
        W = ModelVicar.SearchVicar(Personal,"Trollface");
        assertEquals(W.getDepart_link().getTitle(), "second depart");
        Depart N = new Depart();
        N = ModelDepart.SearchDepart(Office, "third depart");
        assertEquals(N.getChief(), "Cereal guy");
        N = ModelDepart.SearchDepart(Office, "second depart");
        ModelDepart.DeleteDepart(Office,N);
        assertFalse(Office.contains(B));
    }
}
