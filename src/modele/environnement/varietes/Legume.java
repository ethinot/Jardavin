package modele.environnement.varietes;

import modele.environnement.varietes.conditionsCroissance.Conditions;
import modele.saison.Saisons;
import modele.temps.TempsModel;

import javax.swing.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

public abstract class Legume {

    public ImageIcon iconeLegume;

    protected TempsModel temps = TempsModel.getTemps();

    //Croissance de la salade en cours (en pourcentage) qui est égale à : NbHeureEcoulées * 100 / tempDeCroissanceEnHeure
    public double croissanceEnCours;

    //Nombre d'heures écoulées depuis que la salade a été plantée (calculer dans la croissance)
    public long nbHeuresEcoulees;

    //Heure à laquelle la salade a été plantée
    public LocalDateTime tempsDePlantage;

    //Nombre de jours qu'il faut à la salade pour pousser
    public int tempsDeCroissance;

    //Nombre d'heures qu'il faut à la salade pour pousser
    public int tempsDeCroissanceEnHeures = tempsDeCroissance * 60;

    //Jour du mois auquel la salade a été planté
    public int jourDePlantage = Integer.parseInt(temps.getTempsJour());

    //Jour du mois auquel la salade doit être récoltée
    public int jourDeRecolte = (Integer.parseInt(temps.getTempsJour()) + tempsDeCroissance) % 30;

    protected double tauxCroissance;

    //Condition de pousse favorable pour les légumes
    protected Conditions conditionsFavorable;

    public void setTauxCroissance(int humide, float soleil, float temps, Saisons saison) {
        tauxCroissance = conditionsFavorable.getTauxCroissance(humide, soleil, temps, saison);
    }

    protected DecimalFormat df = new DecimalFormat("0.00");

    public abstract Varietes getVariete();
    public void nextStep() {
        croissance();
    }
    protected abstract void croissance(); // définir selon les conditions
}
