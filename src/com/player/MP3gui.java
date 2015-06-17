package com.player;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.MediaPlayer;
import javax.swing.*;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalBorders;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by DK on 2015-06-15.
 */
class MP3gui extends JFrame {
    private JPanel panel;
    private JButton prevButton;
    private JButton nextButton;
    private JButton playButton;
    private JButton pauseButton;
    private JSlider slider1;
    private JLabel songName;
    private JButton unpauseButton;
    private JButton listButton;
    private JButton stopButton;
    private JSlider songSlider;
    private JLabel timeLabel;
    private JList list1;
    private JFileChooser chooser;
    private String fileName;
    private PlayAction playAction;
    private List<MediaPlayer> players;
    private ArrayList<String> names;
    private int howManyRuns = 0;

    public MP3gui() {
        chooser = new JFileChooser();
        MultipleChooserTest chooserTest = new MultipleChooserTest(chooser, listButton);
        setTitle("HEH");
        listButton.addActionListener(e -> {
            chooserTest.open();
            players = chooserTest.getPlayers();
            names = chooserTest.getNames();
            playAction = new PlayAction(playButton, pauseButton, unpauseButton, stopButton, slider1, prevButton, nextButton,players, names, songSlider, timeLabel, list1);
            playAction.setStop();
            playAction.runSong();
            playAction.prevTrack();
            playAction.getRunButton();
            playAction.pauseSong();
            playAction.getPauseButton();
            playAction.unPauseSong();
            playAction.getUnPauseButton();
            playAction.stopSong();
            playAction.getStopButton();
            playAction.getPrevButton();
            playAction.nextTrack();
            playAction.getNextButton();
            playAction.setSliderVolume();
            playAction.getSlider1();
            playAction.getSongSlider();
            playAction.getTimeLabel();
            playAction.setList1();
            playAction.getList1();
            playAction.listChoice();
        });
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JFXPanel();
            }
        });

        setContentPane(panel);
        pack();
    }
}
