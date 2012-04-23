package com.solutions.XML;

import com.solutions.entities.impl.Agency;
import com.solutions.entities.impl.Office;
import com.solutions.entities.impl.Vicar;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;



public class XML {

public static void XML_Save(Office Pers, String Filename) throws Exception {
     Collection<Vicar> itogo = Pers.Values();
        try {
            FileOutputStream out = new FileOutputStream(Filename);
            GZIPOutputStream gz = new GZIPOutputStream(out);
            XMLEncoder xmlEncoder = new XMLEncoder(gz);
            for (Vicar Obj : itogo) {
                xmlEncoder.writeObject(Obj);
            }
            xmlEncoder.flush();
            xmlEncoder.close();
        } catch (java.io.EOFException eofe) {
            System.out.println("????? ???? ?????????? ??? ???");
        }
    }

public static void XML_Load(Office Pers, Agency Dep, String Filename) throws Exception {
        try {
            FileInputStream in = new FileInputStream(Filename);
            GZIPInputStream gs = new GZIPInputStream(in);
            XMLDecoder xmlDecoder = new XMLDecoder(gs);
            Vicar Obj = new Vicar();
            while (true) {
                try {
                    Obj = (Vicar) xmlDecoder.readObject();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("????? ???? ?????????? ??? ???");
                    break;
                }
                Pers.SetVicar(Obj);
                try {
                    Dep.SetDepart(Obj.getDepart());
                } catch (NullPointerException e) {
                }
            }
            xmlDecoder.close();
        } catch (java.io.EOFException eofe) {
            System.out.println("????? ???? ?????????? ??? ???");
        }
    }

}