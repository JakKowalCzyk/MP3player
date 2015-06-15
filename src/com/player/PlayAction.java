package com.player;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DK on 2015-06-15.
 */
class PlayAction extends JFrame {
    public PlayAction(JButton runButton, JButton pauseButton, JButton unPauseButton, JButton stopButton){
        this.runButton = runButton;
        this.pauseButton = pauseButton;
        this.unPauseButton = unPauseButton;
        this.stopButton = stopButton;
    }
    public void runSong(String fileName){
        runButton.addActionListener(e -> {
            System.out.println("hhieheihriehih");
            System.out.println(fileName);
            mediaPlayer = new MediaPlayer(new Media(fileName));
            mediaPlayer.play();
        });
    }
    public void pauseSong(){
        pauseButton.addActionListener(e -> {
            System.out.println("stophehe");
            mediaPlayer.pause();
        });
    }
    public void unPauseSong(){
        unPauseButton.addActionListener(e -> {
            System.out.println("unpas");
            mediaPlayer.getCurrentTime();
            mediaPlayer.play();
        });
    }
    public void stopSong(){
        stopButton.addActionListener(e -> {
            mediaPlayer.stop();
        });
    }
    public JButton getRunButton(){
        return runButton;
    }
    public JButton getPauseButton(){
        return pauseButton;
    }
    public JButton getUnPauseButton(){
        return unPauseButton;
    }
    public JButton getStopButton(){
        return stopButton;
    }
    private JButton unPauseButton;
    private JButton pauseButton;
    private JButton runButton;
    private JButton stopButton;
    private MediaPlayer mediaPlayer;
}
