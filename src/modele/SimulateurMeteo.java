package modele;

import modele.environnement.Case;
import modele.environnement.CaseCultivable;
import modele.environnement.varietes.Carotte;
import modele.environnement.varietes.Radis;
import modele.environnement.varietes.Salade;
import modele.environnement.varietes.Tomate;
import modele.saison.*;
import modele.temps.TempsModel;

public class SimulateurMeteo implements Runnable {
    private SimulateurPotager simPot;

    // TODO : Salade, corote, tomate, radis

    private Environnement environnementActuel;

    private Saisons saisonsActuelle;
    protected int humiditeActuelle;
    protected float ensoleillementActuel;
    protected float temperatureActuelle;

    public SimulateurMeteo(SimulateurPotager _simPot) {
        Ordonnanceur.getOrdonnanceur().add(this);
        simPot = _simPot;
        setSaisonsActuelle();
        setEnvironnementActuel();
        setHumiditeActuelle();
        setEnsoleillementActuel();
        setTemperatureActuelle();
    }
    public Saisons getSaison(int mois) {
        if (mois >= 3 && mois <= 5) {
            return Saisons.printemps;
        } else if (mois >= 6 && mois <= 8) {
            return Saisons.ete;
        } else if (mois >= 9 && mois <= 11) {
            return Saisons.automne;
        } else {
            return Saisons.hiver;
        }
    }

    public boolean changementSaison() {
        Saisons saison = getSaison(TempsModel.getTemps().getTempsModel().getMonthValue());
        if (saisonsActuelle != saison) {
            saisonsActuelle = saison;
            return true;
        }
        return false;
    }

    public void setEnvironnementActuel() {
        switch (saisonsActuelle) {
            case printemps -> {
                environnementActuel = new Printemps();
            }
            case ete -> {
                environnementActuel = new Ete();
            }
            case automne -> {
                environnementActuel = new Automne();
            }
            case hiver -> {
                environnementActuel = new Hiver();
            }
        }
    }

    public void setSaisonsActuelle() {
        saisonsActuelle = getSaison(TempsModel.getTemps().getTempsModel().getMonthValue());
    }

    public void setHumiditeActuelle() {
        this.humiditeActuelle = environnementActuel.getHumidite();
    }

    public void setEnsoleillementActuel() {
        this.ensoleillementActuel = environnementActuel.getEnsoleillement();
    }

    public void setTemperatureActuelle() {
        this.temperatureActuelle = environnementActuel.getTemperature();
    }

    // TODO: set Les Autres actuelle

    @Override
    public void run() {
        // Saison nouvelle ?
        // Update si jour =! via la fonction dans Environnement updateTemps();
        boolean jourNouveau;
        if (changementSaison()) { // Si la saison change on met à jour l'environnement
            setEnvironnementActuel();
        }

        jourNouveau = environnementActuel.updateTemps(); // Si je suis passé à un autre jour je modifie le temps actuel

        if (jourNouveau) {
            setHumiditeActuelle();
            setEnsoleillementActuel();
            setTemperatureActuelle();
            for(int i = 0; i < simPot.SIZE_X; i++){
                for(int j = 0; j < simPot.SIZE_Y; j++) {
                    if (simPot.getPlateau()[i][j] instanceof CaseCultivable && ((CaseCultivable) simPot.getPlateau()[i][j]).getLegume() != null) {
                        if (((CaseCultivable) simPot.getPlateau()[i][j]).getLegume() instanceof Salade) {
                            ((CaseCultivable) simPot.getPlateau()[i][j]).getLegume().setTauxCroissance(humiditeActuelle, ensoleillementActuel, temperatureActuelle, saisonsActuelle);
                        }
                        if (((CaseCultivable) simPot.getPlateau()[i][j]).getLegume() instanceof Carotte) {
                            ((CaseCultivable) simPot.getPlateau()[i][j]).getLegume().setTauxCroissance(humiditeActuelle, ensoleillementActuel, temperatureActuelle, saisonsActuelle);
                        }
                        if (((CaseCultivable) simPot.getPlateau()[i][j]).getLegume() instanceof Radis) {
                            ((CaseCultivable) simPot.getPlateau()[i][j]).getLegume().setTauxCroissance(humiditeActuelle, ensoleillementActuel, temperatureActuelle, saisonsActuelle);
                        }
                        if (((CaseCultivable) simPot.getPlateau()[i][j]).getLegume() instanceof Tomate) {
                            ((CaseCultivable) simPot.getPlateau()[i][j]).getLegume().setTauxCroissance(humiditeActuelle, ensoleillementActuel, temperatureActuelle, saisonsActuelle);
                        }
                    }
                }
            }
        }
    }

}
