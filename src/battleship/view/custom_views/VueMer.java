
package battleship.view.custom_views;

import battleship.controler.listeners.IJeuBoucleListener;
import battleship.model.Mer;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**
* Classe représente le panel d'un mer.
* Elle hérite la classe JPanel.
 */
public class VueMer extends JPanel {
    private Mer mer;

    private final static int TAILLE_MER = 600;

    /**
     * Construit un panel. 
     * @param mer la mer.
     * @param iJeuBoucleListener l'instance de l'interface.
     */
    public VueMer(Mer mer, IJeuBoucleListener iJeuBoucleListener) {
        super();
        this.mer = mer;

        int ch = 64;
        int n = 0;

        this.setLayout(new GridLayout(mer.getN() + 1, mer.getN() + 1));
        this.setSize(TAILLE_MER, TAILLE_MER);

        JLabel jk = new JLabel(" "); //champ du coin plus haut gauche vide
        this.add(jk);

        // champs de numérotation
        for (int i = 0; i < mer.getN(); i++) {  //affichage des nombres au dessus de la matrice 
            ch++;
            JLabel jl = new JLabel(Character.toString((char) (ch)), SwingConstants.CENTER);
            this.add(jl);
        }

        for (int i = 1; i <= mer.getN(); i++) { // affichage des lettres sur le côté gauche de la matrice
            for (int j = 1; j <= mer.getN(); j++) {
                if (j == 1) {
                    JLabel jl = new JLabel(Integer.toString(n + 1), SwingConstants.CENTER);
                    this.add(jl);
                    n++;
                }
                this.add(new VueCase(mer.getMer()[i - 1][j - 1], iJeuBoucleListener));
            }
        }
        
        
    }
}
