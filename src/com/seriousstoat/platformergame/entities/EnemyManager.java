package com.seriousstoat.platformergame.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.seriousstoat.platformergame.gamestates.Playing;
import com.seriousstoat.platformergame.utilz.LoadSave;
import static com.seriousstoat.platformergame.utilz.Constants.Enemy.*;

public class EnemyManager {

    private Playing playing;
    private BufferedImage[][] crabbyArray;
    private ArrayList<Crabby> crabbies = new ArrayList<>();

    public EnemyManager(Playing playing) {
        this.playing = playing;
        loadEnemyImgs();
        addEnemies();
    }

    private void addEnemies() {
        crabbies = LoadSave.GetCrabs();
        System.out.println("There are " + crabbies.size() + " crabs");
    }

    public void update (int[][] lvlData, Player player) {
        for (Crabby c : crabbies)
            c.update(lvlData, player);
    }

    public void draw(Graphics g, int xLvlOffset) {
        drawCrabs(g, xLvlOffset);
    }

    private void drawCrabs(Graphics g, int xLvlOffset) {
        for (Crabby c : crabbies) {
            g.drawImage(crabbyArray[c.getEnemyState()][c.getAniIndex()],
                    (int)c.getHitbox().x - xLvlOffset - CRABBY_DRAWOFFSET_X + c.flipX(),
                    (int)c.getHitbox().y - CRABBY_DRAWOFFSET_Y,
                    CRABBY_WIDTH * c.flipW(), CRABBY_HEIGHT, null);
            // c.drawHitbox(g, xLvlOffset);
            c.drawAttackBox(g, xLvlOffset);
        }
    }

    private void loadEnemyImgs() {
        crabbyArray = new BufferedImage[5][9];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.CRABBY_ATLAS);
        for (int j = 0; j < crabbyArray.length; j++)
            for (int i = 0; i < crabbyArray[j].length; i++)
                crabbyArray[j][i] = temp.getSubimage(i * CRABBY_WIDTH_DEFAULT, j * CRABBY_HEIGHT_DEFAULT, CRABBY_WIDTH_DEFAULT, CRABBY_HEIGHT_DEFAULT);
    }

}
