import java.lang.*;
import java.beans.*;
import java.io.*;
import java.util.*;

public class Depart implements java.io.Serializable, Comparable {

    public Depart(String T, String C) {
        Title = T;
        Chief = C;
    }

    public Depart() {
        Title = "";
        Chief = "";
    }

    ;

    private String Title;
    private String Chief;
//private Vicar Chief_link;

    public int compareTo(Object obj) {
        if (Title.compareTo(((Depart) obj).Title) == 0) {
            return Chief.compareTo(((Depart) obj).Chief);
        } else {
            return Title.compareTo(((Depart) obj).Title);
        }
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getChief() {
        return Chief;
    }

    public void setChief(String Chief) {
        this.Chief = Chief;
    }

/*public String getChief_link(){
 return Chief_link;
 }

public void setChief_link(Vicar Chief_link){
 this.Chief_link=Chief_link;
 }*/

}






