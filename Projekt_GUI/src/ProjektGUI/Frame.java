package ProjektGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    JButton dodajMagazyn;
    JButton removeButton;
    JButton XDbutton;
    GridBagConstraints gbc;

    Frame(){


        dodajMagazyn = new JButton("Dodaj Magazyn");

        dodajMagazyn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        setLayout(new GridBagLayout());




        removeButton.addActionListener((e)->{
            getContentPane().remove(removeButton);
            repaint();
        });

        removeButton.addActionListener((e)->removeB());

        setSize(new Dimension(800, 600));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addB(){
        this.add(XDbutton, gbc);
    }

    public void removeB(){

                remove(XDbutton);
    }
}
