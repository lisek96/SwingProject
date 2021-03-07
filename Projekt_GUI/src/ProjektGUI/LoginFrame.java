package ProjektGUI;

import ProjektGUI.Powiadomienia.BledneHasloError;
import ProjektGUI.Powiadomienia.LogowaniePomyslneInformacja;
import ProjektGUI.Powiadomienia.NoSuchLoginError;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private static JPasswordField passwordField;
    private static JPanel hasloPanel;
    private static JPanel loginPanel;
    private static JTextField login;
    private static JLabel etykietaLogin;
    private static JLabel etykietaPassword;
    private static JButton zaloguj;

    LoginFrame(){
        setLayout(new BorderLayout());
        hasloPanel = new JPanel(new FlowLayout());
        etykietaPassword = new JLabel("Hasło:");
        Border defaultBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(100, 20));
        passwordField.setBorder(defaultBorder);
        login = new JTextField();
        etykietaLogin = new JLabel("Login: ");
        login.setPreferredSize(new Dimension(100, 20));
        loginPanel = new JPanel(new FlowLayout());

        loginPanel.add(etykietaLogin);
        loginPanel.add(login);
        add(loginPanel, BorderLayout.NORTH);

        hasloPanel.add(etykietaPassword);
        hasloPanel.add(passwordField);
        add(hasloPanel, BorderLayout.CENTER);
        zaloguj = new JButton("Zaloguj");
        add(zaloguj, BorderLayout.SOUTH);

        zaloguj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(sprawdzHaslo()){
                    new MenuFrame();
                    dispose();
                    new LogowaniePomyslneInformacja();
                }
            }
        });
        setVisible(true);
        setSize(new Dimension(250, 150));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Logowanie");
    }

    public boolean sprawdzHaslo(){
        Uzytkownik uzytkownik = null;
        char[] wprowadzoneHaslo = passwordField.getPassword();
        String login = this.login.getText();

        uzytkownik = Uzytkownik.sprawdzCzyLoginIstnieje(login);

        if(uzytkownik==null) {
            new NoSuchLoginError();
            return false;
        }

        if(Uzytkownik.sprawdzHaslo(wprowadzoneHaslo, uzytkownik)){
            passwordField.setText("");
            wprowadzoneHaslo=null;
            return true;
        }
        else {
            new BledneHasloError();
            return false;
        }





    }

}
