package VueControleur.composants;
import VueControleur.composants.tempsComposants.HeureMinuteSeconde;
import VueControleur.composants.tempsComposants.Jour;
import VueControleur.composants.tempsComposants.Mois;
import VueControleur.composants.tempsComposants.Titre;

import javax.swing.*;
import java.awt.*;


public class TempsVue {
    private JPanel tempsVueConteneur = new JPanel();
    private Titre titre;
    private HeureMinuteSeconde heureMinuteSeconde;
    private Jour leJ;
    private Mois mois;

    public TempsVue() {
        tempsVueConteneur.setPreferredSize(new Dimension(200,0));
        tempsVueConteneur.setLayout(new GridLayout(5, 1, 20, 5));
        titre = new Titre();
        heureMinuteSeconde = new HeureMinuteSeconde();
        leJ = new Jour();
        mois = new Mois();
        tempsVueConteneur.add(titre.getTitre());
        tempsVueConteneur.add(heureMinuteSeconde.getUniteTempsConteneur());
        tempsVueConteneur.add(leJ.getUniteTempsConteneur());
        tempsVueConteneur.add(mois.getUniteTempsConteneur());
    }
    public JPanel getTempsVueConteneur () {
        return tempsVueConteneur;
    }

}
