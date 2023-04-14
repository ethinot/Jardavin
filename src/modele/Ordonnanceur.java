package modele;

import modele.temps.TempsModel;
import modele.temps.composants.IncrementerTempsModel;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.TimerTask;
import java.util.Vector;
import java.util.Timer;

import static java.lang.Thread.*;

public class Ordonnanceur extends Observable {

    private static Ordonnanceur ordonnanceur;

    // design pattern singleton
    public static Ordonnanceur getOrdonnanceur() {
        if (ordonnanceur == null) {
            ordonnanceur = new Ordonnanceur();
        }
        return ordonnanceur;
    }
    private SimulateurPotager simulateurPotager;
    private Timer frequenceMAJ;
    private int annee;
    private int mois;
    private int jour;
    private Vector<Runnable> lst = new Vector<Runnable>(); // liste synchronisée

    private void updateModel() {
        boolean update = true; // TODO A changer chaque runnable doit avoir un champ update
        System.out.println("---------------TEMPS------------" + TempsModel.getTemps().getTempsModel());
        for (Runnable r : lst) {
            r.run();
        }

        if (update) {
            setChanged();
            notifyObservers();
        }
    }
    public void start(int _annee, int _mois, int _jour) {
        annee = _annee;
        mois = _mois;
        jour = _jour;
        this.frequenceMAJ = new Timer(); // Lancement du timer chargé de la mise à jour du model
        TempsModel.getTemps().setTemps(annee, mois, jour);
        TimerTask updateTask = new TimerTask() {
            @Override
            public void run() {
                updateModel();
            }
        };
        frequenceMAJ.scheduleAtFixedRate(updateTask, 0, 1000 / 30);
    }

    public void stop() {
        if (frequenceMAJ != null) {
            frequenceMAJ.cancel();
        }
    }
    public void add(Runnable r) {lst.add(r);}

    public LocalDateTime getTime() {
        return TempsModel.getTemps().getTempsModel();
    }
    public void setPeriode(int nouvellePeriode, IncrementerTempsModel incrementeur) {
        TempsModel.getTemps().setPeriode(nouvellePeriode, incrementeur);
    }
}
