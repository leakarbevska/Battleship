
package battleship.model;


import java.util.Random;

/** 
 * Classe du joueur aléatoire qui implémente la classe Joueur
 */
public class RandomJoueur extends Joueur {
    private String nom;
    
    public RandomJoueur(String nom, int nombreJoueur){
        this.nom = nom;
        this.nombreJoueur = nombreJoueur;
    }
    
    @Override
    public String getNom(){
        return this.nom;
    }
    
    @Override
    public Position choisirCoup(Mer mer){
        Random rand = new Random();
        return  mer.getValideCoups().get(rand.nextInt(mer.getValideCoups().size()));
    }
    
}
