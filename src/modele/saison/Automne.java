package modele.saison;

public class Automne extends Environnement{

    public Automne() {
        super();
    }
    @Override
    void setHumidite() {
        humidite = (rand.nextInt(31)) + 65; // Entre 65 et 95

    }

    @Override
    void setEnsoleillement() {
        ensoleillement = (float)( 0.4 + (0.6 - 0.4) * rand.nextFloat() ); // Entre 0.4 et 0.6

    }

    @Override
    void setTemperature() {
        temperature = 6 + (14 - 6) * rand.nextFloat();

    }

    @Override
    void setSaison() {
        saison = Saisons.automne;
    }
}
