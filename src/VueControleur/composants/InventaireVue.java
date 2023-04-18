package VueControleur.composants;

import VueControleur.IconesVue;
import VueControleur.Style.Police;
import VueControleur.composants.inventaireComposants.ComposantCarotte;
import VueControleur.composants.inventaireComposants.ComposantRadis;
import VueControleur.composants.inventaireComposants.ComposantSalade;
import VueControleur.composants.inventaireComposants.ComposantTomate;
import modele.Inventaire;
import modele.Ordonnanceur;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class InventaireVue {

    public JPanel inventairePanel = new JPanel();
    JLabel labelSacADos = new JLabel();
    private Inventaire inventaire = new Inventaire();
    private ComposantSalade composantSalade;
    private ComposantCarotte composantCarotte;
    private ComposantTomate composantTomate;
    private ComposantRadis composantRadis;



    public InventaireVue(){
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        inventairePanel.setBorder(raisedbevel);
        GridLayout inventaireLayout = new GridLayout(0, 1, 0, 10);
        inventairePanel.setLayout(inventaireLayout);
        labelSacADos.setText("Inventaire");
        labelSacADos.setFont(Police.getTitrePolice());
        labelSacADos.setIcon(IconesVue.getIconesVue().getIcoSacADos());
        composantSalade = new ComposantSalade();
        composantCarotte = new ComposantCarotte();
        composantTomate = new ComposantTomate();
        composantRadis = new ComposantRadis();
        inventairePanel.add(labelSacADos);
        inventairePanel.add(composantSalade.getComposantModel());
        inventairePanel.add(composantCarotte.getComposantModel());
        inventairePanel.add(composantTomate.getComposantModel());
        inventairePanel.add(composantRadis.getComposantModel());
    }

    public JPanel getInventaireVueConteneur(){
        return inventairePanel;
    }
}
