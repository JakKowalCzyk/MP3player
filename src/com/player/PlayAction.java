package com.player;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DK on 2015-06-15.
 */
class PlayAction extends JFrame {
    public PlayAction(JButton runButton, JButton pauseButton, JButton unPauseButton, JButton stopButton, JSlider slider1, JButton prevButton, JButton nextButton){
        this.runButton = runButton;
        this.pauseButton = pauseButton;
        this.unPauseButton = unPauseButton;
        this.stopButton = stopButton;
        this.slider1 = slider1;
        this.prevButton = prevButton;
        this.nextButton = nextButton;

    }
    public void runSong(String fileName){
        runButton.addActionListener(e -> {
            System.out.println("hhieheihriehih");
            System.out.println(fileName);
            mediaPlayer = new MediaPlayer(new Media(fileName));
            mediaPlayer.play();
            mediaPlayer.setVolume(0.5);
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
    public void prevTrack(){
        prevButton.addActionListener(e -> {

        });
    }
    public void nextTrack(){
        nextButton.addActionListener(e -> {

        });
    }
    public void setSliderVolume(){
        slider1.setMajorTickSpacing(20);
        slider1.addChangeListener(e -> {
            double value = slider1.getValue();
            mediaPlayer.setVolume(value / 100.0);
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
    public JSlider getSlider1(){
        return slider1;
    }
    public JButton getPrevButton(){
        return prevButton;
    }
    public JButton getNextButton(){
        return nextButton;
    }

    private JSlider slider1;
    private JButton unPauseButton;
    private JButton pauseButton;
    private JButton runButton;
    private JButton stopButton;
    private JButton prevButton;
    private JButton nextButton;
    private MediaPlayer mediaPlayer;
}
