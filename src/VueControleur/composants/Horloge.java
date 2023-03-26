package VueControleur.composants;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Horloge implements ActionListener {

    int tempsActuel = 0;
    int heures = 0;
    int minutes = 0;
    int secondes = 0;
    int delai = 1000;
    boolean estDemarre = false;
    private JToolBar horloge = new JToolBar();
    JButton buttonDemarre = new JButton("GO");
    JButton buttonReset = new JButton("RESET");
    JButton reculeRapide = new JButton("<<");
    JButton recule = new JButton("<");
    JButton avance = new JButton(">");
    JButton avanceRapide = new JButton(">>");
    JLabel tempsLabel = new JLabel();
    String secondes_string = String.format("%02d", secondes);
    String minutes_string = String.format("%02d", minutes);
    String heures_string = String.format("%02d", heures);

    Timer timer = new Timer(delai, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tempsActuel += (1000);
            heures =  (tempsActuel / 3600000);
            minutes = (tempsActuel / 60000) % 60;
            secondes = (tempsActuel / 1000) % 60;
            secondes_string = String.format("%02d", secondes);
            minutes_string = String.format("%02d", minutes);
            heures_string = String.format("%02d", heures);
            tempsLabel.setText(heures_string + ":" + minutes_string + ":" + secondes_string);
        }
    });

    private JButton boutonCreation(JButton b){
        b.setFont(new Font("Verdana", Font.PLAIN, 12));
        b.setFocusable(false);
        b.addActionListener(this);
        return b;
    }
    public Horloge() {

        tempsLabel.setText(heures_string + ":" + minutes_string + ":" + secondes_string);
        tempsLabel.setBounds(50, 50, 100, 100);
        tempsLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        tempsLabel.setBorder(BorderFactory.createBevelBorder(1));
        tempsLabel.setOpaque(true);
        tempsLabel.setHorizontalAlignment(JTextField.CENTER);

        horloge.add(boutonCreation(reculeRapide));
        horloge.add(boutonCreation(recule));
        horloge.add(boutonCreation(buttonDemarre));
        horloge.add(tempsLabel);
        horloge.add(boutonCreation(buttonReset));
        horloge.add(boutonCreation(avance));
        horloge.add(boutonCreation(avanceRapide));

        horloge.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonDemarre) {
            if (estDemarre == false) {
                estDemarre = true;
                buttonDemarre.setText("STOP");
                demarre();
            } else {
                estDemarre = false;
                buttonDemarre.setText("GO !");
                arret();
            }
        }
        if(e.getSource() == buttonReset) {
            estDemarre = false;
            delai = 1000;
            buttonDemarre.setText("GO !");
            reset();
        }
        if(e.getSource() == reculeRapide) {
            delai = 1500;
            timer.setDelay(delai);
        }
        if(e.getSource() == recule) {
            delai = 1250;
            timer.setDelay(delai);
        }
        if(e.getSource() == avance) {
            delai = 750;
            timer.setDelay(delai);
        }
        if(e.getSource() == avanceRapide) {
            delai = 100;
            timer.setDelay(delai);
        }

    }

    public JToolBar getHorloge () {
        return horloge;
    }
    void demarre() {
        timer.start();
    }

    void arret() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        tempsActuel = 0;
        secondes = 0;
        minutes = 0;
        heures = 0;
        secondes_string = String.format("%02d", secondes);
        minutes_string = String.format("%02d", minutes);
        heures_string = String.format("%02d", heures);
        tempsLabel.setText(heures_string + ":" + minutes_string + ":" + secondes_string);
    }
}
