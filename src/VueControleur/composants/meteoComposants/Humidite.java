package VueControleur.composants.meteoComposants;

import VueControleur.IconesVue;
import modele.Ordonnanceur;

import java.util.Observable;

public class Humidite extends PatternComposant {

    private int humidieActuel;
    public Humidite() {
        super("Humidité");
    }
    @Override
    void setEnvironnementValeur() {
        environnementValeur.setText(valeurJLabel);
    }

    @Override
    void setEnvironnementIcon() {
        if (humidieActuel > 67 ) {
            environnementIcon.setIcon(IconesVue.getIconesVue().getIcoHumiditeForte());
        } else if (humidieActuel > 33) {
            environnementIcon.setIcon(IconesVue.getIconesVue().getIcoHumiditeMoyenne());
        } else {
            environnementIcon.setIcon(IconesVue.getIconesVue().getIcoHumiditeFaible());
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        humidieActuel = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getSimMet().getHumiditeActuelle();
        valeurJLabel = humidieActuel + "%";
        setEnvironnementValeur();
        setEnvironnementIcon();
    }
}
