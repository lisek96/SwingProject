package ProjektGUI;

import ProjektGUI.Powiadomienia.DodanoPrzedmiotInformacja;
import ProjektGUI.Powiadomienia.PowierzchaniaError;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajPrzedmiotFrame extends JFrame implements czyLiczba{
    JTextField powierzchnia;
    JTextField nazwa;
    JTextField opis;
    JLabel etykieta_powierzchnia;
    JLabel etykieta_nazwa;
    JLabel etykieta_opis;
    JButton dodajPrzedmiot;
    JButton menu;
    JPanel buttonPane;
    JPanel textFieldsPane;

    DodajPrzedmiotFrame(){
        setLayout(new BorderLayout());
        var gbc = new GridBagConstraints();
        textFieldsPane = new JPanel();
        textFieldsPane.setLayout(new GridBagLayout());
        buttonPane = new JPanel();
        buttonPane.setLayout(new GridBagLayout());
        powierzchnia = new JTextField("Wprowadź powierzchnie...");
        nazwa = new JTextField("Wprowadź nazwę...");
        opis = new JTextField("Wprowadź opis...");
        etykieta_nazwa = new JLabel("Nazwa: ");
        etykieta_opis = new JLabel("Opis: ");
        etykieta_powierzchnia = new JLabel(" Powierzchnia: ");
        dodajPrzedmiot = new JButton("Dodaj przedmiot");
        menu = new JButton("Wroć do MENU");
        JSeparator separator = new JSeparator();
        JSeparator separator2 = new JSeparator();
        JSeparator separator3 = new JSeparator();

        separator.setPreferredSize(new Dimension(200, 20));
        separator2.setPreferredSize(new Dimension(200, 20));
        separator3.setPreferredSize(new Dimension(200, 20));
        nazwa.setPreferredSize(new Dimension(200, 20));
        powierzchnia.setPreferredSize((new Dimension(200, 20)));
        opis.setPreferredSize(new Dimension(200, 20));

        menu.addActionListener((e)->{
            new MenuFrame();
            dispose();
        });

        dodajPrzedmiot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(czyLiczba(powierzchnia.getText())) {
                    KontenerPrzedmiotow.lista_przedmiotow.add(new Przedmiot(Integer.parseInt(powierzchnia.getText()), nazwa.getText(), opis.getText()));
                    new DodanoPrzedmiotInformacja();
                }
                else new PowierzchaniaError();
            }
        });



        gbc.gridx=0;
        gbc.gridy=0;
        textFieldsPane.add(etykieta_powierzchnia, gbc);
        gbc.gridy=1;
        textFieldsPane.add(separator, gbc);
        gbc.gridy=2;
        textFieldsPane.add(etykieta_nazwa, gbc);
        gbc.gridy=3;
        textFieldsPane.add(separator, gbc);
        gbc.gridy=4;
        textFieldsPane.add(etykieta_opis, gbc);

        gbc.gridy=0;
        gbc.gridx=1;
        textFieldsPane.add(powierzchnia,gbc);
        gbc.gridy=1;
        textFieldsPane.add(separator, gbc);
        gbc.gridy=2;
        textFieldsPane.add(nazwa,gbc);
        gbc.gridy=3;
        textFieldsPane.add(separator2, gbc);
        gbc.gridy=4;
        textFieldsPane.add(opis,gbc);
        gbc.gridy=5;
        textFieldsPane.add(separator3, gbc);

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weighty=1;
        gbc.weightx=1;
        gbc.fill = gbc.BOTH;
        buttonPane.add(menu, gbc);
        gbc.gridy=1;
        buttonPane.add(dodajPrzedmiot, gbc);
        getContentPane().add(textFieldsPane, BorderLayout.PAGE_START);
        getContentPane().add(buttonPane, BorderLayout.CENTER);



        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Dodawanie przedmiotu");
        setSize(new Dimension(400,250));
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
