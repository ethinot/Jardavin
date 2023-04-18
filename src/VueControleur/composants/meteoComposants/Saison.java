package VueControleur.composants.meteoComposants;

import VueControleur.composants.IconesVue;
import modele.Ordonnanceur;
import modele.temps.TempsModel;

import java.util.Observable;

public class Saison extends PatternComposant{
    public Saison() {
        super("Saison");

    }
    @Override
    void setEnvironnementValeur() {
        environnementValeur.setText(valeurJLabel);
    }

    @Override
    void setEnvironnementIcon() {
        switch (valeurJLabel) {
            case "printemps" :
                environnementIcon.setIcon(IconesVue.getIconesVue().getIcoPrintemps());
                break;

            case "ete" :
                environnementIcon.setIcon(IconesVue.getIconesVue().getIcoEte());
                break;

            case "automne" :
                environnementIcon.setIcon(IconesVue.getIconesVue().getIcoAutomne());
                break;

            case "hiver" :
                environnementIcon.setIcon(IconesVue.getIconesVue().getIcoHiver());
                break;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        valeurJLabel = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getSaisonActuelle();
        setEnvironnementIcon();
        valeurJLabel = valeurJLabel.substring(0, 1).toUpperCase() + valeurJLabel.substring(1).toLowerCase();
        setEnvironnementValeur();
    }
}
