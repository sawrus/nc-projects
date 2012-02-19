import java.lang.*;
import java.beans.*;
import java.io.*;
import java.util.*;

import Depart.*;
import Vicar.*;

import java.util.zip.*;

public class XMLSer {
    public static void XML_Save(Vicar Obj, XMLEncoder xmlEncoder) throws Exception {
        xmlEncoder.writeObject(Obj);
    }

    public static void XML_Save(TreeSet<Vicar> Pers, String Filename) throws Exception {
        try {
            FileOutputStream out = new FileOutputStream(Filename);
            GZIPOutputStream gz = new GZIPOutputStream(out);
            XMLEncoder xmlEncoder = new XMLEncoder(gz);
            for (Vicar Obj : Pers) {
                xmlEncoder.writeObject(Obj);
            }
            xmlEncoder.flush();
            xmlEncoder.close();
        } catch (java.io.EOFException eofe) {
            System.out.println("����� ���� ���������� ��� ���");
        }
    }

    public static void XML_Load(TreeSet<Vicar> Pers, TreeSet<Depart> Dep, String Filename) throws Exception {
        try {
            FileInputStream in = new FileInputStream(Filename);
            GZIPInputStream gs = new GZIPInputStream(in);
            XMLDecoder xmlDecoder = new XMLDecoder(gs);
            Vicar Obj = new Vicar();
            while (true) {
                try {
                    Obj = (Vicar) xmlDecoder.readObject();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("����� ���� ���������� ��� ���");
                    break;
                }
                Pers.add(Obj);
                try {
                    Dep.add((Depart) Obj.getDepart_link());
                } catch (NullPointerException e) {
                }
            }
            xmlDecoder.close();
        } catch (java.io.EOFException eofe) {
            System.out.println("����� ���� ���������� ��� ���");
        }
    }

    public static void XML_Concat(TreeSet<Vicar> Pers, TreeSet<Depart> Dep, String Filename1, String Filename2) throws Exception {
        XMLSer.XML_Load(Pers, Dep, Filename1);
        TreeSet<Vicar> Pers1 = new TreeSet<Vicar>();
        TreeSet<Depart> Dep1 = new TreeSet<Depart>();
        XMLSer.XML_Load(Pers1, Dep1, Filename2);
        Pers.addAll(Pers1);
        Dep.addAll(Dep1);
        XMLSer.XML_Save(Pers, Filename1);
    }

}