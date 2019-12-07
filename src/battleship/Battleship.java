package battleship;


import battleship.controler.JeuControleur;


public class Battleship {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JeuControleur.getInstance().commencerJeu();
    }
}
