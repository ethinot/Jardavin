package VueControleur.composants.tempsComposants;

import modele.temps.TempsModel;

import java.util.Observable;

public class Annee extends ModelComposant {

    public Annee() {
        super("Année");
    }
    @Override
    void setUniteTempsLabel() {
        uniteTempsLabel.setText(uniteTemps);
    }

    @Override
    void setAccelerateur() {
        return; // Pas d'implementation d'acceleration de l'année
    }

    @Override
    public void update(Observable o, Object arg) {
        uniteTemps = TempsModel.getTemps().getTempsAnne();
        setUniteTempsLabel();
    }
}
