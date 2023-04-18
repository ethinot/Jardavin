
import VueControleur.VueControleurPotager;
import modele.Inventaire;
import modele.Ordonnanceur;
import modele.SimulateurPotager;
import modele.temps.TempsModel;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Main {
    // Avec throw Exception je laisse la JVM d'afficher l'exception
    public static void main(String[] args) throws Exception{
        // Style pour les différents components
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        SimulateurPotager simulateurPotager = new SimulateurPotager();
        Inventaire inventaire = simulateurPotager.getInventaire();
        VueControleurPotager vc = new VueControleurPotager(simulateurPotager);
        vc.setVisible(true);
        Ordonnanceur.getOrdonnanceur().setSimulateurPotager(simulateurPotager);
        Ordonnanceur.getOrdonnanceur().addObserver(vc);
        Ordonnanceur.getOrdonnanceur().start(2001, 4, 9);
    }
}
