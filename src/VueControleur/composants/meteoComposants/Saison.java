package VueControleur.composants.meteoComposants;

import modele.Ordonnanceur;

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
        //TODO: Set les icons
    }

    @Override
    public void update(Observable o, Object arg) {
        valeurJLabel = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getSaisonActuelle();
        valeurJLabel = valeurJLabel.substring(0, 1).toUpperCase() + valeurJLabel.substring(1).toLowerCase();
        setEnvironnementValeur();
    }
}
