package com.seriousstoat.platformergame.entities;

import static com.seriousstoat.platformergame.utilz.Constants.Enemy.*;

import com.seriousstoat.platformergame.main.Game;;

public class Crabby extends Enemy {

    public Crabby(float x, float y) {
        super(x, y, CRABBY_WIDTH, CRABBY_HEIGHT, CRABBY);
        initHitbox(x, y, (int) (22 * Game.SCALE), (int) (19 * Game.SCALE));
    }

}
