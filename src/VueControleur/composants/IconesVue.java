package VueControleur.composants;

import VueControleur.VueControleurPotager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IconesVue {

    private static IconesVue iconesVue;

    public IconesVue getIconesVue(){
        if(iconesVue == null){
            iconesVue = new IconesVue();
        }
        return iconesVue;
    }

    //region Constantes
    static final int ICONE_HEIGHT = 150;
    static final int ICONE_WIDTH = 150;
    static final int ICONE_COLUMN = 390;
    static final int ICONE_ROW = 390;
    //endregion

    private ImageIcon icoSalade;
    private ImageIcon icoCarotte;
    private ImageIcon icoTerre;
    private ImageIcon icoVide;
    private ImageIcon icoMur;
    private ImageIcon icoChampignon;
    private ImageIcon icoOrange;
    private ImageIcon icoTomate;
    private ImageIcon icoRadis;
    private ImageIcon icoRateau;
    private ImageIcon icoPelle;
    private ImageIcon icoPousse;
    private ImageIcon icoHerbe;
    private ImageIcon icoSacADos;

    public void chargerLesIcones() {

        // image libre de droits utilisée pour les légumes : https://www.vecteezy.com/vector-art/2559196-bundle-of-fruits-and-vegetables-icons
        icoSalade = chargerIcone("Images/data.png", 0, 0, ICONE_WIDTH, ICONE_HEIGHT);
        icoVide = chargerIcone("Images/Vide.png");
        icoMur = chargerIcone("Images/Mur.png");
        icoTerre = chargerIcone("Images/sol.png", 0, 0, 512, 512);
        icoCarotte = chargerIcone("Images/data.png", 1 * ICONE_ROW, 1 * ICONE_COLUMN, ICONE_WIDTH, ICONE_HEIGHT);
        icoChampignon = chargerIcone("Images/data.png", 1 * ICONE_ROW, 0 * ICONE_COLUMN, ICONE_WIDTH, ICONE_HEIGHT);
        icoOrange = chargerIcone("Images/data.png", 0 * ICONE_ROW, 2 * ICONE_COLUMN, ICONE_WIDTH, ICONE_HEIGHT);
        icoTomate = chargerIcone("Images/data.png", 8 * ICONE_ROW, 3 * ICONE_COLUMN, ICONE_WIDTH, ICONE_HEIGHT);
        icoRadis = chargerIcone("Images/data.png", 2 * ICONE_ROW, 2 * ICONE_ROW, ICONE_WIDTH, ICONE_HEIGHT);
        icoRateau = chargerIcone("Images/rateau.png", 0, 0, 512, 512);
        icoPelle = chargerIcone("Images/pelle.png", 0, 0, 512, 512);
        icoPousse = chargerIcone("Images/pousse.png", 0, 0, 512, 512);
        icoHerbe = chargerIcone("Images/herbe.png", 0 ,0, 512, 512);
        icoSacADos = chargerIcone("Images/sac-a-dos.png", 0, 0, 512, 512);

    }

    // chargement d'une sous partie de l'image
    private ImageIcon chargerIcone(String urlIcone, int x, int y, int w, int h) {
        // charger une sous partie de l'image à partir de ses coordonnées dans urlIcone
        BufferedImage bi = getSubImage(urlIcone, x, y, w, h);
        // adapter la taille de l'image a la taille du composant (ici : 20x20)
        return new ImageIcon(bi.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
    }

    // chargement de l'image entière comme icone
    private ImageIcon chargerIcone(String urlIcone) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(urlIcone));
        } catch (IOException ex) {
            Logger.getLogger(VueControleurPotager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }


        return new ImageIcon(image);
    }

    private BufferedImage getSubImage(String urlIcone, int x, int y, int w, int h) {
        BufferedImage image = null;

        try {
            File f = new File(urlIcone);
            image = ImageIO.read(new File(urlIcone));
        } catch (IOException ex) {
            Logger.getLogger(VueControleurPotager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        BufferedImage bi = image.getSubimage(x, y, w, h);
        return bi;
    }

    public ImageIcon getIcoSalade(){return icoSalade; }
    public ImageIcon getIcoCarotte(){return icoCarotte; }
    public ImageIcon getIcoTerre(){return icoTerre; }
    public ImageIcon getIcoVide(){return icoVide; }
    public ImageIcon getIcoMur(){return icoMur; }
    public ImageIcon getIcoChampignon(){return icoChampignon; }
    public ImageIcon getIcoOrange(){return icoOrange; }
    public ImageIcon getIcoTomate(){return icoTomate; }
    public ImageIcon getIcoRadis(){return icoRadis; }
    public ImageIcon getIcoRateau(){return icoRateau; }
    public ImageIcon getIcoPelle(){return icoPelle; }
    public ImageIcon getIcoPousse(){return icoPousse; }
    public ImageIcon getIcoHerbe(){return icoHerbe; }
    public ImageIcon getIcoSacADos(){return icoSacADos; }
}

