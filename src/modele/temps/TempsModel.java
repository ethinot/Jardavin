package modele.temps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;

public class TempsModel {
    private LocalDateTime tempsModel;
    private Timer miseAJourTemps;
    private int periodeActuel;
    private DateTimeFormatter heureMinuteSeconde;
    private DateTimeFormatter jourMoisAnnee;

    public TempsModel (int _annee, int _mois, int _jour) {
        tempsModel = LocalDateTime.of(_annee, _mois, _jour, 6, 0, 0);
        heureMinuteSeconde = DateTimeFormatter.ofPattern("HH:mm:ss");
        jourMoisAnnee = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        miseAJourTemps = new Timer();
        periodeActuel = 1000; // par défaut 1 seconde
        miseAJourTemps.schedule(new IncrementerTempsModel(this), 0, periodeActuel); // par défaut 1 sec
    }

    public void setTempsModel(LocalDateTime tempsModel) {
        this.tempsModel = tempsModel;
    }

    public LocalDateTime getTempsModel() { return tempsModel;}

    public String getJourMoisAnnee() { return tempsModel.format(jourMoisAnnee);}
    public String getHeureMinuteSeconde() { return tempsModel.format(heureMinuteSeconde);}

    public void stopTimer() {
        miseAJourTemps.cancel();
    }

    public void redemarrerTimer() {
        miseAJourTemps = new Timer();
        miseAJourTemps.schedule(new IncrementerTempsModel(this), periodeActuel);
    }
    public void setPeriode(int periode) {
        periodeActuel = periode;
        miseAJourTemps.cancel();
        miseAJourTemps = new Timer();
        miseAJourTemps.schedule(new IncrementerTempsModel(this), 0, periodeActuel);
    }
}
