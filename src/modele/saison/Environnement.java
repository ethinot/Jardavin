package modele.saison;

import modele.Ordonnanceur;
import modele.temps.TempsModel;

import java.util.Random;

public abstract class Environnement {
    protected int humidite; //Valeur entre 0 et 100
    protected float ensoleillement; //Valeur entre 0 et 1 en float
    protected float temperature; //Valeur entre -10 et 40

    protected Saisons saison;
    protected int jourActuel;
    protected Random rand = new Random();

    public Environnement() {
        setHumidite();
        setEnsoleillement();
        setTemperature();
        setSaison();
        jourActuel = TempsModel.getTemps().getTempsModel().getDayOfMonth();
    }

    public Saisons getSaison() {
        return this.saison;
    }

    abstract void setHumidite();

    abstract void setEnsoleillement();

    abstract void setTemperature();

    abstract void setSaison();

    public int getHumidite() {
        return humidite;
    }

    public float getEnsoleillement() {
        return ensoleillement;
    }

    public float getTemperature() {
        return temperature;
    }

    public boolean jourSuivant() {
        int jour = TempsModel.getTemps().getTempsModel().getDayOfMonth();
        if (jourActuel != jour)  {
            jourActuel = jour;
            return true;
        } else return false;
    }

    public boolean updateTemps() {
        if (jourSuivant()) {
            setHumidite();
            setEnsoleillement();
            setTemperature();
            return true;
        }
        return false;
    }
}
