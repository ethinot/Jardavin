package VueControleur.composants;
import modele.Ordonnanceur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class TempsVue implements Observer {

    String jourMoisAnnee;
    String heureMinuteSeconde;

    private JPanel tempsVueConteneur = new JPanel();
    private JLabel hms = new JLabel();
    private JLabel jma = new JLabel();
    public TempsVue() {
        tempsVueConteneur.setBounds(50,50,50,50);
        tempsVueConteneur.setBackground(Color.LIGHT_GRAY);
        tempsVueConteneur.add(hms);
        tempsVueConteneur.add(jma);
    }

    public JPanel getTempsVue () {
        return tempsVueConteneur;
    }

    private void setHmsPannel() {
        hms.setText(heureMinuteSeconde);
    }

    private void setJmaPannel() {
        jma.setText(jourMoisAnnee);
    }
    @Override
    public void update(Observable o, Object arg) {
        jourMoisAnnee = Ordonnanceur.getOrdonnanceur().getJourMoisAnnee();
        heureMinuteSeconde = Ordonnanceur.getOrdonnanceur().getHeureMinuteSeconde();
        setHmsPannel();
        setJmaPannel();
    }
}
