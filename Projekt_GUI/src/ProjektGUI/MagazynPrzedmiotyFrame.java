package ProjektGUI;

import ProjektGUI.TableModels.PrzedmiotyMagazynTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MagazynPrzedmiotyFrame extends JFrame {
    private static JButton menu;

    MagazynPrzedmiotyFrame(){
        menu = new JButton("MENU");
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MenuFrame();
                dispose();
            }
        });
        JTable tabela = new JTable(new PrzedmiotyMagazynTableModel());



        setLayout(new BorderLayout());
        getContentPane().add(tabela.getTableHeader(), BorderLayout.PAGE_START);
        getContentPane().add(tabela, BorderLayout.CENTER);
        getContentPane().add(menu, BorderLayout.PAGE_END);

        setVisible(true);
        setSize(new Dimension(800,300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Zestawienie przedmiotów w poszczególnych magazynach");
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
