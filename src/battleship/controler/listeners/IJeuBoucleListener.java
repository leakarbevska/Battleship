package battleship.controler.listeners;

import battleship.model.Mer;


/**
 * L'interface pour la boucle du jeu.
 */
public interface IJeuBoucleListener {
    void tourJoueurFini(Mer mer);
    void jeuTermine(Mer winner);
}
