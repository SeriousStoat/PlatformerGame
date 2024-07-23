package com.seriousstoat.platformergame.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboardinputs implements KeyListener {

    @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("A key is pressed");

            }

}
