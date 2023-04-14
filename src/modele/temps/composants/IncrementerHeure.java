package modele.temps.composants;

import modele.temps.TempsModel;

public class IncrementerHeure extends IncrementerTempsModel{
    @Override
    public Duree getDuree() {
        return Duree.heure;
    }

    @Override
    public void run() {
        TempsModel.getTemps().setTempsModel(TempsModel.getTemps().getTempsModel().plusHours(1));
    }
}
