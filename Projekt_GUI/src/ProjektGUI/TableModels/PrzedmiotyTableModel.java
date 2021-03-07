package ProjektGUI.TableModels;

import ProjektGUI.KontenerPrzedmiotow;

import javax.swing.table.AbstractTableModel;

public class PrzedmiotyTableModel extends AbstractTableModel {
    String[] columnNames = {"Kod", "M^2", "Nazwa", "Opis"};
    Object[][] data = getData();

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col){
        return columnNames[col];
    }
    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }




    public Object[][] getData(){
        int iloscWpisow = KontenerPrzedmiotow.lista_przedmiotow.size();

        Object[][] data = new Object[iloscWpisow][4];

        for(int i=0; i<iloscWpisow; i++){
            data[i] = new Object[]{KontenerPrzedmiotow.lista_przedmiotow.get(i).kodPrzedmiotu,
                                    Double.toString(KontenerPrzedmiotow.lista_przedmiotow.get(i).powierzchnia),
                                    KontenerPrzedmiotow.lista_przedmiotow.get(i).nazwa,
                                    KontenerPrzedmiotow.lista_przedmiotow.get(i).opis
            };
        }
    return data;
    }

    }

