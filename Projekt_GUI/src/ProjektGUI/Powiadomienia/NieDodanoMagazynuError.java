package ProjektGUI.Powiadomienia;

import javax.swing.*;

public class NieDodanoMagazynuError extends JDialog{
    public NieDodanoMagazynuError(){
        JOptionPane.showMessageDialog(this, "Wprowadź obie wartości zatwierdzając enterem.", "BŁĄD", JOptionPane.ERROR_MESSAGE);
    }
}
