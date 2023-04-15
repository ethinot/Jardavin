package modele.environnement.varietes;
import modele.temps.TempsModel;
import modele.temps.composants.IncrementerJour;

import java.text.DecimalFormat;

public class Salade extends Legume {
    //Valeur affectant la croissance selon la météo favorable ou non
    public double tauxCroissance = 1.0;

    public Salade(){
        System.out.println("Vous avez planté votre salade le " + jourDePlantage + " de ce mois");
        if(jourDeRecolte < jourDePlantage){
            System.out.println("Vous devrez la récolter le " + jourDeRecolte + " du mois prochain");
        }else{
            System.out.println("Vous devrez la récolter le " + jourDeRecolte + " de ce mois");
        }
        tempsDeCroissance = 21;
    }

    @Override
    public Varietes getVariete() {
        return Varietes.salade;
    }

    @Override
    protected void croissance() {
        nbHeuresEcoulees = (temps.getTempsEnSeconde() / 3600) - tempsDePlantage;
        croissanceEnCours = ((double) nbHeuresEcoulees * 100 / tempsDeCroissanceEnHeures) * tauxCroissance;
        if(croissanceEnCours == 100){
            System.out.println("Récolter la salade !!!");
        }
        System.out.println("Salade mûre à " + df.format(croissanceEnCours) + " %");
        System.out.println(tempsDeCroissanceEnHeures);
        System.out.println(temps.getTempsEnSeconde());
    }
}