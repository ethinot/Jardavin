package VueControleur.composants;
import VueControleur.composants.tempsComposants.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class TempsVue {
    private JPanel tempsVueConteneur = new JPanel();
    private Titre titre;
    private HeureMinuteSeconde heureMinuteSeconde;
    private Jour leJ;
    private Mois mois;
    private Annee annee;

    public TempsVue() {
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        tempsVueConteneur.setPreferredSize(new Dimension(200,0));
        tempsVueConteneur.setLayout(new GridLayout(5, 1, 20, 5));
        tempsVueConteneur.setBorder(raisedbevel);
        titre = new Titre();
        heureMinuteSeconde = new HeureMinuteSeconde();
        leJ = new Jour();
        mois = new Mois();
        annee = new Annee();
        tempsVueConteneur.add(titre.getTitre());
        tempsVueConteneur.add(heureMinuteSeconde.getUniteTempsConteneur());
        tempsVueConteneur.add(leJ.getUniteTempsConteneur());
        tempsVueConteneur.add(mois.getUniteTempsConteneur());
        tempsVueConteneur.add(annee.getUniteTempsConteneur());
    }
    public JPanel getTempsVueConteneur () {
        return tempsVueConteneur;
    }

}
