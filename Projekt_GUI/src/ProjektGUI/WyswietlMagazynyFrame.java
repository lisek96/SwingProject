package ProjektGUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WyswietlMagazynyFrame extends JFrame {
    JList<Magazyn> magazyny;

    DefaultListModel<Magazyn> magazynyListModel;
    JButton menuButton;
    PoziomZaplenieniaComponent poziomZaplenieniaComponent;


    WyswietlMagazynyFrame(){




        setLayout(new BorderLayout());
        menuButton = new JButton("MENU");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MenuFrame();
                dispose();
            }
        });
        magazynyListModel = new DefaultListModel<>();
        magazynyListModel.addAll(KontenerMagazynow.lista_magazynów);
        magazyny = new JList<>(magazynyListModel);

        magazyny.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        magazyny.setVisibleRowCount(1);
        magazyny.setLayoutOrientation(JList.VERTICAL);




        getContentPane().add(magazyny, BorderLayout.WEST);
        getContentPane().add(new JScrollPane(magazyny));

        magazyny.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                    akcjaListy();
            }
        });

        poziomZaplenieniaComponent = new PoziomZaplenieniaComponent(KontenerMagazynow.lista_magazynów.get(0));
        add(poziomZaplenieniaComponent, BorderLayout.EAST);
        getContentPane().add(menuButton, BorderLayout.PAGE_END);
        setSize(new Dimension(400, 200));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Informacje o magazynie");
        magazyny.setToolTipText("Wybierz magazyn, aby zobaczyć jego zapełnienie");
    }

    public void akcjaListy(){
        poziomZaplenieniaComponent.magazyn = magazyny.getSelectedValue();
        repaint();
    }
}
