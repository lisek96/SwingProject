package ProjektGUI;

import javax.swing.*;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException{
        Uzytkownik.wczytajUzytkownikow();
        SwingUtilities.invokeLater(()->new LoginFrame());
    }
}
