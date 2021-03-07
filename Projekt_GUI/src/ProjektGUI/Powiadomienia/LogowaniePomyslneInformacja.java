package ProjektGUI.Powiadomienia;

import javax.swing.*;

public class LogowaniePomyslneInformacja extends JDialog {
    public LogowaniePomyslneInformacja(){
        JOptionPane.showMessageDialog(this, "Zalogowano pomyślnie", "SUKCES", JOptionPane.INFORMATION_MESSAGE);
    }
}
