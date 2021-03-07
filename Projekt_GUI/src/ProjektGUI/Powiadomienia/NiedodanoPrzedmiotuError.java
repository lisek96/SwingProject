package ProjektGUI.Powiadomienia;

import javax.swing.*;

public class NiedodanoPrzedmiotuError extends JDialog {
  public NiedodanoPrzedmiotuError(){
        JOptionPane.showMessageDialog(this, "Wprowadź obie wartości zatwierdzając enterem.", "BŁĄD", JOptionPane.ERROR_MESSAGE);
    }
}
