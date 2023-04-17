package VueControleur.composants.tempsComposants;

import modele.temps.TempsModel;
import modele.temps.composants.IncrementerHeure;
import modele.temps.composants.IncrementerMinute;
import modele.temps.composants.IncrementerSeconde;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class HeureMinuteSeconde extends ModelComposant implements ActionListener{

    // 4 états différents pour l'acceleration (aucune, seconde, minute, heure)
    public HeureMinuteSeconde() {
        super("Heure,Minute,Seconde");
    }

    private void onClick() {
        switch (compteurAccelerateur) {
            case 0 -> {
                TempsModel.getTemps().setPeriode(1000, new IncrementerSeconde());
                accelerateur.setText("Sec");
                incrementeCompteur(4);
            }
            case 1 -> {
                TempsModel.getTemps().setPeriode(10, new IncrementerSeconde());
                accelerateur.setText("Min");
                incrementeCompteur(4);
            }
            case 2 -> {
                TempsModel.getTemps().setPeriode(50, new IncrementerMinute());
                accelerateur.setText("Heure");
                incrementeCompteur(4);
            }
            case 3 -> {
                TempsModel.getTemps().setPeriode(200, new IncrementerHeure());
                accelerateur.setText("NORMAL");
                incrementeCompteur(4);
            }
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
        onClick();
    }
}
