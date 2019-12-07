
package battleship.model;

import battleship.model.Bateau;
import battleship.model.Tir;

import java.util.Observable;

/**
* Classe qui signifie un champ dans la grille de la Mer.
*/
public class Case extends Observable {
    private Bateau bateau;
    private Tir tir;
    private Mer mer;
    public Position position;

    /**
     * Construit l'instance du jeu avec des elements deja  existants.
     * @param mer La mer à laquelle elle appartient.
     * @param position La position qu'elle a dans la grille de la mer.
     */  
    public Case(Mer mer, Position position){
        this.bateau = null;
        this.tir = null;
        this.mer = mer;
        this.position = position;
    }
    
    /**
     * Récupére l'instance du bateau.
     * @return le bateau.
     */
    public Bateau getBateau(){
        return this.bateau;
    }
    
    /**
     * Récupére l'instance du tir.
     * @return le tir.
     */
    public Tir getTir(){
        return this.tir;
    }
    
    
    /**
     * Récupére l'instance de la mer.
     * @return la mer.
     */    
    public Mer getMer(){
        return this.mer;
    }
    
    /**
     * Récupére l'instance de la position.
     * @return la position.
     */
    public Position getPosition(){
        return this.position;
    }
    
    /**
     * Place un bateau sur le champ.
     * @param bateau Un bateau.
     */
    public void placer(Bateau bateau){
        this.bateau = bateau;
    }
    
    /**
     * Place un tir sur le champ.
     * @param tir Un tir.
     */
    public void placer(Tir tir){
        this.tir = tir;
        this.setChanged();
        this.notifyObservers();
    }
    
    
    /**
     * Donne la bonne chaîne en fonction des paramètres.
     * @return La bonne chaîne de character.
     */
    @Override
    public String toString() {
        if (this.bateau == null && this.tir == null) {
            return "_";
        }
        else if (this.bateau == null) {
            return "@";
        }
        else if (this.tir == null) {
            return this.bateau.getNom();
        }
        else {
            return "X";
        }
    }
    
}
