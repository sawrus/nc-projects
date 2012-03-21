package com.solutions.mvc.entities.impl;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.solutions.mvc.entities.AbstractEntity;
import com.solutions.mvc.entities.impl.Vicar;
import com.solutions.mvc.entities.impl.Depart;
import com.solutions.mvc.events.impl.DepartEvent;
import com.solutions.mvc.models.impl.DepartModel;
import com.solutions.mvc.models.impl.VicarModel;
import com.solutions.mvc.views.impl.VicarConsoleView;
import com.solutions.mvc.views.impl.DepartConsoleView;
import com.solutions.mvc.controllers.impl.VicarController;
import com.solutions.mvc.controllers.impl.DepartController;
import com.solutions.mvc.events.impl.VicarEvent;



public class Agency extends AbstractEntity {

 private HashMap<String, Depart> agency = new HashMap<String, Depart>();
 private VicarConsoleView vicarConsoleView = new VicarConsoleView();
 private DepartConsoleView departConsoleView = new DepartConsoleView();
 private VicarController vicarController = new VicarController();
 private DepartController departController = new DepartController();

 public Agency(){}

 public void SetDepart (Depart depart){
  agency.put(depart.getName(), depart);
  }

 public void clear() {
        name = "";
		agency.clear();
    }

 public void DeleteDepart (String name){
  agency.remove(name);
  }

 public void ShowDepart (String name){
    Depart depart = agency.get(name);
    if (depart!=null){
     DepartModel departModel = new DepartModel (depart);
	 departController.setModel(departModel);
     departController.setView(departConsoleView);
     departController.handleEvent(DepartEvent.SHOW);
	}
    else {
        System.out.println("FUUUUUUUUUUUU!");
    }
 }

 public Depart ChangeDepart(String name){
    ShowDepart(name);
    Depart depart = agency.get(name);
    if (depart!=null){
     DepartModel departModel = new DepartModel (depart);
	 departController.setModel(departModel);
     departController.setView(departConsoleView);
     departController.handleEvent(DepartEvent.REDACT);
	}
    return depart;
 }

    public void SearchDepart(String O){
            Collection<Depart> field = Values();
            Pattern pat;
            Matcher mat;
            boolean found;
            int x = 0;
            O = O.replace('*', '.');
            O = O.replace("?", ".+");
            System.out.println(O);
            pat = Pattern.compile(O);
            Iterator<Depart> itr = field.iterator();
            Depart Elem = new Depart();
            while (itr.hasNext()) {
                Depart element = itr.next();
                mat = pat.matcher(element.getName());
                found = mat.matches();
                if (found) {
                    ShowDepart(element.getName());
                    x++;
                }
            }

        }

 public Depart CheckDepart(String title) {
        Collection<Depart> dep = Values();
        Iterator<Depart> itr = dep.iterator();
        while (itr.hasNext()) {
            Depart element = itr.next();
            if (element.getName().compareTo(title) == 0) {
               return element;
            }
        }
           Depart element = new Depart();
           element.setName(title);
           SetDepart(element);
           return element;
 }


 public Collection<Depart> Values(){
     return agency.values();
 }


}
