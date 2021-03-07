package ProjektGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TestFrame extends JFrame {

    TestFrame(){
        setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        PoziomZaplenieniaComponent poziomZaplenieniaComponent = new PoziomZaplenieniaComponent(KontenerMagazynow.lista_magazynów.get(0));
        add(poziomZaplenieniaComponent, gbc);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));

    }
}
