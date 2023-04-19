package VueControleur.composants.inventaireComposants;

import VueControleur.IconesVue;
import modele.Ordonnanceur;

import java.util.Observable;

public class ComposantTomate extends ComposantModel{
    public ComposantTomate() {
        super();
    }

    @Override
    void setCompteurComposant() {
        compteurComposant.setText(String.valueOf(compteurLegume));
    }

    @Override
    void setIconComposant() {
        iconComposant.setIcon(IconesVue.getIconesVue().getIcoTomate());
    }

    @Override
    public void update(Observable o, Object arg) {
        compteurLegume = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getInventaire().getNbTomates();
        setCompteurComposant();
    }
}
