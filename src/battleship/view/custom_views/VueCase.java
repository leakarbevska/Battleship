
package battleship.view.custom_views;

import battleship.controler.listeners.MouseEventDemo;
import battleship.controler.listeners.IJeuBoucleListener;
import battleship.model.Bateau;
import battleship.model.Case;
import battleship.model.Joueur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;


/**
* Classe représente le panel d'une case et .
* Elle hérite la classe JPanel et l'implemente l'interface Observer.
 */
public class VueCase extends JPanel implements Observer {

    private Case cas;
    private IJeuBoucleListener iGameLoopListener;
    
    /**
     * Construit un panel pour la case.
     * @param cas une instance de la classe Case.
     * @param iGameLoopListener une instance de l'interface iGameLoopListener.
     */
    public VueCase(Case cas, IJeuBoucleListener iGameLoopListener) {
        super();
        this.cas = cas;
        this.iGameLoopListener = iGameLoopListener;
        this.cas.addObserver(this);
        if (!cas.getMer().getJoueur().getNom().equals(Joueur.RANDOM_JOUEUR_NOM)) {
            this.addMouseListener(new MouseEventDemo(this));
        }
    }
    
    /**
     * 
     * @return l'objet de la classe Case.
     */
    public Case getCase() {
        return this.cas;
    }
    
    /**
     * Dessine des rectangles et des ovales en fonction de la situation du champ.
     * @param g l'object de la classe Graphics.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Dimension dim = this.getSize();
        
        int ovalX = dim.width/4;
        int ovalY = dim.height/4;
        int oval_taille = dim.height/2;
        
        int recX = dim.width/4;
        int recY = dim.height/4;
        int rec_taille = dim.height/2;       
        
        if (this.cas.getMer().estRandomJoueur() && cas.getBateau() != null) {
            g.drawRect(recX, recY, rec_taille, rec_taille);
        }
        if (cas.getTir() != null) {
            if (cas.getBateau() != null) {
                g.setColor(Color.RED);
                g.fillOval(ovalX, ovalY, oval_taille, oval_taille);
                if(!this.cas.getMer().estRandomJoueur()){
                    if(this.cas.getMer().getBateauxMorts().contains(this.cas.getBateau())){
                        g.setColor(Color.BLACK);
                        g.drawRect(recX, recY, rec_taille, rec_taille);
                    }
                }
            } else {
                g.setColor(Color.GREEN);
                g.fillOval(ovalX, ovalY, oval_taille, oval_taille);
            }
        }
        this.setBorder(new LineBorder(Color.GRAY, 1, false));
    }

    /**
     * Repeint le cadre et vérifie la situation du jeu.
     * @param o l'objet de la classe Observable.
     * @param arg l'objet de la classe Object.
     */
    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
        System.out.println(this.cas.getMer().toString());
        if (this.iGameLoopListener != null && this.cas.getMer().estTermine()) {
            this.iGameLoopListener.jeuTermine(this.cas.getMer());
        } else {
            this.iGameLoopListener.tourJoueurFini(this.cas.getMer());
        }
    }
}
