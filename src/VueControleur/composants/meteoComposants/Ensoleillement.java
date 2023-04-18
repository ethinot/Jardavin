package VueControleur.composants.meteoComposants;

import VueControleur.IconesVue;
import modele.Ordonnanceur;

import java.util.Observable;

import static java.lang.String.valueOf;

public class Ensoleillement extends PatternComposant{

    private int humiditeActuelle = 50; // Par défaut
    private float ensoillementActuel = 0.5f; // Par défaut
    public Ensoleillement() {
        super("Ensoleillement");
    }
    @Override
    void setEnvironnementValeur() {
        environnementValeur.setText(valeurJLabel);
    }

    @Override
    void setEnvironnementIcon() {
        if (humiditeActuelle < 25 && ensoillementActuel >= 0.7f) {
            environnementIcon.setIcon(IconesVue.getIconesVue().getIcoSoleil());
        } else if (humiditeActuelle > 50 && ensoillementActuel <= 0.5f) {
            environnementIcon.setIcon(IconesVue.getIconesVue().getIcoNuagePluit());
        } else if (humiditeActuelle <= 50 && ensoillementActuel <= 0.5f) {
            environnementIcon.setIcon(IconesVue.getIconesVue().getIcoNuage());
        } else {
            environnementIcon.setIcon(IconesVue.getIconesVue().getIcoNuageSoleil());
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        valeurJLabel = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getEnsoleillementActuel();
        humiditeActuelle = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getHumiditeActuelle();
        ensoillementActuel = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getEnsoillementFloat();
        setEnvironnementValeur();
        setEnvironnementIcon();
    }
}
