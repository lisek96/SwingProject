package ProjektGUI;

import ProjektGUI.TableModels.PrzedmiotyTableModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WyswietlPrzedmiotyFrame extends JFrame {

    JButton menu;

    WyswietlPrzedmiotyFrame(){

        setLayout(new BorderLayout());
        var gbc = new GridBagConstraints();

        menu = new JButton("MENU");
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MenuFrame();
                dispose();
            }
        });
        JTable tabela = new JTable(new PrzedmiotyTableModel());

        TableColumn column = null;

        column=tabela.getColumnModel().getColumn(3);
        column.setPreferredWidth(200);
        column=tabela.getColumnModel().getColumn(0);
        column.setPreferredWidth(30);
        column=tabela.getColumnModel().getColumn(1);
        column.setPreferredWidth(30);
        column=tabela.getColumnModel().getColumn(2);
        column.setPreferredWidth(150);

        getContentPane().add(tabela,BorderLayout.PAGE_START);
        JScrollPane tabelaScroll = new JScrollPane(tabela);
        tabelaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(tabelaScroll);
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new GridBagLayout());
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill=gbc.BOTH;
        JSeparator separator = new JSeparator();
        buttonPane.setBackground(Color.CYAN);
        buttonPane.setForeground(Color.CYAN);
        separator.setPreferredSize(new Dimension(100, 50));
        buttonPane.add(separator, gbc);
        gbc.gridy=1;
        buttonPane.add(menu, gbc);
        getContentPane().add(buttonPane, BorderLayout.PAGE_END);


        setVisible(true);
        setSize(new Dimension(600,400));
        setTitle("Tabela przedmiotów");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        setLocationRelativeTo(null);
    }
}
