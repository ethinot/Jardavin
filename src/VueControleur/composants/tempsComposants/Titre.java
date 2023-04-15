package VueControleur.composants.tempsComposants;

import VueControleur.Style.Police;

import javax.swing.*;
import java.awt.*;

public class Titre {
    private JPanel titleConteneur = new JPanel();
    private JLabel title = new JLabel();

    public Titre(){
        titleConteneur.setLayout(new FlowLayout(FlowLayout.CENTER));
        title.setText("Temps");
        title.setFont(Police.getTitrePolice());
        title.setPreferredSize(new Dimension(65,25));
        title.setOpaque(true);
        title.setBackground(Color.RED);
        titleConteneur.add(title);
    }

    public JPanel getTitre() {
        return this.titleConteneur;
    }

}
