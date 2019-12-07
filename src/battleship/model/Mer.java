
package battleship.model;


import java.util.Observable;
import java.util.ArrayList;
import java.util.Random;


/**
 * Classe qui represente une mer.
 */
public class Mer extends Observable {

    private Joueur joueur;
    private int n;
    private Case[][] mer;

    private ArrayList<Bateau> bateauxVivants = new ArrayList<Bateau>();
    private ArrayList<Bateau> bateauxMorts = new ArrayList<Bateau>();

    /**
     * Construit l'instance de la Mer.
     * @param nom le nom du joueur.
     * @param taille la taille de la grille.
     * @param playerNum le nombre du joueur.
     */
    public Mer(String nom, int taille, int playerNum) {
        this(null, taille);
        if (nom.equals(Joueur.RANDOM_JOUEUR_NOM)) {
            this.joueur = new RandomJoueur(nom, playerNum);
        } else {
            this.joueur = new Humain(nom, playerNum);
        } 
    }

    /**
     * Construit l'instance de la Mer.
     * @param joueur le joueur.
     * @param n la taille de la grille.
     */
    public Mer(Joueur joueur, int n) {
        this.joueur = joueur;
        this.n = n;
        this.mer = new Case[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.mer[i][j] = new Case(this, new Position(i, j));
            }
        }
    }
    
    
    /**
     * Récupére la grille.
     * @return la grille.
     */
    public Case[][] getMer() {
        return this.mer;
    }

    /**
     * Récupére la taille de la grille.
     * @return la taille.
     */
    public int getN() {
        return this.n;
    }

    /**
     * Récupére le  joueur.
     * @return le joueur.
     */
    public Joueur getJoueur() {
        return this.joueur;
    }
 
    /**
     * Récupére les bateaux qui ne sont pas abattus.
     * @return une liste avec less bateaux.
     */
    public ArrayList<Bateau> getBateauxVivants(){
        return this.bateauxVivants;
    }
    
    /**
     * Récupére les bateaux qui sont abattus.
     * @return une liste avec les bateaux.
     */
    public ArrayList<Bateau> getBateauxMorts(){
        return this.bateauxMorts;
    }

    /**
     * Place le bateau sur la grille.
     * @param bateau le Bateau.
     */
    public void placer(Bateau bateau) {
        //if((p.getX()+bateau.getLongeur() < this.n && d == Position.Direction.HOR) || (p.getY()+bateau.getLongeur() < this.m && d == Position.Direction.VER)){
        this.mer[bateau.getPosition().getX()][bateau.getPosition().getY()].placer(bateau);

        Position np = Position.decaler(bateau.getPosition(), bateau.getDirection());
        for (int i = 0; i < bateau.getLongeur() - 1; i++) {
            this.mer[np.getX()][np.getY()].placer(bateau);
            np = Position.decaler(np, bateau.getDirection());
        }
        /*} else{
            System.out.println("Invalid move");
        }*/
    }
    
    
    /**
     * Place le tir sur la grille.
     * @param tir le Tir.
     */
    public void placer(Tir tir) {
        this.mer[tir.getPosition().getX()][tir.getPosition().getY()].placer(tir);
        this.setChanged();
        this.notifyObservers();
    }
    
    /**
     * Affiche l'apparence de la grille.
     * @return l'apparence sous forme de chaîne de caracteres.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                sb.append(this.mer[i][j].toString() + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    
    /**
     * Vérifie toutes les positions possibles pour un bateau avec la longueur et la direction spécifiées.
     * @param lon la longeur.
     * @param d la direction.
     * @return une liste avec toutes les positions possibles.
     */
    public ArrayList<Position> valideCoups(int lon, Position.Direction d) {
        ArrayList<Position> coups = new ArrayList<>();
        int compter = 0;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if((j + lon - 1 < this.n && d == Position.Direction.HOR) || (i + lon - 1 < this.n && d == Position.Direction.VER)) {
                    coups.add(new Position(i, j));
                }
            }
        }
        return coups;
    }
   
    
    /**
     * Vérifie toute la position disponible pour tirer.
     * @return une liste avec toutes les positions possibles de tirer.
     */
    public ArrayList<Position> getValideCoups() {
        ArrayList<Position> coups = new ArrayList<>();
        int compter = 0;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.mer[i][j].getTir() == null) {
                    coups.add(new Position(i, j));
                }
            }
        }
        return coups;
    }

    
    /**
     * Vérifie si le jeu est terminé.
     * @return true si il est termine, false sinon
     */
    public boolean estTermine() {
        int counter = 0;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.mer[i][j].getBateau() != null && this.mer[i][j].getTir() == null) {
                    counter++;
                }
            }
        }
        if (this.getValideCoups().isEmpty() || counter == 0) {
            return true;
        }
        return false;
    }

    
    /**
     * Place des bateaux au hasard.
     * @param n longeur total des bateaux.
     */  
    public void aleatoirePlacerBateaux(int n) {
        Random rand = new Random();
        int longeur;
        while (n > 0) { 
            if (n > this.n) {
                longeur = rand.nextInt((this.n) / 2) + 1;
            } else {
                longeur = rand.nextInt(n) + 1;
            }
            n -= longeur;

            Position.Direction dir = rand.nextBoolean() == true ? Position.Direction.HOR : Position.Direction.VER; // choisir la direction
            ArrayList<Position> coups = this.valideCoups(longeur, dir);
            Position pos = coups.get((int) Math.round(((float) Math.random()) * (coups.size() - 1))); // choisir la position
            Bateau newBateau = new Bateau(longeur, pos, dir);
            this.bateauxVivants.add(newBateau);
            this.placer(newBateau);
        }
    }

    /**
     * Récupére le nombre du joueur.
     * @return le nombre.
     */    
    public int getNombreJoueur() {
        return this.joueur.nombreJoueur;
    }
  
    
    /**
     * Vérifie si le joueur est un joueur aleatoire.
     * @return true si il est, false sinon
     */
    public boolean estRandomJoueur() {
        return this.joueur.getNom().equals(Joueur.RANDOM_JOUEUR_NOM);
    }
  
    
    /**
     * Place au hasard un tir.
     */
    public void randomPlacement() {
        Tir tir = new Tir(joueur.choisirCoup(this));
        this.placer(tir);
    }

    
    /**
     * Vérifie si le bateau a coule.
     * @return true si il a, false sinon.
     */    
    public boolean bateauCouler(){
        for(Bateau bateau: this.bateauxVivants){
            int i = 0;
            Position position = bateau.getPosition();
            while(i <= bateau.getLongeur()){
                if(this.mer[position.getX()][position.getY()].getTir() != null){
                    i++;
                    if( i == bateau.getLongeur()){
                        this.bateauxMorts.add(bateau);
                        this.bateauxVivants.remove(bateau);
                        return true;
                    }else{
                        position = Position.decaler(position, bateau.getDirection());
                    }
                }else{
                    break;
                }
            }
        }
        return false;
    }
    
    
}
