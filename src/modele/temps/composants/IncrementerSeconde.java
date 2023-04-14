package modele.temps.composants;

import modele.temps.TempsModel;

public class IncrementerSeconde extends IncrementerTempsModel{

    @Override
    public Duree getDuree() {
        return Duree.second;
    }

    @Override
    public void run() {
        TempsModel.getTemps().setTempsModel(TempsModel.getTemps().getTempsModel().plusSeconds(1));
    }
}
