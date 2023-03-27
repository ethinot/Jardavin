package modele.environnement;

import modele.SimulateurPotager;
import modele.environnement.varietes.Carotte;
import modele.environnement.varietes.Legume;
import modele.environnement.varietes.Salade;
import modele.environnement.varietes.Varietes;

public class CaseCultivable extends Case {

    private Legume legume;
    public CaseCultivable(SimulateurPotager _simulateurPotager) {
        super(_simulateurPotager);
    }

    @Override
    public void actionUtilisateur() {
        if (legume == null) {
            legume = new Carotte();
            System.out.println(legume.getVariete());
        } else {
            legume = null;
        }
    }

    public void planterLegume(Legume _legume){
        legume = _legume;
    }

//    private Legume changementLegume(){
//        switch (legume.getVariete()) {
//            case salade : return legume = new Salade();
//            case carotte : return legume = new Carotte();
//            default : return legume;
//        }
//    }

    public Legume getLegume() {
        return legume;
    }

    public void setLegume(Legume _legume){
        legume = _legume;
    }

    @Override
    public void run() {
        if (legume != null) {
            legume.nextStep();
        }
    }
}
