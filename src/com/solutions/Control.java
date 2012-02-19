import java.lang.*;
import java.beans.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

import Depart.*;
import Vicar.*;
import XMLSer.*;
import ModelVicar.*;
import ModelDepart.*;
import VDView.*;

public class Control {

    public static void main(String[] args) throws Exception {
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        int j = 6;
        while (j != 5) {
            VDView.Menu(0);
            j = Integer.valueOf(BR.readLine());
            switch (j) {
                case (1):
                    ModelVicar.RedactVicar();
                    break;
                case (2):
                    ModelDepart.RedactDepart();
                    break;
                case (3):
                    int k = 0;
                    ModelVicar.VLoad();
                    while (true) {
                        VDView.Menu(1);
                        k = Integer.valueOf(BR.readLine());
                        if (k == 1) {
                            ModelVicar.SearchingFIO(BR.readLine());
                        }
                        if (k == 2) {
                            ModelVicar.SearchingPhone(BR.readLine());
                        }
                        if (k == 3) {
                            ModelVicar.SearchingDepart(BR.readLine());
                        }
                        if (k == 4) {
                            break;
                        }
                    }
                    ModelVicar.VSave();
                    break;
                case (4):
                    int m = 0;
                    ModelDepart.DLoad();
                    while (true) {
                        VDView.Menu(2);
                        m = Integer.valueOf(BR.readLine());
                        if (m == 1) {
                            ModelDepart.SearchingTitle(BR.readLine());
                        }
                        if (m == 2) {
                            ModelDepart.SearchingChief(BR.readLine());
                        }
                        if (m == 3) {
                            break;
                        }
                    }
                    ModelDepart.DSave();
                    break;
                case (5):
                    break;
                default:
                    System.out.println("INPUT ERROR");
                    break;
            }
        }
    }

}
	  