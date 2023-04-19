package modele.environnement.varietes;

import VueControleur.composants.IconesVue;
import modele.environnement.varietes.conditionsCroissance.CarotteCondition;
import modele.environnement.varietes.conditionsCroissance.SaladeCondition;

import javax.swing.*;
import java.awt.*;

public class Carotte extends  Legume {

    public Carotte(){
        iconeLegume = new IconesVue().getIconesVue().getIcoCarotte();
        setIcone(iconeLegume, 1, 1, 1);
        conditionsFavorable = new CarotteCondition();
        System.out.println("Vous avez planté votre salade le " + jourDePlantage + " de ce mois");
        if(jourDeRecolte < jourDePlantage){
            System.out.println("Vous devrez la récolter le " + jourDeRecolte + " du mois prochain");
        }else{
            System.out.println("Vous devrez la récolter le " + jourDeRecolte + " de ce mois");
        }
        tempsDeCroissance = 60;
        tempsDeCroissanceEnHeures = tempsDeCroissance * 24;
        tempsDePlantage = temps.getTempsModel();
    }

    @Override
    public Varietes getVariete() {
        return Varietes.carotte;
    }

    @Override
    protected void croissance() {
        nbHeuresEcoulees = (temps.getTempsEcouler(tempsDePlantage, temps.getTempsModel())) / 3600;
        croissanceEnCours = ((double) nbHeuresEcoulees * 100 / tempsDeCroissanceEnHeures) * tauxCroissance;
        if(croissanceEnCours >= 100){
            System.out.println("Récolter la carotte !!!");
            croissanceEnCours = 100;
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Nombre d'heures écoulées : " + nbHeuresEcoulees);
        System.out.println("Carotte mûre à " + df.format(croissanceEnCours) + " %");
        System.out.println("temps de croissance en heures : " + tempsDeCroissanceEnHeures);;
        System.out.println("Taux de croissance " + df.format(tauxCroissance) + " %");
    }

    public ImageIcon setIcone(ImageIcon icon, int NEW_WIDTH, int NEW_HEIGHT, int croissanceEnCours) {
        Image img = icon.getImage() ;
        Image newimg = img.getScaledInstance( NEW_WIDTH + (croissanceEnCours / 5), NEW_HEIGHT + (croissanceEnCours / 5),  java.awt.Image.SCALE_SMOOTH ) ;
        return icon = new ImageIcon( newimg );
    }

}
