package modele;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class Temps {
    public Date date;
    Temps () {
        this.date = new Date();
    }
    public static void main(String[] args) {
        Temps tmp = new Temps();
        SimpleDateFormat jourMoisAnnee = new SimpleDateFormat("dd/MM/YY hh:mm:ss");
        SimpleDateFormat heureMinuteSeconde = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat seconde = new SimpleDateFormat("ss");
        System.out.println("Date : " + jourMoisAnnee.format(tmp.date) + "\n Horaire : " + heureMinuteSeconde.format(tmp.date));
        while (true) {
            int nbSec = parseInt(seconde.format(tmp.date));
            System.out.println(nbSec);
        }
    }
}
