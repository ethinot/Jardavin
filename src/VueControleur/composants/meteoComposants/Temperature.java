package VueControleur.composants.meteoComposants;

import modele.Ordonnanceur;

import java.util.Observable;

public class Temperature extends PatternComposant{
    public Temperature() {
        super("Temperature");
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
        valeurJLabel = String.valueOf(Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getTemperatureActuelle());
        setEnvironnementValeur();
    }
}
