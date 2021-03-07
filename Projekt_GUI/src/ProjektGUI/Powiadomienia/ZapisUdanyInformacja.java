package ProjektGUI.Powiadomienia;

import com.sun.jdi.JDIPermission;

import javax.swing.*;

public class ZapisUdanyInformacja extends JDialog {
    public ZapisUdanyInformacja(){
        JOptionPane.showMessageDialog(this, "Dane zostały pomyślnie zapisane!", "SUKCES", JOptionPane.INFORMATION_MESSAGE);
    }
}
