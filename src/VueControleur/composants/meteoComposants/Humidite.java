package VueControleur.composants.meteoComposants;

import modele.Ordonnanceur;

import javax.swing.*;
import java.util.Observable;

public class Humidite extends PatternComposant {

    public Humidite() {
        super("Humidité");
    }
    @Override
    void setEnvironnementValeur() {
        environnementValeur.setText(valeurJLabel);
    }

    @Override
    void setEnvironnementIcon() {
        //TODO: Set les icons
    }

    @Override
    public void update(Observable o, Object arg) {
        valeurJLabel = String.valueOf(Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getHumiditeActuelle());
        valeurJLabel = valeurJLabel + "%";
        setEnvironnementValeur();
    }
}
