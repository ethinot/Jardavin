package modele.environnement.varietes.conditionsCroissance;

import modele.saison.Saisons;

public class SaladeCondition extends Conditions {

    public SaladeCondition() {
        super();
    }
    @Override
    void setHumiditeIdeale() {
        humiditeIdeale =  70;
    }

    @Override
    void setEnsoleillementIdeale() {
        ensoleillementIdeale = 0.6f;
    }

    @Override
    void setTemperatureIdeal() {
        temperatureIdeal = 22;
    }

    @Override
    void setSaisonIdeal() {
        saisonIdeal = Saisons.printemps;
    }
}
