import java.lang.*;
import java.beans.*;
import java.io.*;
import java.util.*;

public class Vicar implements java.io.Serializable, Comparable {

    private String FIO;
    //private String Depart_name;
    private Depart Depart_link;
    private String Phone;
    private float Salary;

    public Vicar(String F, String P, float S) {
        FIO = F;
//Depart_name=D;
        Phone = P;
        Salary = S;
    }

    public Vicar() {
        FIO = "";
        //Depart_name="";
        Phone = "";
        Salary = 0;
    }

    public int compareTo(Object obj) {
        if (FIO.compareTo(((Vicar) obj).FIO) == 0) {
            if (Phone.compareTo(((Vicar) obj).Phone) == 0) {
                if (Salary == ((Vicar) obj).Salary) {
                    try {
                        if (Depart_link.getTitle().compareTo(((Vicar) obj).Depart_link.getTitle()) == 0) {
                            return 0;
                        } else {
                            return Depart_link.getTitle().compareTo(((Vicar) obj).Depart_link.getTitle());
                        }
                    } catch (NullPointerException e) {
                        return 0;
                    }
                } else {
                    if (Salary < ((Vicar) obj).Salary) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            } else {
                return Phone.compareTo(((Vicar) obj).Phone);
            }
        } else {
            return FIO.compareTo(((Vicar) obj).FIO);
        }
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

/*public String getDepart_name(){
 return Depart_name;
 }

public void setDepart_name(String Depart_name){
 this.Depart_name=Depart_name;
 }
*/

    public Depart getDepart_link() {
        return Depart_link;
    }

    public void setDepart_link(Depart Depart_link) {
        this.Depart_link = Depart_link;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float Salary) {
        this.Salary = Salary;
    }
}