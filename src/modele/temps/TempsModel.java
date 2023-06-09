package modele.temps;

import modele.temps.composants.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Timer;

public class TempsModel {
    // Design pattern singleton pour que les temps soit le même partout dans le programme
    private static TempsModel temps;
    private LocalDateTime tempsModel;
    private Timer miseAJourTemps;
    private int periodeActuel;

    // Format pour formater les dates
    private DateTimeFormatter formatJour = DateTimeFormatter.ofPattern("dd");
    private DateTimeFormatter formatMoisEcrit = DateTimeFormatter.ofPattern("MMMM", Locale.FRANCE);
    private DateTimeFormatter formatMois = DateTimeFormatter.ofPattern("MM");
    private DateTimeFormatter formatAnnee  = DateTimeFormatter.ofPattern("yyyy");
    private DateTimeFormatter formatHeureMinuteSeconde = DateTimeFormatter.ofPattern("HH:mm:ss");
    private DateTimeFormatter formatHeure = DateTimeFormatter.ofPattern("HH");
    private DateTimeFormatter formatMinute = DateTimeFormatter.ofPattern("mm");
    private DateTimeFormatter formatSeconde = DateTimeFormatter.ofPattern("ss");

    public TempsModel (int _annee, int _mois, int _jour) {
        tempsModel = LocalDateTime.of(_annee, _mois, _jour, 6, 0, 0);
        miseAJourTemps = new Timer();
        periodeActuel = 1000; // par défaut 1 seconde
        miseAJourTemps.schedule(new IncrementerSeconde(), 0, periodeActuel); // par défaut 1 sec
    }
    public void setTemps(int _annee, int _mois, int _jour) {
        if (temps != null) {
            tempsModel = LocalDateTime.of(_annee, _mois, _jour, 6, 0, 0);
        }
    }
    public void setTempsModel(LocalDateTime _tempsModel) {
        this.tempsModel = _tempsModel;
    }

    public static TempsModel getTemps() {
        if (temps == null) {
            temps = new TempsModel(2000, 1,1);
        }
        return temps;
    }

    public LocalDateTime getTempsModel() {
        return tempsModel;
    }

    public String getTempsHeureMinuteSeconde() { return tempsModel.format(formatHeureMinuteSeconde); }
    public String getTempsJour() { return tempsModel.format(formatJour); }
    public String getTempsMois() { return tempsModel.format(formatMoisEcrit); }
    public String getTempsAnne() { return tempsModel.format(formatAnnee); }
    public String getTempsHeure(){ return tempsModel.format(formatHeure); }

    public long getTempsEnSeconde() {
        String tempsEnEntier = String.valueOf(tempsModel.getYear()) + tempsModel.format(formatMois) + tempsModel.format(formatJour) +
                tempsModel.format(formatHeure) + tempsModel.format(formatMinute) + tempsModel.format(formatSeconde);
        long res = Long.parseLong(tempsEnEntier);
        return res;
    }

    public void stopTemps(){
        miseAJourTemps.cancel();
    }

    public int getTempsEcouler(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        Duration duration = Duration.between(dateTime1, dateTime2);
        long secondesEcoulees = duration.getSeconds();
        return (int) secondesEcoulees;
    }

    public void setPeriode(int periode, IncrementerTempsModel incrementeur) {
        periodeActuel = periode;
        miseAJourTemps.cancel();
        miseAJourTemps = new Timer();
        if(incrementeur instanceof IncrementerSeconde) {
            miseAJourTemps.schedule(new IncrementerSeconde(), 0, periodeActuel);
        }
        if(incrementeur instanceof IncrementerMinute) {
            miseAJourTemps.schedule(new IncrementerMinute(), 0, periodeActuel);
        }
        if(incrementeur instanceof IncrementerHeure) {
            miseAJourTemps.schedule(new IncrementerHeure(), 0, periodeActuel);
        }
        if(incrementeur instanceof IncrementerJour) {
            miseAJourTemps.schedule(new IncrementerJour(), 0, periodeActuel);
        }
        if(incrementeur instanceof IncrementerMois) {
            miseAJourTemps.schedule(new IncrementerMois(), 0, periodeActuel);
        }
    }

    public static void main(String[] args) {
        temps.getTemps();
        int tempsEcoulée = temps.getTempsEcouler(temps.getTempsModel(), temps.getTempsModel());
        //System.out.println(tempsEcoulée);

        LocalDateTime tempsActuel = temps.tempsModel;
        LocalDateTime temps1 = LocalDateTime.of(2000, 1, 1, 6, 0, 0);
        LocalDateTime temps2 = LocalDateTime.of(2000, 1, 1, 7, 0, 0);
        Duration duration = Duration.between(temps1, temps2);
        long secondes = duration.getSeconds();
        System.out.println(tempsActuel);
        System.out.println(secondes);
    }
}
