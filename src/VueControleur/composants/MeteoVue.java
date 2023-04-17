package VueControleur.composants;

import VueControleur.composants.meteoComposants.Ensoleillement;
import VueControleur.composants.meteoComposants.Humidite;
import VueControleur.composants.meteoComposants.Saison;
import VueControleur.composants.meteoComposants.Temperature;

import javax.swing.*;
import java.awt.*;

public class MeteoVue {

    private JPanel meteoVueContainer = new JPanel();
    private Humidite humidite;
    private Ensoleillement ensoleillement;
    private Temperature temperature;
    private Saison saison;

    public MeteoVue() {
        meteoVueContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
        humidite = new Humidite();
        ensoleillement = new Ensoleillement();
        temperature = new Temperature();
        saison = new Saison();
        meteoVueContainer.add(humidite.getMeteoComposantConteneur());
        meteoVueContainer.add(ensoleillement.getMeteoComposantConteneur());
        meteoVueContainer.add(temperature.getMeteoComposantConteneur());
        meteoVueContainer.add(saison.getMeteoComposantConteneur());
    }

    public JPanel getMeteoVueContainer() {
        return meteoVueContainer;
    }
}
