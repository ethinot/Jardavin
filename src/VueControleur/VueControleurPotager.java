package VueControleur;

import VueControleur.composants.TempsVue;
import modele.SimulateurPotager;
import modele.environnement.CaseCultivable;
import modele.environnement.CaseNonCultivable;
import modele.environnement.varietes.Legume;
import modele.environnement.varietes.Salade;
import modele.environnement.varietes.Carotte;
import modele.environnement.varietes.Radis;
import modele.environnement.varietes.Tomate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;


/** Cette classe a deux fonctions :
 *  (1) Vue : proposer une représentation graphique de l'application (cases graphiques, etc.)
 *  (2) Controleur : écouter les évènements clavier et déclencher le traitement adapté sur le modèle
 *
 */
public class VueControleurPotager extends JFrame implements Observer {

    //region Constantes
    static final int ICONE_HEIGHT = 150;
    static final int ICONE_WIDTH = 150;
    static final int ICONE_COLUMN = 390;
    static final int ICONE_ROW = 390;
    //endregion

    //region Tailles grille
    private final int sizeX; // taille de la grille affichée
    private final int sizeY;
    //endregion

    //region Icones
    // icones affichées dans la grille
    private ImageIcon icoSalade;
    private ImageIcon icoCarotte;
    private ImageIcon icoTerre;
    private ImageIcon icoVide;
    private ImageIcon icoMur;
    private ImageIcon icoChampignon;
    private ImageIcon icoOrange;
    private ImageIcon icoTomate;
    private ImageIcon icoRadis;
    //endregion

    // Grille du potager
    private SimulateurPotager simulateurPotager; // référence sur une classe de modèle : permet d'accéder aux données du modèle pour le rafraichissement, permet de communiquer les actions clavier (ou souris)
    private Legume legumeEnMain;
    private CaseNonCultivable objetEnMain;

    private JLabel[][] tabJLabel; // cases graphique (au moment du rafraichissement, chaque case va être associée à une icône, suivant ce qui est présent dans le modèle)

    private TempsVue tempsVue;

    public VueControleurPotager(SimulateurPotager _simulateurPotager) {
        sizeX = _simulateurPotager.SIZE_X;
        sizeY = _simulateurPotager.SIZE_Y;
        simulateurPotager = _simulateurPotager;
        tempsVue = new TempsVue();
        chargerLesIcones();
        placerLesComposantsGraphiques();
    }
/*
    private void ajouterEcouteurClavier() {
        addKeyListener(new KeyAdapter() { // new KeyAdapter() { ... } est une instance de classe anonyme, il s'agit d'un objet qui correspond au controleur dans MVC
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {  // on regarde quelle touche a été pressée
                    case KeyEvent.VK_LEFT : Controle4Directions.getInstance().setDirectionCourante(Direction.gauche); break;
                    case KeyEvent.VK_RIGHT : Controle4Directions.getInstance().setDirectionCourante(Direction.droite); break;
                    case KeyEvent.VK_DOWN : Controle4Directions.getInstance().setDirectionCourante(Direction.bas); break;
                    case KeyEvent.VK_UP : Controle4Directions.getInstance().setDirectionCourante(Direction.haut); break;
                }
            }
        });
    }
*/

    private void chargerLesIcones() {
    	// image libre de droits utilisée pour les légumes : https://www.vecteezy.com/vector-art/2559196-bundle-of-fruits-and-vegetables-icons

        icoSalade = chargerIcone("Images/data.png", 0, 0, ICONE_WIDTH, ICONE_HEIGHT);//chargerIcone("Images/Pacman.png");
        icoVide = chargerIcone("Images/Vide.png");
        icoMur = chargerIcone("Images/Mur.png");
        icoTerre = chargerIcone("Images/Terre.png");
        icoCarotte = chargerIcone("Images/data.png", 1 * ICONE_ROW, 1 * ICONE_COLUMN, ICONE_WIDTH, ICONE_HEIGHT);
        icoChampignon = chargerIcone("Images/data.png", 1 * ICONE_ROW, 0 * ICONE_COLUMN, ICONE_WIDTH, ICONE_HEIGHT);
        icoOrange = chargerIcone("Images/data.png", 0 * ICONE_ROW, 2 * ICONE_COLUMN, ICONE_WIDTH, ICONE_HEIGHT);
        icoTomate = chargerIcone("Images/data.png", 8 * ICONE_ROW, 3 * ICONE_COLUMN, ICONE_WIDTH, ICONE_HEIGHT);
        icoRadis = chargerIcone("Images/data.png", 2 * ICONE_ROW, 2 * ICONE_ROW, ICONE_WIDTH, ICONE_HEIGHT);
    }

    // Procédure qui permet la construction de la fenêtre
    private void placerLesComposantsGraphiques() {
        setTitle("A vegetable garden");
        // on peut aussi lui passer un objet Dimension
        // on taille avant de setLocation pour éviter tous problèmes
        setSize(700, 500);
        // par défaut HID_ON_CLOSE
        // ici si on avait deux JFRAM cela fermerait les deux si on en ferme q'une
        // donc c'est mieux d'utiliser DISPOSE_ON_CLOSE
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // permet de terminer l'application à la fermeture de la fenêtre
        // permet de center la fenêtre au lieu d'en haut à gauche
        setLocationRelativeTo(null);

        // Barre affichage de temps
        add(tempsVue.getTempsVueConteneur(), BorderLayout.EAST);

        // Slide Bar pour accélération du temps
        //add(accelerateur.getAccelerateurConteneur(), BorderLayout.SOUTH);
        JButton bSalade = new JButton();
        bSalade.setIcon(icoSalade);
        bSalade.setMargin(new Insets(0, 0, 0, 0));
        bSalade.setContentAreaFilled(false);

        bSalade.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getSource());
                legumeEnMain = new Salade();
                //Change le curseur en salade
//                setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
//                        icoSalade.getImage(),
//                        new Point(0,0),"custom cursor"));
            }
        });
        JButton bCarotte = new JButton();
        bCarotte.setFocusPainted(false);
        bCarotte.setMargin(new Insets(0, 0, 0, 0));
        bCarotte.setContentAreaFilled(false);
        bCarotte.setIcon(icoCarotte);
        bCarotte.setBorderPainted(false);
        bCarotte.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getSource());
                legumeEnMain = new Carotte();
            }
        });

        JButton bTomate = new JButton();
        bTomate.setIcon(icoTomate);
        bTomate.setContentAreaFilled(false);
        bTomate.setBorderPainted(false);
        bTomate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                legumeEnMain = new Tomate();
            }
        });

        JButton bRadis = new JButton();
        bRadis.setIcon(icoRadis);
        bRadis.setContentAreaFilled(false);
        bRadis.setBorderPainted(false);
        bRadis.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                legumeEnMain = new Radis();
            }
        });

        JButton bTerre = new JButton();
        bTerre.setIcon(icoTerre);
        bTerre.setContentAreaFilled(false);
        bTerre.setBorderPainted(false);
        bTerre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                legumeEnMain = null;
            }
        });

        // Grille pour les cases du potager
//        JTextField jtf = new JTextField("infos diverses"); // TODO inclure dans mettreAJourAffichage ...
//        jtf.setEditable(false);
//        infos.add(jtf);

        //JToolBar toolBar = new JToolBar();
        JPanel toolBar = new JPanel();
        GridLayout toolBarLayout = new GridLayout(1, 0);
        toolBar.setLayout(toolBarLayout);
        toolBar.add(bSalade);
        toolBar.add(bCarotte);
        toolBar.add(bTomate);
        toolBar.add(bRadis);
        toolBar.add(bTerre);

        add(toolBar, BorderLayout.NORTH);

        JComponent grilleJLabels = new JPanel(new GridLayout(sizeY, sizeX)); // grilleJLabels va contenir les cases graphiques et les positionner sous la forme d'une grille

        tabJLabel = new JLabel[sizeX][sizeY];

        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                JLabel jlab = new JLabel();

                tabJLabel[x][y] = jlab; // on conserve les cases graphiques dans tabJLabel pour avoir un accès pratique à celles-ci (voir mettreAJourAffichage() )
                grilleJLabels.add(jlab);
            }
        }
        add(grilleJLabels, BorderLayout.CENTER);

        // écouter les évènements

        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                final int xx = x; // constantes utiles au fonctionnement de la classe anonyme
                final int yy = y;
                tabJLabel[x][y].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        simulateurPotager.planterLegume(xx, yy, legumeEnMain);
                    }
                });
            }
        }
    }

    
    /**
     * Il y a une grille du côté du modèle ( jeu.getGrille() ) et une grille du côté de la vue (tabJLabel)
     */
    private void mettreAJourAffichage() {

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if (simulateurPotager.getPlateau()[x][y] instanceof CaseCultivable) { // si la grille du modèle contient un Pacman, on associe l'icône Pacman du côté de la vue

                    Legume legume = ((CaseCultivable) simulateurPotager.getPlateau()[x][y]).getLegume();

                    if (legume != null) {

                        switch (legume.getVariete()) {
                            case salade: tabJLabel[x][y].setIcon(icoSalade); break;
                            case carotte: tabJLabel[x][y].setIcon(icoCarotte); break;
                            case tomate: tabJLabel[x][y].setIcon(icoTomate); break;
                            case radis: tabJLabel[x][y].setIcon(icoRadis); break;
                        }
                    } else {
                        tabJLabel[x][y].setIcon(icoTerre);
                    }

                    // si transparence : images avec canal alpha + dessins manuels (voir ci-dessous + créer composant qui redéfinie paint(Graphics g)), se documenter
                    //BufferedImage bi = getImage("Images/smick.png", 0, 0, 20, 20);
                    //tabJLabel[x][y].getGraphics().drawImage(bi, 0, 0, null);
                } else if (simulateurPotager.getPlateau()[x][y] instanceof CaseNonCultivable) {
                    tabJLabel[x][y].setIcon(icoMur);
                } else {

                    tabJLabel[x][y].setIcon(icoVide);
                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        mettreAJourAffichage();
        /*
        SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        mettreAJourAffichage();
                    }
                }); 
        */

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

    // chargement d'une sous partie de l'image
    private ImageIcon chargerIcone(String urlIcone, int x, int y, int w, int h) {
        // charger une sous partie de l'image à partir de ses coordonnées dans urlIcone
        BufferedImage bi = getSubImage(urlIcone, x, y, w, h);
        // adapter la taille de l'image a la taille du composant (ici : 20x20)
        return new ImageIcon(bi.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
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

}
