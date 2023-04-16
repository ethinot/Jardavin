package VueControleur.composants.tempsComposants;

import modele.temps.TempsModel;
import modele.temps.composants.IncrementerHeure;
import modele.temps.composants.IncrementerJour;
import modele.temps.composants.IncrementerMinute;
import modele.temps.composants.IncrementerSeconde;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class Jour extends modelComposant implements ActionListener  {
    public Jour() {
        super("Jour");
    }

    private void onClick() {
        switch (compteurAccelerateur) {
            case 0 :
                TempsModel.getTemps().setPeriode(1000, new IncrementerSeconde());
                accelerateur.setText("x1");
                incrementeCompteur(3);
                break;
            case 1 :
                TempsModel.getTemps().setPeriode(500, new IncrementerJour());
                accelerateur.setText("x2");
                incrementeCompteur(3);
                break;
            case 2 :
                TempsModel.getTemps().setPeriode(200, new IncrementerJour());
                accelerateur.setText("STOP");
                incrementeCompteur(3);
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
        uniteTemps = TempsModel.getTemps().getTempsJour();
        setUniteTempsLabel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        onClick();
    }
}
