package modele.temps.composants;

import modele.temps.TempsModel;

public class IncrementerMois extends IncrementerTempsModel{
    @Override
    public Duree getDuree() {
        return Duree.mois;
    }

    @Override
    public void run() {
        TempsModel.getTemps().setTempsModel(TempsModel.getTemps().getTempsModel().plusMonths(1));
    }
}
