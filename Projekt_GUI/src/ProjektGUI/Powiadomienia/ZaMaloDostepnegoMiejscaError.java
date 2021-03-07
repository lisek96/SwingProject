package ProjektGUI.Powiadomienia;

import javax.swing.*;

public class ZaMaloDostepnegoMiejscaError extends JDialog {
    public ZaMaloDostepnegoMiejscaError() {
        JOptionPane.showMessageDialog(this, "Za malo miejsca, żeby dodać ten przedmiot", "BŁĄD", JOptionPane.ERROR_MESSAGE);
    }
}
