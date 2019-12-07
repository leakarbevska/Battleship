
package battleship.model;

/**
 * Classe qui représente les paramètres du jeu.
 */
public class JeuParametres {
    public String nom1;
    public String nom2;
    public int nBateaux;
    public int taille;

    public JeuParametres() {}
    
    /**
     * Construit l'instance de JeuParametres.
     * @param nom1 le nom du joueur un.
     * @param nom2 le nom du joueur deux.
     * @param nBateaux la longeur des bateaux.
     * @param taille la taille de la grille.
     */
    public JeuParametres(String nom1, String nom2, int nBateaux, int taille) {
        this.nom1 = nom1;
        this.nom2 = nom2;
        this.nBateaux = nBateaux;
        this.taille = taille;
    }
    
    /**
     * Construit une instance de la classe Mer avec le premiere nom.
     * @return la premiere mer.
     */
    public Mer getMer1() {
        Mer mer = new Mer(nom1, taille, Joueur.JOUEUR_1);
        mer.aleatoirePlacerBateaux(nBateaux);
        return mer;
    }
    
    /**
     * Construit une instance de la classe Mer avec le deuxieme nom.
     * @return la deuxieme mer. 
     */
    public Mer getMer2() {
        Mer mer = new Mer(nom2, taille, Joueur.JOUEUR_2);
        mer.aleatoirePlacerBateaux(nBateaux);
        return mer;
    }
}
