package com.seriousstoat.platformergame.levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.seriousstoat.platformergame.entities.LoadSave;
import com.seriousstoat.platformergame.main.Game;

public class LevelManager {

    private Game game;
    private BufferedImage[] levelSprite;

    public LevelManager(Game game) {
        this.game = game;
        importOutsideSprites();
    }

    private void importOutsideSprites() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
		levelSprite = new BufferedImage[48];
        for (int j = 0; j < 4; j++)
            for (int i = 0; i < 12; i++) {
                int index = j * 12 + i;
                levelSprite[index] = img.getSubimage(i * 32 , j * 32, 32, 32);
            }

	}

    public void draw(Graphics g) {
        g.drawImage(levelSprite[2], 0, 0, null);
    }

    public void update() {

    }

}
