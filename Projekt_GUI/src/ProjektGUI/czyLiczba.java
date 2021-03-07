package ProjektGUI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface czyLiczba {
    default boolean czyLiczba(String kandydatNaLiczbe){
        Pattern p = Pattern.compile("^0|^[1-9]+[0-9]*[.]?[0-9]*$");
        Matcher m = p.matcher(kandydatNaLiczbe);

        return m.matches();

    }
}
