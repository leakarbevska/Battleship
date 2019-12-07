
package battleship.model;

/**
 * 
 * Classe qui represente un tir.
 */
public class Tir {
    Position position;
    
    /**
     * Construit l'instance du Tir.
     * @param x la position sur x.
     * @param y la position sur y.
     */
    public Tir(int x, int y) {
        this.position = new Position(x,y);
    }
    
    /**
     * Change la position du Tir.
     * @param position la nouvelle position.
     */
    public Tir(Position position){
        this.position = position;
    }
    
    /**
     * Récupére la grille.
     * @return la position.
     */
    public Position getPosition() {
        return this.position;
    }
}
