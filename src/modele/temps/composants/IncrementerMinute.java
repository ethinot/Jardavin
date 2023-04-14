package modele.temps.composants;

import modele.temps.TempsModel;

public class IncrementerMinute extends IncrementerTempsModel{
    @Override
    public Duree getDuree() {
        return Duree.minute;
    }

    @Override
    public void run() {
        TempsModel.getTemps().setTempsModel(TempsModel.getTemps().getTempsModel().plusMinutes(1));
    }
}
