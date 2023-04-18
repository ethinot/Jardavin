package VueControleur.composants.tempsComposants;

import VueControleur.Style.Police;
import modele.temps.TempsModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Titre implements ActionListener {
    private JPanel titleConteneur = new JPanel();
    private JLabel title = new JLabel();
    private JButton stopButton = new JButton("STOP");

    public Titre() {
        titleConteneur.setLayout(new BoxLayout(titleConteneur, BoxLayout.Y_AXIS));
        title.setText("Temps");
        title.setFont(Police.getTitrePolice());
        title.setPreferredSize(new Dimension(65, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        stopButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        stopButton.addActionListener(this);
        titleConteneur.add(Box.createVerticalGlue());
        titleConteneur.add(title);
        titleConteneur.add(Box.createRigidArea(new Dimension(0, 10)));
        titleConteneur.add(stopButton);
        titleConteneur.add(Box.createVerticalGlue());
    }

    public JPanel getTitre() {
        return this.titleConteneur;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TempsModel.getTemps().stopTemps();
    }
}