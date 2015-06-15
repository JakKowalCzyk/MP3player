package com.player;

import javax.swing.*;

/**
 * Created by DK on 2015-06-15.
 */
class PrevAction extends JFrame {
    public  PrevAction (JButton prevButton){
        this.prevButton = prevButton;
        prevButton.addActionListener(e -> {
            System.out.println("hehe");
        });
    }
    public JButton getPrevButton(){
        return prevButton;
    }
    private JButton prevButton;
}
