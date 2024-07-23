package com.seriousstoat.platformergame.main;

import java.awt.Graphics;
import javax.swing.JPanel;
import com.seriousstoat.platformergame.inputs.Keyboardinputs;

public class GamePanel extends JPanel{

    public GamePanel() {

        addKeyListener(new Keyboardinputs());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(100, 100, 200, 50);
    }
}
