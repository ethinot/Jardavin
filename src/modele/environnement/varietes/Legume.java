package modele.environnement.varietes;

import modele.temps.TempsModel;

import java.text.DecimalFormat;

public abstract class Legume {

    protected TempsModel temps = TempsModel.getTemps();

    //Croissance de la salade en cours (en pourcentage) qui est égale à : NbHeureEcoulées * 100 / tempDeCroissanceEnHeure
    public double croissanceEnCours;

    //Nombre d'heures écoulées depuis que la salade a été plantée (calculer dans la croissance)
    public long nbHeuresEcoulees;

    //Heure à laquelle la salade a été plantée
    public long tempsDePlantage = temps.getTempsEnSeconde() / 3600;

    //Nombre de jours qu'il faut à la salade pour pousser
    public int tempsDeCroissance;

    //Nombre d'heures qu'il faut à la salade pour pousser
    protected int tempsDeCroissanceEnHeures = tempsDeCroissance * 60;

    //Jour du mois auquel la salade a été planté
    public int jourDePlantage = Integer.parseInt(temps.getTempsJour());

    //Jour du mois auquel la salade doit être récoltée
    public int jourDeRecolte = (Integer.parseInt(temps.getTempsJour()) + tempsDeCroissance) % 30;

    protected DecimalFormat df = new DecimalFormat("0.00");

    public abstract Varietes getVariete();
    public void nextStep() {
        croissance();
    }

    protected abstract void croissance(); // définir selon les conditions
}
