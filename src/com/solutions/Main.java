package com.solutions;

import com.solutions.XML.XML;
import com.solutions.controllers.impl.AgencyController;
import com.solutions.controllers.impl.OfficeController;
import com.solutions.entities.impl.Agency;
import com.solutions.entities.impl.Office;
import com.solutions.events.impl.AgencyEvent;
import com.solutions.events.impl.OfficeEvent;
import com.solutions.models.impl.AgencyModel;
import com.solutions.models.impl.OfficeModel;
import com.solutions.views.ConsoleRead;
import com.solutions.views.IRead;
import com.solutions.views.impl.AgencyConsoleView;
import com.solutions.views.impl.OfficeConsoleView;

public class Main {


    public static void main(String[] arguments) throws Exception {

        IRead iread = new ConsoleRead();

        //entities
        Office office = new Office();
        Agency agency = new Agency();

        //models
        AgencyModel agencyModel = new AgencyModel(agency);
        OfficeModel officeModel = new OfficeModel(office, agencyModel);

        //views
        OfficeConsoleView officeConsoleView = new OfficeConsoleView();
        AgencyConsoleView agencyConsoleView = new AgencyConsoleView();

        //controllers
        {
            OfficeController officeController = new OfficeController();
            officeController.setModel(officeModel);
            officeController.setView(officeConsoleView);

            AgencyController agencyController = new AgencyController();
            agencyController.setModel(agencyModel);
            agencyController.setView(agencyConsoleView);

            //handle events and internal manage slave objects type of { 'Model', 'View' }
            {
                XML.XML_Load(office, agency, "save.xml");
                String Y;
                int l = 0;
                while (true) {
                    System.out.println("What you want?");
                    System.out.println("1) fill vicar");
                    System.out.println("2) show vicar");
                    System.out.println("3) redact vicar");
                    System.out.println("4) search vicar");
                    System.out.println("5) delete vicar");
                    System.out.println("6) fill depart");
                    System.out.println("7) show depart");
                    System.out.println("8) redact depart");
                    System.out.println("9) search depart");
                    System.out.println("10) delete depart");
                    System.out.println("11) save&exit");
                    System.out.println("12) exit");
                    l = 0;
                    Y = iread.readParameter("?");
                    l = Integer.valueOf(Y);
                    if (l == 1) {
                        officeController.handleEvent(OfficeEvent.FILL);
                        continue;
                    }
                    if (l == 2) {
                        officeController.handleEvent(OfficeEvent.SHOW);
                        continue;
                    }
                    if (l == 3) {
                        officeController.handleEvent(OfficeEvent.REDACT);
                        continue;
                    }
                    if (l == 4) {
                        officeController.handleEvent(OfficeEvent.SEARCH);
                        continue;
                    }
                    if (l == 5) {
                        officeController.handleEvent(OfficeEvent.DELETE);
                        continue;
                    }
                    if (l == 6) {
                        agencyController.handleEvent(AgencyEvent.FILL);
                        continue;
                    }
                    if (l == 7) {
                        agencyController.handleEvent(AgencyEvent.SHOW);
                        continue;
                    }
                    if (l == 8) {
                        agencyController.handleEvent(AgencyEvent.REDACT);
                        continue;
                    }
                    if (l == 9) {
                        agencyController.handleEvent(AgencyEvent.SEARCH);
                        continue;
                    }
                    if (l == 10) {
                        agencyController.handleEvent(AgencyEvent.DELETE);
                        continue;
                    }
                    if (l == 11) {
                        XML.XML_Save(office, "save.xml");
                        break;
                    }
                    if (l == 12) {
                        break;
                    }
                }


            }
        }
    }
}
