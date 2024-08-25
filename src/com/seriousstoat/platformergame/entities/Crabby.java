package com.seriousstoat.platformergame.entities;

import static com.seriousstoat.platformergame.utilz.Constants.Enemy.*;
import static com.seriousstoat.platformergame.utilz.HelpMethods.*;
import static com.seriousstoat.platformergame.utilz.Constants.Directions.*;

import com.seriousstoat.platformergame.main.Game;

public class Crabby extends Enemy {

    public Crabby(float x, float y) {
        super(x, y, CRABBY_WIDTH, CRABBY_HEIGHT, CRABBY);
        initHitbox(x, y, (int) (22 * Game.SCALE), (int) (19 * Game.SCALE));
    }

    public void update(int[][] lvlData) {
        updateMove(lvlData);
        updateAnimationTick();
        
    }

    private void updateMove(int[][] lvlData) {
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
                    move(lvlData);

                    break;
            }
        }
    }
}
