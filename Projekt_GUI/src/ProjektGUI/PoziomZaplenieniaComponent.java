package ProjektGUI;

import javax.swing.*;
import java.awt.*;

public class PoziomZaplenieniaComponent extends JComponent {

    Magazyn magazyn;

    PoziomZaplenieniaComponent(Magazyn magazyn){
        this.magazyn=magazyn;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        double pozostalaPowierzchnia = magazyn.pozostalaPowierzchnia;
        double calkowitaPowierzchnia = magazyn.powierzchnia;
        int procentDostepnejPowierzchni = (int) ( 100 * pozostalaPowierzchnia / calkowitaPowierzchnia);
        int procentZajetejPowierzchni = 100 - procentDostepnejPowierzchni;

        g.setColor(Color.GREEN);
        g.fillRect(10, 10, 100, procentDostepnejPowierzchni);

        g.setColor(Color.RED);
        g.fillRect(10, 10+procentDostepnejPowierzchni, 100, procentZajetejPowierzchni);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Czcionka", Font.BOLD, 15));
        g.drawString(Integer.toString(procentDostepnejPowierzchni) + "%",50, 65);

        setPreferredSize(new Dimension(130, 130));




    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(130, 130);
    }


}
