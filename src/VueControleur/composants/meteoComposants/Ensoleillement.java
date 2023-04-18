package VueControleur.composants.meteoComposants;

import VueControleur.IconesVue;
import modele.Ordonnanceur;

import java.util.Observable;

import static java.lang.String.valueOf;

public class Ensoleillement extends PatternComposant{
    public Ensoleillement() {
        super("Ensoleillement");
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
        valeurJLabel = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getEnsoleillementActuel();
        setEnvironnementValeur();
    }
}
