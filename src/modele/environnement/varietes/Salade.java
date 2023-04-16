package modele.environnement.varietes;
import modele.temps.TempsModel;
import modele.temps.composants.IncrementerJour;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

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
        tempsDeCroissanceEnHeures = tempsDeCroissance * 60;
        tempsDePlantage = temps.getTempsModel();
    }

    @Override
    public Varietes getVariete() {
        return Varietes.salade;
    }

    @Override
    protected void croissance() {
        System.out.println(temps.getTempsModel());
        System.out.println(tempsDePlantage);
        System.out.println(temps.getTempsEcouler(tempsDePlantage, temps.getTempsModel()));
        nbHeuresEcoulees = (temps.getTempsEcouler(tempsDePlantage, temps.getTempsModel())) / 3600;
        croissanceEnCours = ((double) nbHeuresEcoulees * 100 / tempsDeCroissanceEnHeures) * tauxCroissance;
        if(croissanceEnCours == 100){
            System.out.println("Récolter la salade !!!");
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Nombre d'heures écoulées : " + nbHeuresEcoulees);
        System.out.println("Salade mûre à " + df.format(croissanceEnCours) + " %");
        System.out.println("temps de croissance en heures : " + tempsDeCroissanceEnHeures);;
        System.out.println("---------------------------------------------------------");
    }
}