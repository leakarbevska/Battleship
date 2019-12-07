package battleship.controler.listeners;

import battleship.model.Mer;



public interface IGameLoopListener {
    void onPlayerTurnFinished(Mer mer);
    void onGameConcluded(Mer winner);
}
