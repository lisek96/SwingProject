package ProjektGUI;

import ProjektGUI.Powiadomienia.DodanoPrzedmiotDoMagazynuInformacja;
import ProjektGUI.Powiadomienia.NieDodanoPrzedmiotuDoMagazynuError;
import ProjektGUI.Powiadomienia.NiedodanoPrzedmiotuError;
import ProjektGUI.Powiadomienia.ZaMaloDostepnegoMiejscaError;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodawaniePrzedmiotuDoMagazynuFrame extends JFrame {

    public static JList<Magazyn> listaMagazynów;
    public static JList<Przedmiot> listaPrzedmiotów;
    public static DefaultListModel<Magazyn> modelListyMagazynów;
    public static DefaultListModel<Przedmiot> modelListyPrzedmiotów;
    public static JTextField wybranyMagazyn;
    public static JTextField wybranyPrzedmiot;
    public static JLabel etykietaListyMagazynow;
    public static JLabel etykietaWybranyMagazyn;
    public static JLabel etykietaListyPrzedmiotow;
    public static JLabel etykietaWybranyPrzedmiot;
    public static JButton zatwierdzButton;
    public static JButton menu;
    boolean przedmiotWybrany=false;
    boolean magazynWybrany=false;



    public DodawaniePrzedmiotuDoMagazynuFrame(){
        setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();

        menu = new JButton("Powrót do MENU");
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MenuFrame();
                magazynWybrany=false;
                przedmiotWybrany=false;
                dispose();
            }
        });
        zatwierdzButton = new JButton("Dodaj przedmiot");
        zatwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(magazynWybrany&&przedmiotWybrany) {
                    if(listaMagazynów.getSelectedValue().pozostalaPowierzchnia >= listaPrzedmiotów.getSelectedValue().powierzchnia) {
                        listaMagazynów.getSelectedValue().dodajPrzedmiot(listaPrzedmiotów.getSelectedValue());
                        new DodawaniePrzedmiotuDoMagazynuFrame();
                        dispose();
                        new DodanoPrzedmiotDoMagazynuInformacja();
                    }
                    else new ZaMaloDostepnegoMiejscaError();

                }
                else new NieDodanoPrzedmiotuDoMagazynuError();
            }
        });
        wybranyPrzedmiot = new JTextField("Wybrany przedmiot...");
        wybranyPrzedmiot.setEditable(false);
        wybranyMagazyn = new JTextField("Wybrany magazyn...");
        wybranyMagazyn.setEditable(false);
        etykietaListyMagazynow = new JLabel(" Dostępne magazyny: ");
        etykietaWybranyMagazyn = new JLabel(" Wybrany magazyn: ");
        etykietaListyPrzedmiotow = new JLabel(" Dostepne przedmioty: ");
        etykietaWybranyPrzedmiot = new JLabel( " Wybrany przedmiot: ");
        Border defaultBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        etykietaListyMagazynow.setBorder(defaultBorder);
        etykietaWybranyMagazyn.setBorder(defaultBorder);
        etykietaWybranyPrzedmiot.setBorder(defaultBorder);
        etykietaListyPrzedmiotow.setBorder(defaultBorder);

        modelListyMagazynów = new DefaultListModel<>();
        modelListyMagazynów.addAll(KontenerMagazynow.lista_magazynów);
        modelListyPrzedmiotów = new DefaultListModel<>();
        modelListyPrzedmiotów.addAll(KontenerPrzedmiotow.lista_przedmiotow);
        listaPrzedmiotów = new JList<>(modelListyPrzedmiotów);
        listaPrzedmiotów.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaPrzedmiotów.setLayoutOrientation(JList.VERTICAL);
        listaPrzedmiotów.setVisibleRowCount(8);
        listaMagazynów = new JList<>(modelListyMagazynów);
        listaMagazynów.setLayoutOrientation(JList.VERTICAL);
        listaMagazynów.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaMagazynów.setVisibleRowCount(8);
        listaMagazynów.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                    listaMagazynowWybor();
            }
        });
        listaPrzedmiotów.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                listaPrzedmiotowWybor();
            }
        });

        gbc.weightx=1;
        gbc.weighty=1;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill = gbc.BOTH;
        listaMagazynów.setFixedCellHeight(20);
        listaPrzedmiotów.setFixedCellHeight(20);
        listaMagazynów.setFixedCellWidth(200);
        listaPrzedmiotów.setFixedCellWidth(200);
        getContentPane().add(etykietaListyMagazynow, gbc);
        gbc.gridy=1;
        gbc.gridheight=2;
        getContentPane().add(new JScrollPane(listaMagazynów), gbc);
        gbc.gridheight=1;

        gbc.gridy=3;
        getContentPane().add(wybranyMagazyn, gbc);
        gbc.gridy=0;
        gbc.gridx=1;
        getContentPane().add(etykietaListyPrzedmiotow, gbc);
        gbc.gridy=1;
        gbc.gridheight=2;
        getContentPane().add(new JScrollPane(listaPrzedmiotów), gbc);
        gbc.gridheight=1;
        gbc.gridy=3;
        getContentPane().add(wybranyPrzedmiot, gbc);
        gbc.gridx=0;
        gbc.gridwidth=2;
        gbc.gridy=4;
        getContentPane().add(zatwierdzButton, gbc);
        gbc.gridy=5;
        getContentPane().add(menu, gbc);



        setVisible(true);
        setSize(new Dimension(800,400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Dodawanie przedmiotu do magazynu");
        setLocationRelativeTo(null);
        setResizable(false);

    }

    private void listaMagazynowWybor(){
        magazynWybrany=true;
        wybranyMagazyn.setText(listaMagazynów.getSelectedValue().toString());
    }
    private void listaPrzedmiotowWybor() {
        przedmiotWybrany=true;
        wybranyPrzedmiot.setText(listaPrzedmiotów.getSelectedValue().toString());}
}
