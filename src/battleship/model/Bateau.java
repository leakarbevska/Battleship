
package battleship.model;

import battleship.model.Position.Direction;

/**
 * Classe qui représente un bateau.
 */
public class Bateau {
     private Position position;
     private int longeur;
     private String nom;
     private Direction direction;
     
     /**
      * Construit un bateau.
      * @param l la longeur du bateau.
      * @param position la position.
      * @param direction la direction.
      */
     public Bateau( int l, Position position, Direction direction){
         this.longeur = l;
         this.nom = "B";
         this.position = position;
         this.direction = direction;
     }
     
     /**
      * Récupére la longeur.
      * @return la longeur
      */
     public int getLongeur(){
         return this.longeur;
     }
     
     /**
      * Récupére le nom.
      * @return le nom du bateau.
      */
     public String getNom(){
         return this.nom;
     }
     
     /**
      * Récupére la position.
      * @return la position du bateau.
      */
     public Position getPosition(){
         return this.position;
     }
     
     /**
      * Récupére la direction.
      * @return la direction du bateau.
      */
     public Direction getDirection(){
         return this.direction;
     }
}
