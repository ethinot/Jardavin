package VueControleur.composants.meteoComposants;

import VueControleur.IconesVue;
import modele.Ordonnanceur;

import java.util.Observable;

public class Temperature extends PatternComposant{

    int humiditeActuelle = 50; // Par défaut 50%
    public Temperature() {
        super("Temperature");
    }
    @Override
    void setEnvironnementValeur() {
        environnementValeur.setText(valeurJLabel);
    }

    @Override
    void setEnvironnementIcon() {

        environnementIcon.setIcon(IconesVue.getIconesVue().getIcoTemperature());
    }

    @Override
    public void update(Observable o, Object arg) {
        valeurJLabel = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getTemperatureActuelle();
        humiditeActuelle = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getHumiditeActuelle();
        // TODO : Fonction qui change l'icon en fonction de la température
    }
}
