package modele;
import modele.environnement.varietes.*;

public class Inventaire {

    int nbSalades;
    int nbTomates;
    int nbRadis;
    int nbCarotte;

    public Inventaire(){
        nbSalades = 0;
        nbTomates = 0;
        nbRadis = 0;
        nbCarotte = 0;
    }

    public int getNbSalades(){
        return nbSalades;
    }
    public int getNbCarotte(){
        return nbCarotte;
    }
    public int getNbTomates(){
        return nbTomates;
    }
    public int getNbRadis(){
        return nbRadis;
    }

    public void setNbSalades(int nb){
        nbSalades = nb;
    }
    public void setNbCarotte(int nb){
        nbCarotte = nb;
    }
    public void setNbTomates(int nb){
        nbTomates = nb;
    }
    public void setNbRadis(int nb){
        nbRadis = nb;
    }
}
