package modele.environnement.varietes;

import VueControleur.IconesVue;
import modele.environnement.varietes.conditionsCroissance.RadisCondition;
import modele.environnement.varietes.conditionsCroissance.SaladeCondition;

import javax.swing.*;
import java.awt.*;

public class Radis extends Legume{

    public Radis(){
        iconeLegume = new IconesVue().getIconesVue().getIcoRadis();
        setIcone(iconeLegume, 1, 1, 1);
        conditionsFavorable = new RadisCondition();
        System.out.println("Vous avez planté votre salade le " + jourDePlantage + " de ce mois");
        if(jourDeRecolte < jourDePlantage){
            System.out.println("Vous devrez la récolter le " + jourDeRecolte + " du mois prochain");
        }else{
            System.out.println("Vous devrez la récolter le " + jourDeRecolte + " de ce mois");
        }
        tempsDeCroissance = 45;
        tempsDeCroissanceEnHeures = tempsDeCroissance * 24;
        tempsDePlantage = temps.getTempsModel();
    }

    @Override
    public Varietes getVariete() {
        return Varietes.radis;
    }

    @Override
    protected void croissance() {
        nbHeuresEcoulees = (temps.getTempsEcouler(tempsDePlantage, temps.getTempsModel())) / 3600;
        croissanceEnCours = ((double) nbHeuresEcoulees * 100 / tempsDeCroissanceEnHeures) * tauxCroissance;
        if(croissanceEnCours >= 100){
            System.out.println("Récolter le radis !!!");
            croissanceEnCours = 100;
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Nombre d'heures écoulées : " + nbHeuresEcoulees);
        System.out.println("Radis mûre à " + df.format(croissanceEnCours) + " %");
        System.out.println("temps de croissance en heures : " + tempsDeCroissanceEnHeures);;
        System.out.println("Taux de croissance " + df.format(tauxCroissance) + " %");
    }

    public ImageIcon setIcone(ImageIcon icon, int NEW_WIDTH, int NEW_HEIGHT, int croissanceEnCours) {
        Image img = icon.getImage() ;
        Image newimg = img.getScaledInstance( NEW_WIDTH + (croissanceEnCours / 5), NEW_HEIGHT + (croissanceEnCours / 5),  java.awt.Image.SCALE_SMOOTH ) ;
        return icon = new ImageIcon( newimg );
    }
}
