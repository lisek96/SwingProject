package ProjektGUI.keyListeners;

import ProjektGUI.DodajMagazynFrame;
import ProjektGUI.KontenerMagazynow;
import ProjektGUI.Powiadomienia.PowierzchaniaError;
import ProjektGUI.czyLiczba;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DodajKeyListener implements KeyListener, czyLiczba {


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        String powierzchnia = DodajMagazynFrame.powierzchnia.getText();


        char c = keyEvent.getKeyChar();
        if(c==KeyEvent.VK_ENTER && DodajMagazynFrame.lokalizacja.isEditable()){
                KontenerMagazynow.lokalizacjaNowegoMagazynu =DodajMagazynFrame.lokalizacja.getText();
                DodajMagazynFrame.lokalizacja.setEditable(false);
                DodajMagazynFrame.powierzchnia.setEditable(true);
            }
        else if(c==keyEvent.VK_ENTER && !DodajMagazynFrame.lokalizacja.isEditable()){
                    if(czyLiczba(powierzchnia)){
                        KontenerMagazynow.powierzchniaNowegomagazynu = Double.parseDouble(powierzchnia);
                        DodajMagazynFrame.powierzchnia.setEditable(false);
                    }
                    else new PowierzchaniaError();

            }
        }
    }

