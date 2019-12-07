
package battleship.model;

/**
* Classe qui signifie un joueur humain.
* Elle hérite la classe abstraite Joueur.
*/
public class Humain extends Joueur{
    private String nom;
    
    public Humain(String nom, int nombreJoueur){
        this.nom = nom;
        this.nombreJoueur = nombreJoueur;
    }
    
    @Override
    public String getNom(){
        return this.nom;
    }

    @Override
   public Position choisirCoup(Mer mer) {
       return null;
    }
    
}
