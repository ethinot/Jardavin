package VueControleur.composants.meteoComposants;

import VueControleur.IconesVue;
import modele.Ordonnanceur;

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
        this.environnementIcon.setIcon(IconesVue.getIconesVue().getIcoHumidite());
    }

    @Override
    public void update(Observable o, Object arg) {
        valeurJLabel = String.valueOf(Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getHumiditeActuelle());
        valeurJLabel = valeurJLabel + "%";
        setEnvironnementValeur();
    }
}
