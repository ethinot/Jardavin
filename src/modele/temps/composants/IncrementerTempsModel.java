package modele.temps.composants;

import modele.temps.TempsModel;

import java.util.TimerTask;

abstract public class IncrementerTempsModel extends TimerTask {
    abstract public Duree getDuree();
}
