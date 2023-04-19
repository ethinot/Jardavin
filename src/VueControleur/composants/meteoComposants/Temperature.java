package VueControleur.composants.meteoComposants;

import VueControleur.IconesVue;
import modele.Ordonnanceur;

import java.util.Observable;

public class Temperature extends PatternComposant{

    float temperatureActuelle = 20; // Température par défaut
    public Temperature() {
        super("Temperature");
    }
    @Override
    void setEnvironnementValeur() {
        environnementValeur.setText(valeurJLabel);
    }

    @Override
    void setEnvironnementIcon() {
        if (temperatureActuelle < 1) {
            environnementIcon.setIcon(IconesVue.getIconesVue().getIcoTemperatureFroid());
        } else if (temperatureActuelle > 26) {
            environnementIcon.setIcon(IconesVue.getIconesVue().getIcoTemperatureChaud());
        } else {
            environnementIcon.setIcon(IconesVue.getIconesVue().getIcoTemperatureMoyenne());
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        temperatureActuelle = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getTemperatureArrondis();
        valeurJLabel = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getTemperatureActuelle();
        setEnvironnementValeur();
        setEnvironnementIcon();
        // TODO : Fonction qui change l'icon en fonction de la température
    }
}
