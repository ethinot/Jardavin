package VueControleur.composants;
import modele.Ordonnanceur;

import javax.swing.event.*;
import java.awt.*;
import javax.swing.*;

public class AccelerationTemps implements ChangeListener{

    private int periode = 1000;
    private JPanel accelerateurConteneur = new JPanel();
    private JSlider slider;


    public AccelerationTemps() {
        slider = new JSlider(0, 10, 0);
        slider.setSnapToTicks(true);
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(1);
        slider.setMinorTickSpacing(1);
        slider.addChangeListener(this);
        accelerateurConteneur.add(slider);
    }
    public JPanel getAccelerateurConteneur() {
        return accelerateurConteneur;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int multiplicateur = slider.getValue();
        int nouvellePeriode = periode/(multiplicateur*100);
        Ordonnanceur.getOrdonnanceur().setPeriode(nouvellePeriode);
    }
}
