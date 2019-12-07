
package battleship.view;


import battleship.controler.JeuControleur;
import battleship.controler.listeners.IRepartirJeuListener;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


/**
* Classe représente la cadre de fin.
* Elle hérite la classe JFrame
*/
public class FinFrame extends JFrame {

    private final String TITRE = "Bataille Navale";
    private final int[] TAILLE_FRAME = {400, 400};

    private JTextField tf_gagnant;
    private JButton b_njeu, b_quitter;
    private IRepartirJeuListener iRepartirJeuListener;

    public FinFrame(IRepartirJeuListener iRepartirJeuListener) {
        this.iRepartirJeuListener = iRepartirJeuListener;
        initializeFrame();
    }
     /**
      * Création des boutons et du champ de texte et ajout de celui-ci sur le JFrame.
      */
    private void initializeFrame() {
        this.setTitle(TITRE);
        this.setSize(TAILLE_FRAME[0], TAILLE_FRAME[1]);
        this.setLayout(new GridLayout(3, 1));

        tf_gagnant = new JTextField();
        b_njeu = new JButton("Nouveau Jeu");
        b_quitter = new JButton("Quitter");
        tf_gagnant.setText(String.format("LA FIN!"));
        tf_gagnant.setHorizontalAlignment(JTextField.CENTER);


        this.add(tf_gagnant);
        this.add(b_njeu);
        this.add(b_quitter);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b_njeu.addActionListener(onNjeuClicked);
        b_quitter.addActionListener(onQuitterClicked);
    }

    /**
     * ActionListener qui appelle une méthode pour commencer une nouvelle cadre.
     */
    private final ActionListener onNjeuClicked = (ActionEvent e) -> {
        this.iRepartirJeuListener.jeuRepartir();
        this.dispose();
    };
   
    /**
     * ActionListener qui quitte le programme.
     */
    private final ActionListener onQuitterClicked = (ActionEvent e) -> {
        JeuControleur.quitterJeu();
    };
}
