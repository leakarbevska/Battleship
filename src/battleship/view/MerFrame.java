package battleship.view;


import battleship.view.custom_views.VueMer;

import battleship.controler.listeners.ITerminerJeuListener;
import battleship.controler.listeners.IJeuBoucleListener;

import battleship.model.Joueur;
import battleship.model.Mer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



/**
* Classe représente la cadre du jeu principal.
* Elle hérite la classe JFrame et aussi implemente l'interface IJeuBoucleListener.
*/
public class MerFrame extends JFrame implements IJeuBoucleListener {
    private final String TITRE = "Bataille Navale";
    private final int[] TAILLE_FRAME = {1200,600};

    private Mer mer1;
    private Mer mer2;
    private ITerminerJeuListener iTerminerJeuListener;

    /**
     * Construit l'instance de la cadre du jeu avec deux grille.
     * @param mer1 la premiere grille.
     * @param mer2 la deuxieme grille.
     * @param iTerminerJeuListener une instance de iTerminerJeuListener.
     */
    public MerFrame(Mer mer1, Mer mer2, ITerminerJeuListener iTerminerJeuListener){
        this.mer2 = mer2;
        this.mer1 = mer1;
        this.iTerminerJeuListener = iTerminerJeuListener;
        initialiserFrame();
    }
    
    /**
     * Construit un cadre pour le jeu.
     */
    private void initialiserFrame() {
        this.setTitle(TITRE);
        this.setSize(TAILLE_FRAME[0], TAILLE_FRAME[1]);
        this.setLayout(new GridLayout(1,2));

        this.add(new VueMer(mer1, this));
        this.add(new VueMer(mer2, this));

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Définit la visibilité du cadre et appele la methode changeTour.
     * @param b un boolean.
     */
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        changeTour(mer1);
    }

    /**
     * Appele la methode changeTour et affiche si un bateau a coulé.
     * @param mer 
     */
    @Override
    public void tourJoueurFini(Mer mer) {
        if(mer.bateauCouler()){
            JOptionPane.showMessageDialog(this, String.format("Le bateau a coulé!"));
        }
        changeTour(joueurSuivant(mer));
    }

    /**
     * Affiche le joueur qui a gagne et appele la methode jeuTermine().
     * @param mer_gagnant la mer qui a gagne.
     */
    @Override
    public void jeuTermine(Mer mer_gagnant) {
        String gagnant = mer_gagnant.getJoueur().getNom();
        gagnant += mer_gagnant.estRandomJoueur() ? String.format(" %d",mer_gagnant.getJoueur().nombreJoueur) : "";
        JOptionPane.showMessageDialog(this, String.format("%s a gagné!",gagnant));
        this.iTerminerJeuListener.jeuTermine();
        this.dispose();
    }
    
    /**
     * Change le tour du joueur.
     * @param mer 
     */
    private void changeTour(Mer mer) {
        if(mer.estRandomJoueur()) {
            mer.randomPlacement();
        }
    }

   /**
    * Change la mer courrante.
    * @param currentMer la mer courrante.
    * @return la mer.
    */ 
    private Mer joueurSuivant(Mer currentMer){
        if(currentMer.getNombreJoueur() == Joueur.JOUEUR_1) {
            return mer2;
        }
        return mer1;
    }
}
