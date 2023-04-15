package VueControleur.composants.tempsComposants;

import modele.temps.TempsModel;
import modele.temps.composants.IncrementerHeure;
import modele.temps.composants.IncrementerMinute;
import modele.temps.composants.IncrementerSeconde;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.awt.event.*;

public class HeureMinuteSeconde extends modelComposant implements ActionListener{

    // 4 états différents pour l'acceleration (aucune, seconde, minute, heure)
    private int compteurAccelerateur = 1;
    public HeureMinuteSeconde() {
        super();
    }

    private int incrementeCompteur () {
        compteurAccelerateur = (compteurAccelerateur + 1) % 4;
        return compteurAccelerateur;
    }

    private void onClick() {
        switch (compteurAccelerateur) {
            case 0 :
                TempsModel.getTemps().setPeriode(1000, new IncrementerSeconde());
                accelerateur.setText(">");
                incrementeCompteur();
                break;
            case 1 :
                TempsModel.getTemps().setPeriode(10, new IncrementerSeconde());
                accelerateur.setText(">>");
                incrementeCompteur();
                break;
            case 2 :
                TempsModel.getTemps().setPeriode(50, new IncrementerMinute());
                accelerateur.setText(">>>");
                incrementeCompteur();
                break;
            case 3 :
                TempsModel.getTemps().setPeriode(200, new IncrementerHeure());
                accelerateur.setText(">>>>");
                incrementeCompteur();
                break;
        }
    }

    @Override
    void setUniteTempsLabel() {
        uniteTempsLabel.setText(uniteTemps);
    }

    @Override
    void setAccelerateur() {
        this.accelerateur = new JButton(">");
        this.accelerateur.addActionListener(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        uniteTemps = TempsModel.getTemps().getTempsHeureMinuteSeconde();
        setUniteTempsLabel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("JE CLICK");
        onClick();
    }
}
