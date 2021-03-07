package ProjektGUI.Powiadomienia;

import javax.swing.*;

public class PowierzchaniaError extends JDialog {
    public PowierzchaniaError(){
        JOptionPane.showMessageDialog(this, "Wprowadź wartość liczbową!", "BŁĄD", JOptionPane.ERROR_MESSAGE);
    }
}
