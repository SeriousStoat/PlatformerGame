package com.seriousstoat.platformergame.main;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.seriousstoat.platformergame.inputs.KeyboardInputs;
import com.seriousstoat.platformergame.inputs.MouseInputs;

public class GamePanel extends JPanel{

    private MouseInputs mouseInputs;
    private float xDelta = 50, yDelta = 100;
    private float xDir = 3, yDir = 1;

    public GamePanel() {

        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
    }

    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        
        
    }

}
