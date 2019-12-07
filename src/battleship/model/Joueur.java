
package battleship.model;

/**
* Classe abstraite qui signifie un joueur.
*/
public abstract class Joueur {

    public static final String RANDOM_JOUEUR_NOM = "Random";
    public static final int JOUEUR_1 = 1;
    public static final int JOUEUR_2 = 2;
    
    public int nombreJoueur;

    /**
     * Choisit une position où tirer.
     * @return une position.
     */
    public abstract Position choisirCoup(Mer mer);

    /**
     * Récupére le nom du joueur.
     * @return le nom.
     */
    public abstract String getNom();
}
