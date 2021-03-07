package ProjektGUI.Powiadomienia;

import com.sun.jdi.JDIPermission;

import javax.swing.*;

public class BledneHasloError extends JDialog {
    public BledneHasloError(){
     JOptionPane.showMessageDialog(this, "Wpisano bledne haslo", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
