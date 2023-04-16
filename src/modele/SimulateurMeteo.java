package modele;

import modele.Ordonnanceur;
import modele.SimulateurPotager;
import modele.environnement.Case;
import modele.environnement.CaseCultivable;
import modele.environnement.varietes.Carotte;
import modele.environnement.varietes.Salade;
import modele.environnement.varietes.Varietes;

import java.util.Random;

public class SimulateurMeteo implements Runnable {
    private SimulateurPotager simPot;

    public int humidité; // TODO : mis à jour par le simulateur de météo pour chaque case ()
    public int offsetHumidité;
    private float ensoleillement;
    public float offsetEnsoleillement;
    private float température;
    public float offsetTempérature;

    Random r = new Random();

    public SimulateurMeteo(SimulateurPotager _simPot) {
        Ordonnanceur.getOrdonnanceur().add(this);
        simPot = _simPot;
        humidité = r.nextInt(100); //Valeur entre 0 et 100
        ensoleillement = (float)Math.round(r.nextFloat(1) * 100) / 100 ; //Valeur entre 0 et 1 en float
        température = (float)Math.round((r.nextFloat(40 - (-10)) - 10) * 10) / 10; //Valeur entre -10 et 40

        System.out.println("Humidité : " + humidité);
        System.out.println("Ensoleillement : " + ensoleillement);
        System.out.println("Température : " + température);
    }

    @Override
    public void run() {
        for(int i = 0; i < simPot.SIZE_X; i++){
            for(int j = 0; j < simPot.SIZE_Y; j++){
                if(simPot.getPlateau()[i][j] instanceof CaseCultivable && ((CaseCultivable) simPot.getPlateau()[i][j]).getLegume() != null){
                    if(((CaseCultivable) simPot.getPlateau()[i][j]).getLegume() instanceof Salade){
                        if(humidité > 60 && ensoleillement > 0.6){
                            ((CaseCultivable) simPot.getPlateau()[i][j]).getLegume().tauxCroissance = 1;
                        }else if(humidité < 0.1 && ensoleillement < 0.1){
                            ((CaseCultivable) simPot.getPlateau()[i][j]).getLegume().tauxCroissance = 0.2;
                        }else{
                            ((CaseCultivable) simPot.getPlateau()[i][j]).getLegume().tauxCroissance = 0.5;
                        }
                    }else if(((CaseCultivable) simPot.getPlateau()[i][j]).getLegume() instanceof Carotte){
                        if(humidité > 65 && ensoleillement > 0.5){
                            ((CaseCultivable) simPot.getPlateau()[i][j]).getLegume().tauxCroissance = 1;
                        }else if(humidité < 0.2 && ensoleillement < 0.2){
                            ((CaseCultivable) simPot.getPlateau()[i][j]).getLegume().tauxCroissance = 0.2;
                        }else{
                            ((CaseCultivable) simPot.getPlateau()[i][j]).getLegume().tauxCroissance = 0.5;
                        }
                    }else{
                        continue;
                    }
                }else{
                    continue;
                }
            }
        }

    }

    public static void main(String[] args) {
    }
}
