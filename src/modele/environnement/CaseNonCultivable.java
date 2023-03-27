package modele.environnement;

import modele.SimulateurPotager;

public class CaseNonCultivable extends Case {

    private CaseNonCultivable objet;
    public CaseNonCultivable(SimulateurPotager _simulateurPotager) {
        super(_simulateurPotager);
    }

    @Override
    public void actionUtilisateur() {

    }

    @Override
    public void run() {
        // TODO
    }
}
