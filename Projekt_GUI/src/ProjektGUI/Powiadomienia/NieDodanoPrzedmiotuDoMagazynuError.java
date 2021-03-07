package ProjektGUI.Powiadomienia;

import javax.swing.*;

public class NieDodanoPrzedmiotuDoMagazynuError extends JDialog {
    public NieDodanoPrzedmiotuDoMagazynuError(){
        JOptionPane.showMessageDialog(this, "Wybierz Magazyn i Przedmiot!", "BŁĄD", JOptionPane.ERROR_MESSAGE);
    }
}
