package VueControleur.composants.inventaireComposants;

import VueControleur.IconesVue;
import modele.Ordonnanceur;

import java.util.Observable;

public class ComposantRadis extends ComposantModel{
    public ComposantRadis() {
        super();
    }

    @Override
    void setCompteurComposant() {
        compteurComposant.setText(String.valueOf(compteurLegume));
    }

    @Override
    void setIconComposant() {
        iconComposant.setIcon(IconesVue.getIconesVue().getIcoRadis());
    }

    @Override
    public void update(Observable o, Object arg) {
        compteurLegume = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getInventaire().getNbRadis();
        setCompteurComposant();
    }
}
