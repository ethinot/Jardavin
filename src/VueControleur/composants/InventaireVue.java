package VueControleur.composants;

import VueControleur.Style.Police;
import modele.Inventaire;
import modele.Ordonnanceur;
import modele.environnement.CaseCultivable;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class InventaireVue implements Observer {

    private IconesVue iconesVue = new IconesVue();

    public JPanel inventairePanel = new JPanel();

    private Inventaire inventaire = new Inventaire();

    private int updateNbCarottes;
    private int updateNbSalades;
    private int updateNbTomates;
    private int updateNbRadis;

    public InventaireVue(){
        JLabel labelSalade = new JLabel(String.valueOf(updateNbSalades));
        labelSalade.setIcon(iconesVue.getIcoSalade());

        JLabel labelCarotte = new JLabel(String.valueOf(updateNbCarottes));
        labelCarotte.setIcon(iconesVue.getIcoCarotte());

        JLabel labelTomate = new JLabel(String.valueOf(updateNbTomates));
        labelTomate.setIcon(iconesVue.getIcoTomate());

        JLabel labelRadis = new JLabel(String.valueOf(updateNbRadis));
        labelRadis.setIcon(iconesVue.getIcoRadis());

        JLabel labelSacADos = new JLabel("Inventaire");
        labelSacADos.setFont(Police.getTitrePolice());
        labelSacADos.setIcon(iconesVue.getIcoSacADos());

        inventairePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        GridLayout inventaireLayout = new GridLayout(0, 1, 0, 10);
        inventairePanel.setLayout(inventaireLayout);
        inventairePanel.add(labelSacADos);
        inventairePanel.add(labelSalade);
        inventairePanel.add(labelCarotte);
        inventairePanel.add(labelTomate);
        inventairePanel.add(labelRadis);
    }

    public JPanel getInventaireVueConteneur(){
        return inventairePanel;
    }

    @Override
    public void update(Observable o, Object arg) {
        updateNbSalades = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getInventaire().getNbSalades();
        updateNbCarottes = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getInventaire().getNbCarotte();
        updateNbTomates = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getInventaire().getNbTomates();
        updateNbRadis = Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getInventaire().getNbRadis();
        Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getInventaire().setNbSalades(updateNbSalades);
        Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getInventaire().setNbCarotte(updateNbCarottes);
        Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getInventaire().setNbTomates(updateNbTomates);
        Ordonnanceur.getOrdonnanceur().getSimulateurPotager().getInventaire().setNbRadis(updateNbRadis);

    }
}
