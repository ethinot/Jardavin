package modele.temps.composants;

import modele.temps.TempsModel;

public class IncrementerJour extends IncrementerTempsModel{
    @Override
    public Duree getDuree() {
        return Duree.jour;
    }

    @Override
    public void run() {
        TempsModel.getTemps().setTempsModel(TempsModel.getTemps().getTempsModel().plusDays(1));
    }
}
