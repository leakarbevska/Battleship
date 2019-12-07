package battleship.controler;


import battleship.controler.listeners.ICommencerJeuListener;
import battleship.controler.listeners.ITerminerJeuListener;
import battleship.controler.listeners.IRepartirJeuListener;

import battleship.model.JeuParametres;

import battleship.view.DebutFrame;
import battleship.view.FinFrame;
import battleship.view.MerFrame;

/**
 * Classe qui gère le cadre en fonction de la situation. 
 * Elle implemente les interfaces ICommencerJeuListener, ITerminerJeuListener et IRepartirJeuListener.
 * @param instance une instance de la classe.
 */
public class JeuControleur implements ICommencerJeuListener, ITerminerJeuListener, IRepartirJeuListener {

    private static JeuControleur instance;

    private JeuControleur() {
    }

    /**
     * Récupére l'instance de la classe.
     * @return  l'instance.
     */
    public static JeuControleur getInstance() {
        if (instance == null) {
            instance = new JeuControleur();
        }
        return instance;
    }

    /**
     * Appelle la méthode commencerDebutFrame().
     */
    public void commencerJeu() {
        commencerDebutFrame();
    }
    
    /**
     * Fait un cadre de début.
     */
    private void commencerDebutFrame() {
        DebutFrame debutFrame = new DebutFrame(this);
        debutFrame.setVisible(true);
    }

    /**
     * Fait un cadre du jeu.
     */
    private void commencerMerFrame(JeuParametres parametres) {
        MerFrame merFrame = new MerFrame(parametres.getMer1(), parametres.getMer2(), this);
        merFrame.setVisible(true);
    }
    
    /**
     * Fait un cadre de la fin.
     */
    private void commencerFinFrame() {
        FinFrame finFrame = new FinFrame(this);
        finFrame.setVisible(true);
    }

    /**
     * éteindre le programme.
     */
    public static void quitterJeu() {
        System.exit(0);
    }
    
    /**
     * Appelle la méthode commencerMerFrame().
     * @param parametres les parametres de jeu.
     */
    @Override
    public void jeuCommencer(JeuParametres parametres) {
        commencerMerFrame(parametres);
    }
    
    /**
     * Appelle la méthode jeuTermine().
     */
    @Override
    public void jeuTermine() {
        commencerFinFrame();
    }

    /**
     * Appelle la méthode commencerDebutFrame().
     */
    @Override
    public void jeuRepartir() {
        commencerDebutFrame();
    }
}
