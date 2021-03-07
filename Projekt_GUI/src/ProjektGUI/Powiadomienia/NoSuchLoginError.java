package ProjektGUI.Powiadomienia;

import javax.swing.*;

public class NoSuchLoginError extends JDialog {
    public NoSuchLoginError(){
        JOptionPane.showMessageDialog(this, "Niepoprawny login", "BŁĄD", JOptionPane.ERROR_MESSAGE);
    }
}
