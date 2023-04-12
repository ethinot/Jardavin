package modele.temps;

import java.util.TimerTask;

public class IncrementerTempsModel extends TimerTask {
    private TempsModel tempsModel;

    public IncrementerTempsModel(TempsModel tempsModel) {
        this.tempsModel = tempsModel;
    }
    @Override
    public void run() {
        tempsModel.setTempsModel(tempsModel.getTempsModel().plusSeconds(1));
    }
}
