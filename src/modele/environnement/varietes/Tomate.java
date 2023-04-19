package modele.environnement.varietes;

import VueControleur.IconesVue;
import modele.environnement.varietes.conditionsCroissance.CarotteCondition;
import modele.environnement.varietes.conditionsCroissance.TomateCondition;

import javax.swing.*;
import java.awt.*;

public class Tomate extends Legume{

    public Tomate(){
        iconeLegume = new IconesVue().getIconesVue().getIcoTomate();
        setIcone(iconeLegume, 1, 1, 1);
        conditionsFavorable = new TomateCondition();
        System.out.println("Vous avez planté votre salade le " + jourDePlantage + " de ce mois");
        if(jourDeRecolte < jourDePlantage){
            System.out.println("Vous devrez la récolter le " + jourDeRecolte + " du mois prochain");
        }else{
            System.out.println("Vous devrez la récolter le " + jourDeRecolte + " de ce mois");
        }
        tempsDeCroissance = 90;
        tempsDeCroissanceEnHeures = tempsDeCroissance * 24;
        tempsDePlantage = temps.getTempsModel();
    }

    @Override
    public Varietes getVariete() {
        return Varietes.tomate;
    }

    @Override
    protected void croissance() {
        nbHeuresEcoulees = (temps.getTempsEcouler(tempsDePlantage, temps.getTempsModel())) / 3600;
        croissanceEnCours = ((double) nbHeuresEcoulees * 100 / tempsDeCroissanceEnHeures) * tauxCroissance;
        if(croissanceEnCours >= 100){
            System.out.println("Récolter la Tomate !!!");
            croissanceEnCours = 100;
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Nombre d'heures écoulées : " + nbHeuresEcoulees);
        System.out.println("Tomate mûre à " + df.format(croissanceEnCours) + " %");
        System.out.println("temps de croissance en heures : " + tempsDeCroissanceEnHeures);;
        System.out.println("Taux de croissance " + df.format(tauxCroissance) + " %");
    }
}
