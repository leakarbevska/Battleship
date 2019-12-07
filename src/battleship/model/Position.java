
package battleship.model;

/**
 * Classe qui represente une position.
 */
public class Position {
    private int x;
    private int y;
    static enum Direction{
        HOR(0,1),
        VER(1,0); 
        int x, y;
        
        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
    
    /**
     * Construit l'instance de la Position.
     * @param x la position sur x.
     * @param y la position sur y.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Récupére la position sur x.
     * @return l'entier de x.
     */
    public int getX(){
        return this.x;
    }
    
    /**
     * Récupére la position sur y.
     * @return l'entier de y.
     */
    public int getY(){
        return this.y;
    }
    
    /**
     * Change la position sur x.
     * @param newX nouveau entier x.
     */
    public void setX(int newX) {
        this.x = newX;
    }
    
    /**
     * Change la position sur y.
     * @param newY nouveau entier y.
     */
    public void setY(int newY) {
        this.y = newY;
    }

   /**
    * Déplace la position dans une didrection spécifiée pour un.
    * @param p la position.
    * @param d la direction.
    * @return une nouvelle position.
    */ 
    static Position decaler(Position p, Direction d){
        return new Position(p.x+d.x, p.y+d.y);
    }
    
    /**
     * Met les valeurs de la position dans une chaîne.
     * @return la position en chaine de caracteres.
     */
    @Override
    public String toString(){
        return "("+this.x+";"+this.y+")";
    }
    
    
}
