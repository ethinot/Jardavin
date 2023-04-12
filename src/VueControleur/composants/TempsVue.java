package VueControleur.composants;
import modele.Ordonnanceur;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import VueControleur.Style.Police;


public class TempsVue implements Observer {

    private LocalDateTime temps;
    private String jour, mois, annee, heureMinuteSeconde;
    private DateTimeFormatter formatJour, formatMois, formatAnnee;
    private DateTimeFormatter formatHeureMinuteSeconde;
    private JPanel tempsVueConteneur = new JPanel();
    private JLabel hms = new JLabel();
    private JLabel jourLabel = new JLabel();
    private JLabel moisLabel = new JLabel();
    private JLabel anneeLabel = new JLabel();
    private JLabel title = new JLabel();
    private void configureTitre(){
        title.setText("Temps");
        title.setFont(Police.getTitrePolice());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void configurePattern() {
        formatHeureMinuteSeconde = DateTimeFormatter.ofPattern("HH:mm:ss");
        formatJour = DateTimeFormatter.ofPattern("dd");
        formatMois = DateTimeFormatter.ofPattern("MMMM", Locale.FRANCE);
        formatAnnee = DateTimeFormatter.ofPattern("yyyy");
    }

    private void configureValeur() {
        jourLabel.setFont(Police.getParagraphePolice());
        moisLabel.setFont(Police.getParagraphePolice());
        anneeLabel.setFont(Police.getParagraphePolice());
        hms.setFont(Police.getParagraphePolice());
        hms.setAlignmentX(Component.CENTER_ALIGNMENT);
        jourLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        moisLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        anneeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public TempsVue() {
        tempsVueConteneur.setLayout(new BoxLayout(tempsVueConteneur, BoxLayout.Y_AXIS));
        tempsVueConteneur.setPreferredSize(new Dimension(150,100));
        tempsVueConteneur.setBackground(Color.LIGHT_GRAY);
        configurePattern();
        configureTitre();
        configureValeur();
        tempsVueConteneur.add(title);
        tempsVueConteneur.add(hms);
        tempsVueConteneur.add(jourLabel);
        tempsVueConteneur.add(moisLabel);
        tempsVueConteneur.add(anneeLabel);
    }
    public JPanel getTempsVueConteneur () {
        return tempsVueConteneur;
    }

    private void setHmsPannel() {
        hms.setText(heureMinuteSeconde);
    }
    private void setJourPannel() {
        jourLabel.setText("Jour: " + jour);
    }
    private void setMoisPannel() {
        moisLabel.setText("Mois: " + mois);
    }
    private void setAnneePannel() {
        anneeLabel.setText("Année: " + annee);
    }

    @Override
    public void update(Observable o, Object arg) {
        temps = Ordonnanceur.getOrdonnanceur().getTime();
        jour= temps.format(formatJour);
        mois = temps.format(formatMois);
        annee = temps.format(formatAnnee);
        heureMinuteSeconde = temps.format(formatHeureMinuteSeconde);
        setHmsPannel();
        setJourPannel();
        setMoisPannel();
        setAnneePannel();
    }
}
