package ProjektGUI.TableModels;

import ProjektGUI.KontenerMagazynow;

import javax.swing.table.AbstractTableModel;

public class PrzedmiotyMagazynTableModel extends AbstractTableModel {
    String[] columnNames = {"Magazyn", "Kody przedmiotów w Magazynie"};
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

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public Object[][] getData(){

        int iloscMagazynow = KontenerMagazynow.lista_magazynów.size();
        Object[][] data = new Object[iloscMagazynow][2];

        StringBuilder[] przedmioty_w_magazynach = new StringBuilder[iloscMagazynow];

        for(int i=0; i<iloscMagazynow; i++){
            przedmioty_w_magazynach[i] = new StringBuilder();
            for(int j = 0; j< KontenerMagazynow.lista_magazynów.get(i).listaPrzedmiotow.size(); j++){
                przedmioty_w_magazynach[i].append(KontenerMagazynow.lista_magazynów.get(i).listaPrzedmiotow.get(j).kodPrzedmiotu + "; ");
            }
        }

        for(int i=0; i<iloscMagazynow; i++){
            data[i] = new Object[]{"ID: " + KontenerMagazynow.lista_magazynów.get(i).ID_magazynu + "; lokalizacja: " +
                    KontenerMagazynow.lista_magazynów.get(i).lokalizacja + "; pozostala powierzchnia: " + KontenerMagazynow.lista_magazynów.get(i).pozostalaPowierzchnia
                    , przedmioty_w_magazynach[i]};
        }


        return data;
    }

}
