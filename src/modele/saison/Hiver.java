package modele.saison;

public class Hiver extends Environnement{

    public Hiver() {
        super();
    }
    @Override
    void setHumidite() {
        humidite = (rand.nextInt(31)) + 50; // Entre 50 et 80
    }

    @Override
    void setEnsoleillement() {
        ensoleillement = (float)( 0.3 + (0.5 - 0.3) * rand.nextFloat() ); // Entre 0.3 et 0.5
    }

    @Override
    void setTemperature() {
        temperature = 10 * rand.nextFloat();
    }

    @Override
    void setSaison() {
        saison = Saisons.hiver;
    }
}
