package modele.environnement.varietes.conditionsCroissance;

import modele.saison.Saisons;

public class CarotteCondition extends Conditions{

    public CarotteCondition () {
        super();
    }
    @Override
    void setHumiditeIdeale() {
        humiditeIdeale =  40;
    }

    @Override
    void setEnsoleillementIdeale() {
        ensoleillementIdeale = 0.3f;
    }

    @Override
    void setTemperatureIdeal() {
        temperatureIdeal = 12;
    }

    @Override
    void setSaisonIdeal() {
        saisonIdeal = Saisons.automne;
    }
}
