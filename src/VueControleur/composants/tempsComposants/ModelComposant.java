package VueControleur.composants.tempsComposants;

import VueControleur.Style.Police;
import modele.Ordonnanceur;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Observer;

abstract public class ModelComposant implements Observer {
    protected String uniteTemps;
    protected JPanel uniteTempsConteneur;
    protected JLabel uniteTempsLabel = new JLabel();
    protected JButton accelerateur;
    protected int compteurAccelerateur = 1;

    public ModelComposant(String titreComposant) {
        Ordonnanceur.getOrdonnanceur().addObserver(this);
        uniteTempsConteneur = new JPanel(new FlowLayout( FlowLayout.CENTER, 10 ,10));
        setUniteTempsLabel();
        setAccelerateur();
        uniteTempsLabel.setFont(Police.getValeurPolice());
        uniteTempsConteneur.add(uniteTempsLabel);
        uniteTempsConteneur.add(accelerateur);
        Border bordureTitre = BorderFactory.createTitledBorder(titreComposant);
        uniteTempsConteneur.setBorder(bordureTitre);
    }

    protected int incrementeCompteur (int modulo) {
        compteurAccelerateur = (compteurAccelerateur + 1) % modulo;
        return compteurAccelerateur;
    }

    public JPanel getUniteTempsConteneur() {
        return uniteTempsConteneur;
    }

    abstract void setUniteTempsLabel();

    abstract void setAccelerateur();

}

