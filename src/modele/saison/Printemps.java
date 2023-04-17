package modele.saison;

public class Printemps extends Environnement{

    public Printemps() {
        super();
    }

    @Override
    void setHumidite() {
        humidite = (rand.nextInt(21)) + 40; // Entre 40 et 60
    }

    @Override
    void setEnsoleillement() {
        ensoleillement = (float)( 0.5 + (0.7 - 0.5) * rand.nextFloat() ); // Entre 0.5 et 0.7
    }

    @Override
    void setTemperature() {
        temperature = 9 + (20 - 9) * rand.nextFloat();
    }

    @Override
    void setSaison() {
        saison = Saisons.printemps;
    }
}
