package modele;
import modele.environnement.varietes.*;

public class Inventaire{

    int nbSalades = 0;
    int nbTomates = 0;
    int nbRadis = 0;
    int nbCarotte = 0;

    public Inventaire(){
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

    public void ajoutSalade(){
        this.nbSalades++;
    }

    public void ajoutCarotte(){
        this.nbCarotte++;
    }

    public void ajoutTomate(){
        this.nbTomates++;
    }

    public void ajoutRadis(){
        this.nbRadis++;
    }

}
