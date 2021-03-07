package ProjektGUI;

import java.io.*;

public class Przedmiot {
    public double powierzchnia;
    public String nazwa;
    public String opis;
    public String kodPrzedmiotu;

    Przedmiot(double powierzchnia, String nazwa, String opis){
        this.powierzchnia=powierzchnia;
        this.nazwa=nazwa;
        this.opis=opis;
        kodPrzedmiotu = "PL_P" + KontenerPrzedmiotow.licznikPrzedmiotow++;
    }

    public String toString(){
        return "kod: " + kodPrzedmiotu + "; nazwa: " + nazwa + "; powierzchnia: " + powierzchnia;
    }


    static public void zapiszPrzedmioty() throws IOException {
        FileWriter writer = new FileWriter("Przedmioty");
        String powierzchnia;
        String nazwa;
        String opis;

        for(Przedmiot p : KontenerPrzedmiotow.lista_przedmiotow){
            StringBuilder danePrzedmiotu = new StringBuilder();
            powierzchnia = Double.toString(p.powierzchnia);
            nazwa = p.nazwa;
            opis = p.opis;
            danePrzedmiotu.append(powierzchnia + "|" + nazwa + "|" + opis);
            writer.write(danePrzedmiotu + "\n");
        }

        writer.close();
    }

    static public void wczytajPrzedmioty() throws IOException {
        FileReader fileReader = new FileReader("Projekt_GUI/data/Przedmioty");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        while((line=bufferedReader.readLine())!=null){
            String[] danePrzedmiotu = line.split("[|]");
            KontenerPrzedmiotow.lista_przedmiotow.add(new Przedmiot(Double.parseDouble(danePrzedmiotu[0]), danePrzedmiotu[1], danePrzedmiotu[2]));
        }
    }
}
