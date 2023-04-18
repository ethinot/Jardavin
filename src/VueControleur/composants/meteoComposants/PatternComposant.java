package VueControleur.composants.meteoComposants;

import VueControleur.Style.Police;
import modele.Ordonnanceur;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Observer;

abstract public class PatternComposant implements Observer {
    protected JPanel meteoComposantConteneur;
    protected JLabel environnementValeur = new JLabel();
    protected String valeurJLabel;
    protected JLabel environnementIcon = new JLabel();

    public PatternComposant(String titreComposant) {
        Ordonnanceur.getOrdonnanceur().addObserver(this);
        meteoComposantConteneur = new JPanel(new FlowLayout( FlowLayout.CENTER, 10, 0));
        environnementValeur.setFont(Police.getValeurPolice());
        setEnvironnementValeur();
        setEnvironnementIcon();
        Border bordureTitre = BorderFactory.createTitledBorder(titreComposant);
        meteoComposantConteneur.setBorder(bordureTitre);
        meteoComposantConteneur.add(environnementValeur);
        meteoComposantConteneur.add(environnementIcon);
    }

    public JPanel getMeteoComposantConteneur() { return meteoComposantConteneur;}
    abstract void setEnvironnementValeur();
    abstract void setEnvironnementIcon();

}
