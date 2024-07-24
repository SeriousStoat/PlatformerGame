package com.seriousstoat.platformergame.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.seriousstoat.platformergame.inputs.KeyboardInputs;
import com.seriousstoat.platformergame.inputs.MouseInputs;

public class GamePanel extends JPanel{

    private MouseInputs mouseInputs;
    private float xDelta = 50, yDelta = 100;
    private float xDir = 3, yDir = 1;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 15;


    public GamePanel() {

        mouseInputs = new MouseInputs(this);

        importImg();
        loadAnimations();

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        animations =  new BufferedImage[9][6];

        for (int j = 0; j < animations.length; j++)
            for (int i = 0; i < animations[j].length; i++)
                animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280,600);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
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

    private void updateAnimationTick() {

        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= 6)
                aniIndex = 0;           

        }
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateAnimationTick();

        g.drawImage(animations[1][aniIndex], (int) xDelta, (int) yDelta, 128, 80, null);
        
    }

    

}