package VueControleur.composants;
import VueControleur.composants.tempsComposants.HeureMinuteSeconde;
import VueControleur.composants.tempsComposants.Titre;

import javax.swing.*;
import java.awt.*;


public class TempsVue {
    private JPanel tempsVueConteneur = new JPanel();
    private Titre titre;
    private HeureMinuteSeconde heureMinuteSeconde;

    public TempsVue() {
        tempsVueConteneur.setPreferredSize(new Dimension(175,0));
        tempsVueConteneur.setBackground(Color.blue);
        tempsVueConteneur.setLayout(new GridLayout(5, 1, 20, 5));
        titre = new Titre();
        heureMinuteSeconde = new HeureMinuteSeconde();
        tempsVueConteneur.add(titre.getTitre());
        tempsVueConteneur.add(heureMinuteSeconde.getUniteTempsConteneur());
    }
    public JPanel getTempsVueConteneur () {
        return tempsVueConteneur;
    }

}
