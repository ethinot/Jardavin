package modele.saison;

public class Ete extends Environnement{

    public Ete() {
        super();
    }
    @Override
    void setHumidite() {
        humidite = (rand.nextInt(21)) + 10; // Entre 10 et 30
    }

    @Override
    void setEnsoleillement() {
        ensoleillement = (float)( 0.75 + (0.9 - 0.75) * rand.nextFloat() ); // Entre 0.75 et 0.9
    }

    @Override
    void setTemperature() {
        temperature = 25 + (36 - 25) * rand.nextFloat();
    }

    @Override
    void setSaison() {
        saison = Saisons.ete;
    }
}
