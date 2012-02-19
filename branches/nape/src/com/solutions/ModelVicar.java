import java.lang.*;
import java.beans.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

import Depart.*;
import Vicar.*;
import XMLSer.*;
import VDView.*;

public class ModelVicar {

    private static TreeSet<Vicar> Personal = new TreeSet<Vicar>();
    private static TreeSet<Depart> Office = new TreeSet<Depart>();
    private static String Filename = new String("db.xml");

    public static void VLoad() throws Exception {
        XMLSer.XML_Load(Personal, Office, Filename);
    }

    public static void VSave() throws Exception {
        XMLSer.XML_Save(Personal, Filename);
    }

    public static void RedactVicar() throws Exception {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        ModelVicar.VLoad();
        int i = 0;
        while (i != 5) {
            VDView.ShowRedactVicar(0);
            i = Integer.valueOf(bReader.readLine());
            switch (i) {
                case (1):
                    Vicar N = new Vicar();
                    VDView.ShowRedactVicar(1);
                    N.setFIO(bReader.readLine());
                    VDView.ShowRedactVicar(2);
                    N.setPhone(bReader.readLine());
                    VDView.ShowRedactVicar(3);
                    N.setSalary(Float.valueOf(bReader.readLine()));
                    VDView.ShowRedactVicar(4);
                    String Answer = new String();
                    Answer = bReader.readLine();
                    DepartChecking(N, Answer, Personal, Office);
                    ModelVicar.AppendVicar(Personal, N);
                    break;
                case (2):
                    Vicar N2 = new Vicar();
                    N2 = SearchingVicar(Personal);
                    ModelVicar.ModifyVicar(N2);
                    break;
                case (3):
                    Vicar N3 = new Vicar();
                    N3 = SearchingVicar(Personal);
                    DeleteVicar(Personal, N3);
                    break;
                case (4):
                    Vicar N4 = new Vicar();
                    N4 = SearchingVicar(Personal);
                    VDView.ShowVicar(N4);
                    break;
                case (5):
                    break;
                default:
                    VDView.Menu(-1);
                    break;
            }
        }
        ModelVicar.VSave();
    }

    public static void DepartChecking(Vicar N, String Answer, TreeSet<Vicar> Personal, TreeSet<Depart> Office) {
        Iterator<Depart> itr = Office.iterator();
        String Inform = "There aren't such departament";
        while (itr.hasNext()) {
            Depart element = itr.next();
            if (element.getTitle().compareTo(Answer) == 0) {
                N.setDepart_link(element);
                Inform = "Done";
                break;
            }
        }
        if (Inform.compareTo("There aren't such departament") == 0) {
            Depart NN = new Depart();
            NN.setTitle(Answer);
            NN.setChief(N.getFIO());
            ModelDepart.AppendDepart(Office, NN);
            N.setDepart_link(NN);
        }
        System.out.println(Inform);
    }

    public static Vicar SearchVicar(TreeSet<Vicar> Pers, String AnswerS) throws Exception {
        Iterator<Vicar> itr = Pers.iterator();
        String Inform = "There aren't such vicar";
        Vicar Elem = new Vicar();
        Elem.setFIO(AnswerS);
        Elem.setPhone("Not defined");
        Elem.setSalary(0);
        while (itr.hasNext()) {
            Vicar element = itr.next();
            if (element.getFIO().compareTo(AnswerS) == 0) {
                Elem = element;
                Inform = "Done";
                break;
            }
        }
        System.out.println(Inform);
        return Elem;
    }

    public static Vicar SearchingVicar(TreeSet<Vicar> Pers) throws Exception {
        BufferedReader bReaderS = new BufferedReader(new InputStreamReader(System.in));
        String AnswerS = new String();
        VDView.Menu(5);
        AnswerS = bReaderS.readLine();
        Vicar Elem = new Vicar();
        Elem = SearchVicar(Pers, AnswerS);
        return Elem;
    }

    public static int SearchFIO(TreeSet<Vicar> Personal, String O) throws Exception {
        Pattern pat;
        Matcher mat;
        boolean found;
        int x = 0;
        O = O.replace('*', '.');
        O = O.replace("?", ".+");
        System.out.println(O);
        pat = Pattern.compile(O);
        Iterator<Vicar> itr = Personal.iterator();
        Vicar Elem = new Vicar();
        while (itr.hasNext()) {
            Vicar element = itr.next();
            mat = pat.matcher(element.getFIO());
            found = mat.matches();
            if (found) {
                VDView.ShowVicar(element);
                x++;
            }
        }
        return x;
    }

    public static int SearchPhone(TreeSet<Vicar> Personal, String O) throws Exception {
        Pattern pat;
        Matcher mat;
        boolean found;
        int x = 0;
        O = O.replace('*', '.');
        O = O.replace("?", ".+");
        System.out.println(O);
        pat = Pattern.compile(O);
        Iterator<Vicar> itr = Personal.iterator();
        Vicar Elem = new Vicar();
        while (itr.hasNext()) {
            Vicar element = itr.next();
            mat = pat.matcher(element.getPhone());
            found = mat.matches();
            if (found) {
                VDView.ShowVicar(element);
                x++;
            }
        }
        return x;
    }

    public static int SearchDepart(TreeSet<Vicar> Personal, String O) throws Exception {
        Pattern pat;
        Matcher mat;
        boolean found;
        int x = 0;
        O = O.replace('*', '.');
        O = O.replace("?", ".+");
        System.out.println(O);
        pat = Pattern.compile(O);
        Iterator<Vicar> itr = Personal.iterator();
        Vicar Elem = new Vicar();
        while (itr.hasNext()) {
            Vicar element = itr.next();
            try {
                mat = pat.matcher(element.getDepart_link().getTitle());
                found = mat.matches();
            } catch (NullPointerException e) {
                found = false;
            }
            if (found) {
                VDView.ShowVicar(element);
                x++;
            }
        }
        return x;
    }


    public static void SearchingFIO(String O) throws Exception {
        SearchFIO(Personal, O);
    }

    public static void SearchingPhone(String O) throws Exception {
        SearchPhone(Personal, O);
    }

    public static void SearchingDepart(String O) throws Exception {
        SearchPhone(Personal, O);
    }

    public static void ModifyVicar(Vicar M) throws Exception {
        BufferedReader bReaderM = new BufferedReader(new InputStreamReader(System.in));
        int l = 0;
        while (true) {
            VDView.ShowModifyVicar(0);
            l = Integer.valueOf(bReaderM.readLine());
            if (l == 1) {
                ChangeFIO(M);
                l = 0;
                continue;
            }
            if (l == 2) {
                ChangePhone(M);
                l = 0;
                continue;
            }
            if (l == 3) {
                ChangeSalary(M);
                l = 0;
                continue;
            }
            if (l == 4) {
                ChangeDepart(M);
                l = 0;
                continue;
            }
            if (l == 5) {
                break;
            }
        }
    }

    public static int ChangeFIO(Vicar M) throws Exception {
        VDView.ShowModifyVicar(1);
        BufferedReader bReaderT = new BufferedReader(new InputStreamReader(System.in));
        M.setFIO(bReaderT.readLine());
        return 0;
    }

    public static int ChangePhone(Vicar M) throws Exception {
        VDView.ShowModifyVicar(2);
        BufferedReader bReaderT = new BufferedReader(new InputStreamReader(System.in));
        M.setPhone(bReaderT.readLine());
        return 0;
    }

    public static int ChangeSalary(Vicar M) throws Exception {
        VDView.ShowModifyVicar(3);
        BufferedReader bReaderT = new BufferedReader(new InputStreamReader(System.in));
        M.setSalary(Float.valueOf(bReaderT.readLine()));
        return 0;
    }

    public static int ChangeDepart(Vicar M) throws Exception {
        VDView.ShowModifyVicar(4);
        BufferedReader bReaderT = new BufferedReader(new InputStreamReader(System.in));
        String Ans = bReaderT.readLine();
        DepartChecking(M, Ans, Personal, Office);
        return 0;
    }

    public static void AppendVicar(TreeSet<Vicar> Personal, Vicar N) {
        if (!Personal.add(N)) {
            VDView.Menu(6);
        }
    }

    public static void DeleteVicar(TreeSet<Vicar> Personal, Vicar R) {
        Personal.remove(R);
    }

/*public static void ShowVicar(Vicar N){
 System.out.println("FIO: " + N.getFIO());
 System.out.println("Depart: "+N.getDepart_link().getTitle());
 System.out.println("Phone: "+N.getPhone());
 System.out.println("Salary: "+N.getSalary());
}*/
}
 