package modele.environnement.varietes.conditionsCroissance;

import modele.saison.Saisons;

public class TomateCondition extends Conditions {

    public TomateCondition() {
        super();
    }
    @Override
    void setHumiditeIdeale() {
        humiditeIdeale =  55;
    }

    @Override
    void setEnsoleillementIdeale() {
        ensoleillementIdeale = 0.75f;
    }

    @Override
    void setTemperatureIdeal() {
        temperatureIdeal = 26;
    }

    @Override
    void setSaisonIdeal() {
        saisonIdeal = Saisons.ete;
    }
}
