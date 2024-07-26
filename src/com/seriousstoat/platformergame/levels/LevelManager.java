package com.seriousstoat.platformergame.levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.seriousstoat.platformergame.entities.LoadSave;
import com.seriousstoat.platformergame.main.Game;

public class LevelManager {

    private Game game;
    private BufferedImage levelSprite;

    public LevelManager(Game game) {
        this.game = game;
        levelSprite = LoadSave.GetPlayerAtlas(LoadSave.LEVEL_ATLAS);

    }

    public void draw(Graphics g) {
        g.drawImage(levelSprite, 0, 0, null);
    }

    public void update() {

    }

}
