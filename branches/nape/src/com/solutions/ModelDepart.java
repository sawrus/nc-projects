import java.lang.*;
import java.beans.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

import Depart.*;
import Vicar.*;
import XMLSer.*;
import VDView.*;
import sun.reflect.generics.tree.Tree;

import javax.print.attribute.standard.MediaSize;

public class ModelDepart {

    private static TreeSet<Vicar> Personal = new TreeSet<Vicar>();
    private static TreeSet<Depart> Office = new TreeSet<Depart>();
    private static String Filename = new String("db.xml");

    public static void DLoad() throws Exception {
        XMLSer.XML_Load(Personal, Office, Filename);
    }

    public static void DSave() throws Exception {
        XMLSer.XML_Save(Personal, Filename);
    }

    public static void RedactDepart() throws Exception {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        ModelDepart.DLoad();
        int i = 0;
        while (i != 5) {
            VDView.ShowRedactDepart(0);
            i = Integer.valueOf(bReader.readLine());
            switch (i) {
                case (1):
                    Depart N = new Depart();
                    VDView.ShowRedactDepart(1);
                    N.setTitle(bReader.readLine());
                    VDView.ShowRedactDepart(2);
                    N.setChief(bReader.readLine());
                    VicarChecking(N, Personal, Office);
                    ModelDepart.AppendDepart(Office, N);
                    break;
                case (2):
                    Depart N2 = new Depart();
                    N2 = SearchingDepart(Office);
                    ModelDepart.ModifyDepart(N2);
                    break;
                case (3):
                    Depart N3 = new Depart();
                    N3 = SearchingDepart(Office);
                    DeleteDepart(Office, N3);
                    break;
                case (4):
                    Depart N4 = new Depart();
                    N4 = SearchingDepart(Office);
                    VDView.ShowDepart(N4);
                    break;
                case (5):
                    break;
                default:
                    VDView.Menu(-1);
                    break;
            }
        }
        ModelDepart.DSave();
    }

    public static void VicarChecking(Depart N, TreeSet<Vicar> Personal, TreeSet<Depart> Office) {
        String Answer = new String();
        Answer = N.getChief();
        Iterator<Vicar> itr = Personal.iterator();
        String Inform = "There aren't such vicar";
        while (itr.hasNext()) {
            Vicar element = itr.next();
            if (element.getFIO().compareTo(Answer) == 0) {
                element.setDepart_link(N);
                Inform = "Done";
                break;
            }
        }
        if (Inform.compareTo("There aren't such vicar") == 0) {
            Vicar NN = new Vicar();
            NN.setFIO(N.getChief());
            NN.setDepart_link(N);
            ModelVicar.AppendVicar(Personal, NN);
        }
        System.out.println(Inform);

    }

    public static Depart SearchDepart(TreeSet<Depart> Dep, String AnswerS) throws Exception {
        Iterator<Depart> itr = Dep.iterator();
        String Inform = "There aren't such departament";
        Depart Elem = new Depart();
        Elem.setTitle(AnswerS);
        Elem.setChief("Not defined");
        while (itr.hasNext()) {
            Depart element = itr.next();
            if (element.getTitle().compareTo(AnswerS) == 0) {
                Elem = element;
                Inform = "Done";
                break;
            }
        }
        System.out.println(Inform);
        return Elem;
    }

    public static Depart SearchingDepart(TreeSet<Depart> Dep) throws Exception {
        BufferedReader bReaderS = new BufferedReader(new InputStreamReader(System.in));
        String AnswerS = new String();
        VDView.Menu(3);
        AnswerS = bReaderS.readLine();
        Depart Elem = new Depart();
        Elem = SearchDepart(Dep, AnswerS);
        return Elem;
    }

    public static int SearchTitle(TreeSet<Depart> Office, String O) throws Exception {
        Pattern pat;
        Matcher mat;
        boolean found;
        int x = 0;
        O = O.replace('*', '.');
        O = O.replace("?", ".+");
        System.out.println(O);
        pat = Pattern.compile(O);
        Iterator<Depart> itr = Office.iterator();
        Depart Elem = new Depart();
        while (itr.hasNext()) {
            Depart element = itr.next();
            mat = pat.matcher(element.getTitle());
            found = mat.matches();
            if (found) {
                VDView.ShowDepart(element);
                x++;
            }
        }
        return x;
    }

    public static int SearchChief(TreeSet<Depart> Office, String O) throws Exception {
        Pattern pat;
        Matcher mat;
        boolean found;
        int x = 0;
        O = O.replace('*', '.');
        O = O.replace("?", ".+");
        System.out.println(O);
        pat = Pattern.compile(O);
        Iterator<Depart> itr = Office.iterator();
        Depart Elem = new Depart();
        while (itr.hasNext()) {
            Depart element = itr.next();
            mat = pat.matcher(element.getChief());
            found = mat.matches();
            if (found) {
                VDView.ShowDepart(element);
                x++;
            }
        }
        return x;
    }

    public static void SearchingChief(String O) throws Exception {
        SearchChief(Office, O);
    }

    public static void SearchingTitle(String O) throws Exception {
        SearchTitle(Office, O);
    }

    public static int ChangeTitle(Depart M) throws Exception {
        VDView.ShowModifyDepart(1);
        BufferedReader bReaderT = new BufferedReader(new InputStreamReader(System.in));
        M.setTitle(bReaderT.readLine());
        return 0;
    }

    public static int ChangeChief(Depart M) throws Exception {
        VDView.ShowModifyDepart(2);
        BufferedReader bReaderC = new BufferedReader(new InputStreamReader(System.in));
        M.setChief(bReaderC.readLine());
        return 0;
    }

    public static void ModifyDepart(Depart M) throws Exception {
        BufferedReader bReaderM = new BufferedReader(new InputStreamReader(System.in));
        int l = 0;
        while (true) {
            VDView.ShowModifyDepart(0);
            l = Integer.valueOf(bReaderM.readLine());
            if (l == 1) {
                ChangeTitle(M);
                l = 0;
                continue;
            }
            if (l == 2) {
                ChangeChief(M);
                l = 0;
                continue;
            }
            if (l == 3) {
                break;
            }
        }
    }

    public static void AppendDepart(TreeSet<Depart> Office, Depart N) {
        if (!Office.add(N)) {
            VDView.Menu(4);
        }
    }

    public static void DeleteDepart(TreeSet<Depart> Office, Depart R) {
        Office.remove(R);
    }

/*public static void ShowDepart(Depart N){
 System.out.println("Title: " + N.getTitle());
 System.out.println("Chief: "+N.getChief());
}*/

}