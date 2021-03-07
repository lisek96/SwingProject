package ProjektGUI;

import ProjektGUI.Powiadomienia.DaneSaJuzWczytaneError;
import ProjektGUI.Powiadomienia.DaneWczytaneInformacja;
import ProjektGUI.Powiadomienia.ZapisUdanyInformacja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuFrame extends JFrame {
    public static JButton dodajMagazynDoBazy;
    public static JButton wyswietlZestawienieMagazynPrzedmioty;
    public static JButton dodajPrzedmiotDoMagazynu;
    public static JButton dodajPrzedmiotDoBazy;
    public static JButton wyswietlWszystkiePrzedmioty;
    public static JButton wyswietlWszystkieMagazyny;
    public static JButton zapiszStanAplikacji;
    public static JButton wczytajStanAplikacji;
    private static boolean daneWczytane = false;


    public MenuFrame(){
        setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.fill = gbc.BOTH;
        gbc.weighty=1;
        gbc.weightx=1;



        wyswietlWszystkiePrzedmioty = new JButton("Wyświetl wszystkie przedmioty");
        wyswietlWszystkiePrzedmioty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new WyswietlPrzedmiotyFrame();
                dispose();
            }
        });
        getContentPane().add(wyswietlWszystkiePrzedmioty, gbc);
        gbc.gridy=1;
        getContentPane().add(new JSeparator(), gbc);

        dodajPrzedmiotDoBazy = new JButton("Dodaj przedmiot do bazy");
        dodajPrzedmiotDoBazy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new DodajPrzedmiotFrame();
                dispose();
            }
        });
        gbc.gridy=2;
        getContentPane().add(dodajPrzedmiotDoBazy,gbc);
        gbc.gridy=3;
        getContentPane().add(new JSeparator(), gbc);
        dodajPrzedmiotDoMagazynu = new JButton("Dodaj przedmiot do magazynu");
        dodajPrzedmiotDoMagazynu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new DodawaniePrzedmiotuDoMagazynuFrame();
                dispose();
            }
        });
        gbc.gridy=4;
        getContentPane().add(dodajPrzedmiotDoMagazynu, gbc);
        gbc.gridy=5;
        getContentPane().add(new JSeparator(), gbc);
        wyswietlZestawienieMagazynPrzedmioty = new JButton("Wyświetl zestawienie Magazyn - Przedmioty");
        dodajMagazynDoBazy = new JButton("Dodaj magazyn");
        gbc.gridy=6;
        getContentPane().add(dodajMagazynDoBazy,gbc);
        gbc.gridy=7;
        getContentPane().add(new JSeparator(), gbc);
        dodajMagazynDoBazy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new DodajMagazynFrame();
                dispose();
            }
        });
        gbc.gridy=8;
        getContentPane().add(wyswietlZestawienieMagazynPrzedmioty, gbc);
        wyswietlZestawienieMagazynPrzedmioty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MagazynPrzedmiotyFrame();
                dispose();
            }
        });
        wyswietlWszystkieMagazyny = new JButton("Wyświetl informacje o magazynach");
        gbc.gridy=9;
        getContentPane().add(new JSeparator(), gbc);
        gbc.gridy=10;
        getContentPane().add(wyswietlWszystkieMagazyny, gbc);
        wyswietlWszystkieMagazyny.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new WyswietlMagazynyFrame();
                dispose();
            }
        });
        zapiszStanAplikacji = new JButton("Zapisz dane");
        gbc.gridy=11;
        getContentPane().add(new JSeparator(), gbc);
        gbc.gridy=12;
        getContentPane().add(zapiszStanAplikacji, gbc);
        zapiszStanAplikacji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Magazyn.zapiszMagazyny();
                    Magazyn.zapiszPrzedmiotyMagazynow();
                    Przedmiot.zapiszPrzedmioty();
                    new ZapisUdanyInformacja();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        wczytajStanAplikacji = new JButton("Wczytaj dane");
        gbc.gridy=13;
        getContentPane().add(new JSeparator(), gbc);
        gbc.gridy=14;
        getContentPane().add(wczytajStanAplikacji, gbc);
        wczytajStanAplikacji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if(!daneWczytane) {
                        Magazyn.wczytajMagazyny();
                        Przedmiot.wczytajPrzedmioty();
                        Magazyn.wczytajPrzedmiotyMagazynow();
                        new DaneWczytaneInformacja();
                        daneWczytane=true;
                    }
                    else new DaneSaJuzWczytaneError();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });






        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(400,400));
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.GRAY);
        setTitle("Menu główne");


    }

}
