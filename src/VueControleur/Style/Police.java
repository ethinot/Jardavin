package VueControleur.Style;

import java.awt.*;

public class Police {
    static private Font titrePolice = new Font(Font.MONOSPACED,  Font.BOLD, 20);
    static private Font paragraphePolice = new Font(Font.MONOSPACED, Font.PLAIN, 15);
    static private Font valeurPolice = new Font(Font.MONOSPACED, Font.ITALIC, 15);

    static public Font getTitrePolice() {
        return titrePolice;
    }
    static public Font getParagraphePolice() {
        return paragraphePolice;
    }
    static public Font getValeurPolice() {
        return valeurPolice;
    }
}
