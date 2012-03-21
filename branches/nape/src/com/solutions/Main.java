package com.solutions.mvc;

import com.solutions.mvc.XML.XML;
import com.solutions.mvc.controllers.impl.AgencyController;
import com.solutions.mvc.controllers.impl.OfficeController;
import com.solutions.mvc.entities.impl.Agency;
import com.solutions.mvc.entities.impl.Office;
import com.solutions.mvc.events.impl.AgencyEvent;
import com.solutions.mvc.events.impl.OfficeEvent;
import com.solutions.mvc.models.impl.AgencyModel;
import com.solutions.mvc.models.impl.OfficeModel;
import com.solutions.mvc.views.impl.AgencyConsoleView;
import com.solutions.mvc.views.impl.OfficeConsoleView;

public class Main {
    public static void main(String[] arguments) throws Exception {
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
                officeController.handleEvent(OfficeEvent.SEARCH);
                officeController.handleEvent(OfficeEvent.FILL);
                officeController.handleEvent(OfficeEvent.FILL);
                agencyController.handleEvent(AgencyEvent.FILL);
                //agencyController.handleEvent(AgencyEvent.SEARCH);
                //agencyController.handleEvent(AgencyEvent.FILL);

                officeController.handleEvent(OfficeEvent.SHOW);
                officeController.handleEvent(OfficeEvent.SEARCH);
                officeController.handleEvent(OfficeEvent.SEARCH);
                officeController.handleEvent(OfficeEvent.SEARCH);
                agencyController.handleEvent(AgencyEvent.SHOW);
                agencyController.handleEvent(AgencyEvent.REDACT);
                agencyController.handleEvent(AgencyEvent.SHOW);
                XML.XML_Save(office, "save.xml");


            }
        }
    }
}
