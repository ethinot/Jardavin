package modele.saison;

public class Hiver extends Environnement{

    public Hiver() {
        super();
    }
    @Override
    void setHumidite() {
        humidite = (rand.nextInt(31)) + 45; // Entre 45 et 80
    }

    @Override
    void setEnsoleillement() {
        ensoleillement = (float)( 0.3 + (0.6 - 0.3) * rand.nextFloat() ); // Entre 0.3 et 0.6
    }

    @Override
    void setTemperature() {
        temperature = -8 + 17 * rand.nextFloat();
    }

    @Override
    void setSaison() {
        saison = Saisons.hiver;
    }
}
