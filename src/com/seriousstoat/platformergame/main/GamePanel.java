package com.seriousstoat.platformergame.main;

import java.awt.Graphics;
import javax.swing.JPanel;
import com.seriousstoat.platformergame.inputs.KeyboardInputs;
import com.seriousstoat.platformergame.inputs.MouseInputs;

public class GamePanel extends JPanel{

    private MouseInputs mouseInputs;

    public GamePanel() {

        mouseInputs = new MouseInputs();
        addKeyListener(new KeyboardInputs());
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(100, 100, 200, 50);
    }
}
