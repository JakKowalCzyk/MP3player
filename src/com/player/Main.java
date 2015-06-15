package com.player;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MP3gui mp3 = new MP3gui();
                mp3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mp3.setVisible(true);
            }
        });
    }
}
