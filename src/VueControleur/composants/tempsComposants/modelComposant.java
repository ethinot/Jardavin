package VueControleur.composants.tempsComposants;

import modele.Ordonnanceur;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

abstract public class modelComposant implements Observer {
    protected String uniteTemps;
    protected JPanel uniteTempsConteneur;
    protected JLabel uniteTempsLabel = new JLabel();
    protected JButton accelerateur;

    public modelComposant() {
        Ordonnanceur.getOrdonnanceur().addObserver(this);
        uniteTempsConteneur = new JPanel(new FlowLayout( FlowLayout.CENTER, 10 ,10));
        setUniteTempsLabel();
        setAccelerateur();
        uniteTempsConteneur.add(uniteTempsLabel);
        uniteTempsConteneur.add(accelerateur);
    }

    public JPanel getUniteTempsConteneur() {
        return uniteTempsConteneur;
    }
    abstract void setUniteTempsLabel();
    abstract void setAccelerateur();

}

