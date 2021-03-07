package ProjektGUI.Powiadomienia;

import javax.swing.*;

public class DaneSaJuzWczytaneError extends JDialog {
    public DaneSaJuzWczytaneError() {
        JOptionPane.showMessageDialog(this, "Dane wystarczy wczytać raz", "BŁĄD", JOptionPane.ERROR_MESSAGE);
    }
}
