package modele.environnement.varietes.conditionsCroissance;

import modele.saison.Saisons;

public class RadisCondition extends Conditions{

    public RadisCondition() {
        super();
    }
    @Override
    void setHumiditeIdeale() {
        humiditeIdeale = 20;
    }

    @Override
    void setEnsoleillementIdeale() {
        ensoleillementIdeale = 0.2f;
    }

    @Override
    void setTemperatureIdeal() {
        temperatureIdeal = 5;
    }

    @Override
    void setSaisonIdeal() {
        saisonIdeal = Saisons.hiver;
    }
}
