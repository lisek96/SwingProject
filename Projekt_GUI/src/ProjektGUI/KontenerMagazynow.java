package ProjektGUI;

import java.util.ArrayList;



public class KontenerMagazynow {

    public static ArrayList<Magazyn> lista_magazynów = new ArrayList<>();
    public static int licznikMagazynow=1;
    public static String lokalizacjaNowegoMagazynu;
    public static double powierzchniaNowegomagazynu;


    public static void dodajMagazynDoListy(){
        lista_magazynów.add(new Magazyn(lokalizacjaNowegoMagazynu, powierzchniaNowegomagazynu));
        lokalizacjaNowegoMagazynu ="";
        powierzchniaNowegomagazynu=0;

    }


}
