package battleship.controler.listeners;

import battleship.model.JeuParametres;


public interface IStartGameListener {
    void onGameSettingsSet(JeuParametres parametres);
}
