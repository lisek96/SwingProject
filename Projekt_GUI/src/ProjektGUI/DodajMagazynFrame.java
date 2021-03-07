package ProjektGUI;

import ProjektGUI.Powiadomienia.DodanoNowyMagazynInformacja;
import ProjektGUI.Powiadomienia.NieDodanoMagazynuError;
import ProjektGUI.keyListeners.DodajKeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajMagazynFrame extends JFrame {
    public static JTextField powierzchnia;
    public static JTextField lokalizacja;
    JLabel powierzchniaLabel;
    JLabel lokalizacjaLabel;
    JButton dodajButton;
    JButton cofnijDoMenuButton;

    DodajMagazynFrame(){

        setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();

        powierzchniaLabel = new JLabel( " powierzchnia: ");
        lokalizacjaLabel = new JLabel("lokalizacja: ");
        powierzchnia = new JTextField("Wprowadź dostępną powierzchnię w m^2");
        lokalizacja = new JTextField("Wprowadź informacje o lokalizacji");
        powierzchnia.setPreferredSize(new Dimension(250, 20));
        lokalizacja.setPreferredSize(new Dimension(250, 20));
        dodajButton = new JButton("Dodaj magazyn");
        cofnijDoMenuButton = new JButton("MENU");
        cofnijDoMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MenuFrame();
                dispose();
            }
        });
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!lokalizacja.isEditable() && !powierzchnia.isEditable()) {
                    dispose();
                    new MenuFrame();
                    new DodanoNowyMagazynInformacja();
                    KontenerMagazynow.lista_magazynów.add(new Magazyn(lokalizacja.getText(), Double.parseDouble(powierzchnia.getText())));
                }
                else new NieDodanoMagazynuError();
            }
        });



        add(lokalizacjaLabel);
        gbc.gridx=1;
        add(lokalizacja);
        gbc.gridx=2;
        add(powierzchniaLabel);
        gbc.gridx=3;
        add(powierzchnia);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=2;
        gbc.fill=gbc.HORIZONTAL;
        add(dodajButton, gbc);
        gbc.gridx=2;
        add(cofnijDoMenuButton, gbc);




        powierzchnia.addKeyListener(new DodajKeyListener());
        lokalizacja.addKeyListener(new DodajKeyListener());
        powierzchnia.setEditable(false);

        setTitle("Dodawanie Magazynu");
        setSize(new Dimension(800, 200));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    static public boolean czyLiczba(){
        return false;
    }

    static public void bledneWprowadzenie(){

    }
}
