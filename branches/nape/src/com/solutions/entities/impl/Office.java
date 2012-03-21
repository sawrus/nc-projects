package com.solutions.mvc.entities.impl;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.solutions.mvc.entities.AbstractEntity;
import com.solutions.mvc.entities.impl.Vicar;
import com.solutions.mvc.models.impl.DepartModel;
import com.solutions.mvc.models.impl.VicarModel;
import com.solutions.mvc.views.impl.VicarConsoleView;
import com.solutions.mvc.views.impl.DepartConsoleView;
import com.solutions.mvc.controllers.impl.VicarController;
import com.solutions.mvc.controllers.impl.DepartController;
import com.solutions.mvc.events.impl.VicarEvent;



public class Office extends AbstractEntity {

 private HashMap<String, Vicar> office = new HashMap<String, Vicar>();
 private VicarConsoleView vicarConsoleView = new VicarConsoleView();
 private DepartConsoleView departConsoleView = new DepartConsoleView();
 private VicarController vicarController = new VicarController();
 private DepartController departController = new DepartController();

 public Office(){}
 
 public void SetVicar (Vicar vicar){
  office.put(vicar.getName(),vicar);
  }

 public void clear() {
        name = "";
		office.clear();
    }

 public void DeleteVicar (String name){
  office.remove(name);
  }
  
 public void ShowVicar (String name){
    Vicar vicar = new Vicar();
    vicar = office.get(name);
    if (vicar!=null){
     DepartModel departModel = new DepartModel (vicar.getDepart());
     VicarModel vicarModel = new VicarModel (vicar, departModel);
     vicarController.setModel(vicarModel);
     vicarController.setView(vicarConsoleView);
	 departController.setModel(departModel);
     departController.setView(departConsoleView);
     vicarController.handleEvent(VicarEvent.SHOW);
	}
 }

 public Vicar ChangeVicar(String name){
    ShowVicar(name);
    Vicar vicar = new Vicar();
    vicar = office.get(name);
    if (vicar!=null){
     DepartModel departModel = new DepartModel (vicar.getDepart());
     VicarModel vicarModel = new VicarModel (vicar, departModel);
     vicarController.setModel(vicarModel);
     vicarController.setView(vicarConsoleView);
	 departController.setModel(departModel);
     departController.setView(departConsoleView);
     vicarController.handleEvent(VicarEvent.REDACT);
	}
    return vicar;
 }

 public void SearchVicar(String O){
        Collection<Vicar> field = Values();
        Pattern pat;
        Matcher mat;
        boolean found;
        int x = 0;
        O = O.replace('*', '.');
        O = O.replace("?", ".+");
        System.out.println(O);
        pat = Pattern.compile(O);
        Iterator<Vicar> itr = field.iterator();
        Vicar Elem = new Vicar();
        while (itr.hasNext()) {
            Vicar element = itr.next();
            mat = pat.matcher(element.getName());
            found = mat.matches();
            if (found) {
                ShowVicar(element.getName());
                x++;
            }
        }

    }


 public Collection<Vicar> Values(){
     return office.values();
 }


}
 