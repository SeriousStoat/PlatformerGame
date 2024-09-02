package com.seriousstoat.platformergame.entities;

import static com.seriousstoat.platformergame.utilz.Constants.Enemy.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import static com.seriousstoat.platformergame.utilz.Constants.Directions.*;

import com.seriousstoat.platformergame.main.Game;

public class Crabby extends Enemy {
    // Attack Box
    private Rectangle2D.Float attackBox;
    private int attackBoxOffsetX;

    public Crabby(float x, float y) {
        super(x, y, CRABBY_WIDTH, CRABBY_HEIGHT, CRABBY);
        initHitbox(x, y, (int) (22 * Game.SCALE), (int) (19 * Game.SCALE));
        initAttackBox();
    }

    private void initAttackBox() {
        attackBox = new Rectangle2D.Float(x, y, (int)(82 * Game.SCALE), (int)(19 * Game.SCALE));
        attackBoxOffsetX = (int)(Game.SCALE * 30);
    }

    public void update(int[][] lvlData, Player player) {
        updateMove(lvlData, player);
        updateAnimationTick();
        updateAttackBox();
        
    }

    private void updateAttackBox() {
        attackBox.x = hitbox.x - attackBoxOffsetX;
        attackBox.y = hitbox.y;
    }

    private void updateMove(int[][] lvlData, Player player) {
        if (firstUpdate)
            firstUpdateCheck(lvlData);
         
        if (inAir)
            updateInAir(lvlData);
        else {
            switch(enemyState) {
                case IDLE:
                    newState(RUNNING);
                    break;
                case RUNNING:

                    if (canSeePlayer(lvlData, player))
                        turnTowardsPlayer(player);
                    if (isPlayerCloseForAttack(player))
                        newState(ATTACK);

                    move(lvlData);
                    break;
            }
        }
    
    }

    public void drawAttackBox(Graphics g, int xLvlOffset) {
        g.setColor(Color.red);
        g.drawRect((int)(attackBox.x - xLvlOffset), (int)attackBox.y, (int)attackBox.width, (int)attackBox.height);
    }
    
    public int flipX() {
        if (walkDir == RIGHT)
            return width;
        else
            return 0;
    }
    
    public int flipW() {
        if (walkDir == RIGHT)
            return -1;
        else
            return 1;
    }
   
}
