package com.player;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by DK on 2015-06-15.
 */
class PlayAction extends JFrame {
    public PlayAction(JButton runButton, JButton pauseButton, JButton unPauseButton, JButton stopButton, JSlider slider1, JButton prevButton, JButton nextButton,
                      JLabel songName, List<MediaPlayer> players, ArrayList<String> names, JSlider songSlider, JLabel timeLabel, JList list1){
        this.runButton = runButton;
        this.pauseButton = pauseButton;
        this.unPauseButton = unPauseButton;
        this.stopButton = stopButton;
        this.slider1 = slider1;
        this.prevButton = prevButton;
        this.nextButton = nextButton;
        this.songName = songName;
        this.players = players;
        this.names = names;
        this.songSlider = songSlider;
        this.timeLabel = timeLabel;
        this.list1 = list1;
    }
    public void runSong(){
        runButton.addActionListener(e -> {
            play();
            setList1();
            runButton.setEnabled(false);
        });
    }
    public void play() {
        if (this.mediaPlayer != null) mediaPlayer.stop();
        songName.setText(names.get(i));
        this.mediaPlayer = players.get(i);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
        int duration = (int) mediaPlayer.getTotalDuration().toSeconds();
        songSlider.setMinimum(0);
        songSlider.setValue(0);
        songSlider.setMaximum(duration);

        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration duration, Duration current) {
                songSlider.setValue((int) current.toSeconds());
                double x = current.toMinutes();
                setTimeLabel(x);
            }
        });
        songSlider.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {
                mediaPlayer.seek(Duration.seconds(songSlider.getValue()));
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                i++;
                play();
            }
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
            volumeValue = mediaPlayer.getVolume();
            mediaPlayer.stop();
            i = i - 1;
            play();
            mediaPlayer.setVolume(volumeValue);
        });
    }
    public void nextTrack(){
        nextButton.addActionListener(e -> {
            volumeValue = mediaPlayer.getVolume();
            mediaPlayer.stop();
            i++;
            play();
            mediaPlayer.setVolume(volumeValue);
        });
    }
    public void setSliderVolume(){
        slider1.setMajorTickSpacing(20);
        slider1.addChangeListener(e -> {
            double value = slider1.getValue();
            mediaPlayer.setVolume(value / 100.0);
        });
    }
    public void setTimeLabel(double x) {
        String allTime = String.valueOf(mediaPlayer.getTotalDuration().toMinutes());
        String allWholeTime = allTime.substring(0, 4);
        String timeS = String.valueOf(x);
        if(timeS.length() < 4) {
            String newTimeS = timeS.substring(0, 2);
            timeLabel.setText(newTimeS + "00/" + allWholeTime);
        }
        else{
            String newTimeS = timeS.substring(0, 4);
            timeLabel.setText(newTimeS  + "/" + allWholeTime);
        }
    }
    public void setList1() {
        String[] newNames = names.toArray(new String[names.size()]);
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String n : newNames) {
            model.addElement(n);
        }
        list1.setModel(model);
    }
    public void listChoice(){
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2){
                    volumeValue = mediaPlayer.getVolume();
                    mediaPlayer.stop();
                    i = list1.getSelectedIndex();
                    play();
                    mediaPlayer.setVolume(volumeValue);
                }
            }
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
    public JSlider getSongSlider() { return songSlider; }
    public JLabel getTimeLabel() { return timeLabel; }
    public JList getList1() { return  list1; }

    private JSlider slider1;
    private JButton unPauseButton;
    private JButton pauseButton;
    private JButton runButton;
    private JButton stopButton;
    private JButton prevButton;
    private JButton nextButton;
    private MediaPlayer mediaPlayer;
    private JLabel songName;
    private List<MediaPlayer> players;
    private ArrayList<String> names;
    private int i = 0;
    private double volumeValue;
    private JSlider songSlider;
    private JList list1;
    private JLabel timeLabel;

}
