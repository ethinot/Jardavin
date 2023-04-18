/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;


import modele.environnement.Case;
import modele.environnement.CaseCultivable;
import modele.environnement.CaseNonCultivable;
import modele.environnement.varietes.Legume;
import modele.environnement.varietes.*;

import java.awt.Point;
import java.util.Random;


public class SimulateurPotager {

    // final est équivalent à const en c++
    public static final int SIZE_X = 20;
    public static final int SIZE_Y = 10;

    private SimulateurMeteo simMet;

    // private HashMap<Case, Point> map = new  HashMap<Case, Point>(); // permet de récupérer la position d'une entité à partir de sa référence
    private Case[][] grilleCases = new Case[SIZE_X][SIZE_Y]; // permet de récupérer une entité à partir de ses coordonnées

    public Inventaire inventaire;

    public SimulateurPotager() {

        initialisationDesEntites();

        simMet = new SimulateurMeteo(this);

        inventaire = new Inventaire();

    }


    
    public Case[][] getPlateau() {
        return grilleCases;
    }
    
    private void initialisationDesEntites() {

        // murs extérieurs horizontaux
        for (int x = 0; x < 20; x++) {
            addEntite(new CaseNonCultivable(this), x, 0);
            addEntite(new CaseNonCultivable(this), x, 9);
        }

        // murs extérieurs verticaux
        for (int y = 1; y < 9; y++) {
            addEntite(new CaseNonCultivable(this), 0, y);
            addEntite(new CaseNonCultivable(this), 19, y);
        }

        addEntite(new CaseNonCultivable(this), 2, 6);
        addEntite(new CaseNonCultivable(this), 3, 6);

        Random rnd = new Random();

        for (int x = 5; x < 15; x++) {
            for (int y = 3; y < 7; y++) {
                CaseCultivable cc = new CaseCultivable(this);
                addEntite(cc , x, y);
                if (rnd.nextBoolean()) {
                    cc.actionUtilisateur();
                }

                Ordonnanceur.getOrdonnanceur().add(cc);

            }
        }

    }

    public void actionUtilisateur(int x, int y) {
        if (grilleCases[x][y] != null) {
            grilleCases[x][y].actionUtilisateur();
        }
    }

    public void planterLegume(int x, int y, Legume legume) {
        if (grilleCases[x][y] != null) {
            grilleCases[x][y].planterLegume(legume);
        }
    }

    private void addEntite(Case e, int x, int y) {
        grilleCases[x][y] = e;
        //map.put(e, new Point(x, y));
    }

    public void recolterLegume(int x, int y, Legume _legume){
        if(grilleCases[x][y] != null && grilleCases[x][y] instanceof CaseCultivable){

            switch (_legume.getVariete()) {
                case salade: inventaire.nbSalades++; break;
                case carotte: inventaire.nbCarotte++; break;
                case tomate: inventaire.nbTomates++; break;
                case radis: inventaire.nbRadis++; break;
            }
        }
        System.out.println("NbSalades : " + inventaire.nbSalades);
        System.out.println("NbTomates : " + inventaire.nbTomates);
        System.out.println("NbCarottes : " + inventaire.nbCarotte);
        System.out.println("NbRadis : " + inventaire.nbRadis);

    }

    public void rendreCultivable(int x, int y){
        if(grilleCases[x][y] != null){
            ((CaseCultivable) grilleCases[x][y]).estCultivable = true;
        }
    }

    public void rendreIncultivable(int x, int y){
        if(grilleCases[x][y] != null){
            ((CaseCultivable) grilleCases[x][y]).estCultivable = false;
        }
    }

    public Inventaire getInventaire(){
        return inventaire;
    }

    private Case objetALaPosition(Point p) {
        Case retour = null;
        return grilleCases[p.x][p.y];
    }

}
