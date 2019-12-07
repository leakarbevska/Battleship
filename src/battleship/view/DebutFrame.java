
package battleship.view;

import battleship.controler.listeners.ICommencerJeuListener;
import battleship.model.JeuParametres;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



/**
* Classe représente la cadre du debut.
* Elle hérite la classe JFrame
*/
public class DebutFrame extends JFrame {

    private final String TITRE = "Bataille Navale";
    private final int[] TAILLE_FRAME = {600, 600};

    private JLabel l_taille, l_nBateaux, l_nom1, l_nom2;
    private JTextField tf_taille, tf_nBateaux, tf_nom1, tf_nom2;
    private JButton b_start;
    private ICommencerJeuListener iCommencerJeuListener;

    public DebutFrame(ICommencerJeuListener iCommencerJeuListener) {
        this.iCommencerJeuListener = iCommencerJeuListener;
        initialiserFrame();
    }
    
     /**
      * Création des boutons, des Étiquettes et du champ de texte et ajout de celui-ci sur le JFrame.
      */
    private void initialiserFrame() {
        this.setTitle(TITRE);
        this.setSize(TAILLE_FRAME[0], TAILLE_FRAME[1]);
        this.setLayout(new GridLayout(5, 2));
        this.setBackground(Color.blue);

        l_nom1 = new JLabel("Nom Joueur 1");
        l_nom2 = new JLabel("Nom Joueur 2");
        l_taille = new JLabel("Taille de la Mer");
        l_nBateaux = new JLabel("Longueur maximale des bateaux");

        tf_nom1 = new JTextField();
        tf_nom2 = new JTextField();
        tf_taille = new JTextField();
        tf_nBateaux = new JTextField();

        b_start = new JButton("Start");

        this.add(l_nom1);
        this.add(tf_nom1);
        this.add(l_nom2);
        this.add(tf_nom2);
        this.add(l_taille);
        this.add(tf_taille);
        this.add(l_nBateaux);
        this.add(tf_nBateaux);
        this.add(b_start);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b_start.addActionListener(onStartClicked);
    }

    /**
     * Appelle la méthode installation() si on clique dessus.
     */
    private final ActionListener onStartClicked = (ActionEvent e) -> {
        installation();
    };
    
    /**
     * Appelle la méthode jeuCommencer() sinon elle affiche que les parametres sont incorrectes ou manquantes.
     */
    private void installation() {
        try {
            this.iCommencerJeuListener.jeuCommencer(creerJeuParametres());
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Données incorrectes ou manquantes!");
        }
    }

    /**
     * Récupère les paramètres que l'utilisateur a mis.
     * @return un instance de JeuParametres.
     */
    private JeuParametres creerJeuParametres() {
        JeuParametres jeuParametres = new JeuParametres();
        jeuParametres.nom1 = DebutFrame.this.tf_nom1.getText();
        jeuParametres.nom2 = DebutFrame.this.tf_nom2.getText();
        jeuParametres.nBateaux = Integer.parseInt(DebutFrame.this.tf_nBateaux.getText());
        jeuParametres.taille = Integer.parseInt(DebutFrame.this.tf_taille.getText());
        return jeuParametres;
    }
}
