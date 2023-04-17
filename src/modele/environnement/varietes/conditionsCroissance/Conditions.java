package modele.environnement.varietes.conditionsCroissance;

import modele.saison.Saisons;

public abstract class Conditions {
    protected int humiditeIdeale; //Valeur entre 0 et 100
    protected float ensoleillementIdeale; //Valeur entre 0 et 1 en float
    protected float temperatureIdeal; //Valeur entre -10 et 40
    protected Saisons saisonIdeal;

    public Conditions() {
        setHumiditeIdeale();
        setEnsoleillementIdeale();
        setTemperatureIdeal();
        setSaisonIdeal();
    }

    abstract void setHumiditeIdeale();
    abstract void setEnsoleillementIdeale();
    abstract void setTemperatureIdeal();
    abstract void setSaisonIdeal();

    public double getTauxCroissance(int humiditeActuelle, float ensoleillementActuel, float temperatureActuelle, Saisons saisonActuelle) {
        double tauxCroissance = 1.0;
        double ecartSaison;
        if (saisonIdeal != saisonActuelle) {
            ecartSaison = 0.60;
        } else {
            ecartSaison = 1.0;
        }
        // Plus 5% de marge d'erreur
        if ((humiditeActuelle >= humiditeIdeale && humiditeActuelle < humiditeIdeale * 1.05) &&
            (ensoleillementActuel >= ensoleillementIdeale && ensoleillementActuel < ensoleillementIdeale * 1.05) &&
            (temperatureActuelle >= temperatureIdeal && temperatureActuelle < temperatureIdeal * 1.05) &&
            saisonActuelle == saisonIdeal) {
            tauxCroissance = 1.0;
        } else {
            // Calcul du taux de croissance proportionnellement aux écarts par rapport aux valeurs idéales
            double ecartHumidite = Math.abs(humiditeActuelle - humiditeIdeale) / 100.0;
            double ecartEnsoleillement = Math.abs(ensoleillementActuel - ensoleillementIdeale);
            double ecartTemperature = Math.abs(temperatureActuelle - temperatureIdeal) / 50.0;
            tauxCroissance = 1.0 - (ecartHumidite + ecartEnsoleillement + ecartTemperature + ecartSaison) / 4.0;
        }
        tauxCroissance = Math.max(0.0, Math.min(1.0, tauxCroissance)); // Résultat entre 0 et 1
        return tauxCroissance;
    }
}
