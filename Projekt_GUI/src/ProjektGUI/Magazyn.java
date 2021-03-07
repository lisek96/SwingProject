package ProjektGUI;

import java.io.*;
import java.util.ArrayList;

public class Magazyn {
    public String lokalizacja;
    public double powierzchnia;
    public ArrayList<Przedmiot> listaPrzedmiotow;
    public int ID_magazynu;
    public double pozostalaPowierzchnia;

    Magazyn(String lokalizacja, double powierzchnia){
        this.lokalizacja=lokalizacja;
        this.powierzchnia=powierzchnia;
        listaPrzedmiotow = new ArrayList<>();
        this.ID_magazynu = KontenerMagazynow.licznikMagazynow++;
        pozostalaPowierzchnia=powierzchnia;
    }

    public String toString(){
        return "ID: " + ID_magazynu + "; " + "dostp. miejsce: " + pozostalaPowierzchnia + "m^2; lok: " + lokalizacja;
    }

    public void dodajPrzedmiot(Przedmiot przedmiot){
        if(pozostalaPowierzchnia>=przedmiot.powierzchnia){
            pozostalaPowierzchnia-=przedmiot.powierzchnia;
            listaPrzedmiotow.add(przedmiot);
        }
    }

    static public void zapiszMagazyny() throws IOException {
        File file = new File("Magazyny");
        var writer = new FileWriter(file);

        String lokalizacja;
        String powierzchnia;

        for(Magazyn m : KontenerMagazynow.lista_magazynów){
            StringBuilder daneMagazynu = new StringBuilder();
            lokalizacja = m.lokalizacja;
            powierzchnia = Double.toString(m.powierzchnia);
            daneMagazynu.append(lokalizacja + "|" + powierzchnia);
            writer.write(daneMagazynu + "\n");
        }

        writer.close();
    }

    static public void wczytajMagazyny() throws IOException {
        FileReader fileReader = new FileReader("Projekt_GUI/data/Magazyny");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        while((line=bufferedReader.readLine())!=null){
            String[] dane = line.split("[|]");
            KontenerMagazynow.lista_magazynów.add(new Magazyn(dane[0], Double.parseDouble(dane[1])));
        }
    }




    private void dodajPrzedmioty(String [] id_przedmiotow){

        for(int i=0; i<id_przedmiotow.length; i++){
            Przedmiot przedmiot = null;
            for(Przedmiot p : KontenerPrzedmiotow.lista_przedmiotow){
                if(p.kodPrzedmiotu.equals(id_przedmiotow[i])) {
                    przedmiot = p;
                    break;
                }
            }
            dodajPrzedmiot(przedmiot);
        }
    }

    static public void zapiszPrzedmiotyMagazynow() throws IOException {
        File file = new File("PM.txt");
        FileWriter writer = new FileWriter(file);

        for(Magazyn m : KontenerMagazynow.lista_magazynów){
            StringBuilder przedmioty = new StringBuilder();
            for(Przedmiot p : m.listaPrzedmiotow){
                przedmioty.append(p.kodPrzedmiotu + "|");
            }
            writer.write(przedmioty + "\n");
        }

        writer.close();
    }

    static public void wczytajPrzedmiotyMagazynow() throws IOException {
        FileReader fileReader = new FileReader("Projekt_GUI/data/PM.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        int ktoryMagazyn = 0;

        while((line=bufferedReader.readLine())!=null){
            String[] przedmioty = line.split("[|]");

            if(!(line.length()==0))KontenerMagazynow.lista_magazynów.get(ktoryMagazyn).dodajPrzedmioty(przedmioty);
            ktoryMagazyn++;

        }

    }
}
