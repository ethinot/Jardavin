package VueControleur.composants.inventaireComposants;

import VueControleur.Style.Police;
import modele.Ordonnanceur;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Observer;

abstract public class ComposantModel implements Observer {
    int compteurLegume; // Nombre de Legume (carotte, salade, tomate, radis) posséder

    JPanel composantConteneur;
    JLabel iconComposant = new JLabel();
    JLabel compteurComposant = new JLabel();

    public ComposantModel() {
        Ordonnanceur.getOrdonnanceur().addObserver(this);
        composantConteneur = new JPanel(new FlowLayout( FlowLayout.LEFT, 5, 0));
        compteurComposant.setFont(Police.getValeurPolice());
        compteurComposant.setText("0"); // Valeur par défaut et oui on a rien dans l'inventaire
        setCompteurComposant();
        setIconComposant();
        composantConteneur.add(iconComposant);
        composantConteneur.add(compteurComposant);
    }

    public JPanel getComposantModel() { return composantConteneur;}
    abstract void setCompteurComposant();
    abstract void setIconComposant();
}
