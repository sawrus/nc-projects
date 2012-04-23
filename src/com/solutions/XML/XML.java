package com.solutions.XML;

import com.solutions.entities.impl.Agency;
import com.solutions.entities.impl.Office;
import com.solutions.entities.impl.Vicar;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class XML {

    public static void XML_Save(Office pers, String filename) throws Exception {
        Collection<Vicar> itogo = pers.Values();
        try {
            FileOutputStream out = new FileOutputStream(filename);
            GZIPOutputStream gz = new GZIPOutputStream(out);
            XMLEncoder xmlEncoder = new XMLEncoder(gz);
            for (Vicar obj : itogo) {
                xmlEncoder.writeObject(obj);
            }
            xmlEncoder.flush();
            xmlEncoder.close();
        } catch (java.io.EOFException eofe) {
            System.out.println("File is empty");
        } catch (FileNotFoundException e) {
            System.out.println("There are not file" + filename);
            System.exit(0);
        }
    }

    public static void XML_Load(Office pers, Agency dep, String filename) throws Exception {
        try {
            FileInputStream in = new FileInputStream(filename);
            GZIPInputStream gs = new GZIPInputStream(in);
            XMLDecoder xmlDecoder = new XMLDecoder(gs);
            Vicar obj = new Vicar();
            while (true) {
                try {
                    obj = (Vicar) xmlDecoder.readObject();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("It is end of file");
                    break;
                }
                pers.SetVicar(obj);
                try {
                    dep.SetDepart(obj.getDepart());
                    dep.SetDepart(obj.getDepart());
                } catch (NullPointerException e) {

                }
            }
            xmlDecoder.close();
        } catch (java.io.EOFException eofe) {
            System.out.println("File is empty");
        } catch (FileNotFoundException e) {
            System.out.println("There are not file" + filename);
            System.exit(0);
        } catch (java.util.zip.ZipException e) {
            System.out.println(filename + " not in GZIP format");
            System.exit(0);
        }
    }

}