package VueControleur.composants.meteoComposants;

import VueControleur.composants.IconesVue;
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
        environnementIcon.setIcon(IconesVue.getIconesVue().getIcoTemps());
    }

    @Override
    public void update(Observable o, Object arg) {
        valeurJLabel = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getTemperatureActuelle();
        setEnvironnementValeur();
    }
}
