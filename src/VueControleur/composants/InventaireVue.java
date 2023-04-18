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

    JLabel labelSalade = new JLabel();
    JLabel labelCarotte = new JLabel();
    JLabel labelTomate = new JLabel();
    JLabel labelRadis = new JLabel();
    JLabel labelSacADos = new JLabel();

    public InventaireVue(){
        Ordonnanceur.getOrdonnanceur().addObserver(this);

        labelSalade.setText("0");
        labelSalade.setIcon(iconesVue.getIcoSalade());

        labelCarotte.setText("0");
        labelCarotte.setIcon(iconesVue.getIcoCarotte());

        labelTomate.setText("0");
        labelTomate.setIcon(iconesVue.getIcoTomate());

        labelRadis.setText("0");
        labelRadis.setIcon(iconesVue.getIcoRadis());

        labelSacADos.setText("Inventaire");
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

        labelSalade.setText(String.valueOf(updateNbSalades));
        labelCarotte.setText(String.valueOf(updateNbCarottes));
        labelTomate.setText(String.valueOf(updateNbTomates));
        labelRadis.setText(String.valueOf(updateNbRadis));
    }
}
