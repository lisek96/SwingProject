package ProjektGUI;

import ProjektGUI.Powiadomienia.NoSuchLoginError;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Uzytkownik {
    String login;
    char[] haslo;
    String hasloString;
    public static ArrayList<Uzytkownik> listaUzytkownikow = new ArrayList<>();

    Uzytkownik(String login, String haslo){
        this.login=login;
        this.haslo=haslo.toCharArray();
        this.hasloString=haslo;
    }

    public static Uzytkownik sprawdzCzyLoginIstnieje(String login) {
        char[] haslo = null;
        for (Uzytkownik user : listaUzytkownikow) {
            if (user.login.equals(login)) return user;
        }

        return null;
    }

    public static boolean sprawdzHaslo(char[] haslo, Uzytkownik user){
        if(haslo.length != user.haslo.length) return false;

        for(int i=0; i<haslo.length; i++){
            if(!(haslo[i] == user.haslo[i])) return false;
        }

        return true;
    }

    static public void zapiszUzytkownikow() throws IOException {
        FileWriter writer = new FileWriter("Users");
        String login;
        String haslo;

        for(Uzytkownik user : listaUzytkownikow){
            StringBuilder daneUzytkownika = new StringBuilder();
            login = user.login;
            haslo = user.hasloString;
            daneUzytkownika.append(login + "|" + haslo);
            writer.write(daneUzytkownika + "\n");
        }

        writer.close();
    }

    static public void wczytajUzytkownikow() throws IOException {
        FileReader reader = new FileReader("Projekt_GUI/data/users");
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;

        while((line=bufferedReader.readLine())!=null){
            String[] daneUzytkownika = line.split("[|]");
            listaUzytkownikow.add(new Uzytkownik(daneUzytkownika[0], daneUzytkownika[1]));
        }


    }



    }



