package VueControleur.composants.tempsComposants;

import modele.temps.TempsModel;
import modele.temps.composants.IncrementerMois;
import modele.temps.composants.IncrementerSeconde;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class Mois extends ModelComposant implements ActionListener {

    public Mois() {
        super("Mois");
    }

    private void onClick() {
        switch (compteurAccelerateur) {
            case 0 :
                TempsModel.getTemps().setPeriode(1000, new IncrementerSeconde());
                accelerateur.setText(">");
                incrementeCompteur(2);
                break;
            case 1 :
                TempsModel.getTemps().setPeriode(1000, new IncrementerMois());
                accelerateur.setText("STOP");
                incrementeCompteur(2);
                break;
        }
    }
    @Override
    void setUniteTempsLabel() {
        uniteTempsLabel.setText(uniteTemps);
    }

    @Override
    void setAccelerateur() {
        accelerateur = new JButton(">");
        accelerateur.addActionListener(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        uniteTemps = TempsModel.getTemps().getTempsMois();
        setUniteTempsLabel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        onClick();
    }
}
