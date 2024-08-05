package com.seriousstoat.platformergame.gamestates;

import java.awt.event.MouseEvent;

import com.seriousstoat.platformergame.main.Game;
import com.seriousstoat.platformergame.ui.MenuButton;

public class State {

    protected Game game;
    
    public State(Game game) {
        this.game = game;

    }

    public boolean isIn(MouseEvent e, MenuButton mb) {
        return mb.getBounds().contains(e.getX(), e.getY());
    }

    public Game getGame() {
        return game;
    }

}
