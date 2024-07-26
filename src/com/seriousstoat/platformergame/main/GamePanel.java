package com.seriousstoat.platformergame.main;

import static java.awt.Toolkit.getDefaultToolkit;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import com.seriousstoat.platformergame.inputs.KeyboardInputs;
import com.seriousstoat.platformergame.inputs.MouseInputs;

import static com.seriousstoat.platformergame.main.Game.GAME_WIDTH;
import static com.seriousstoat.platformergame.main.Game.GAME_HEIGHT;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private Game game;

    public GamePanel(Game game) {
        mouseInputs = new MouseInputs(this);
        this.game = game;

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
        System.out.println("size: " + GAME_WIDTH + " : " + GAME_HEIGHT);
    }

    public void updateGame() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Toolkit toolkit = getDefaultToolkit();
        game.render(g);
        toolkit.sync(); // flushes buffer used by linux OS, STOPS ANIMATION LAG
    }

    public Game getGame() {
        return game;
    }

}
