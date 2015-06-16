package com.player;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.MediaPlayer;
import javax.swing.*;

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
    private JButton button2;
    private JButton stopButton;
    private JFileChooser chooser;
    public MediaPlayer mediaPlayer;
    private String fileName;
    private PlayAction playAction;

    public MP3gui() {
        chooser = new JFileChooser();

        OpenAction action = new OpenAction(chooser, songName);
        playAction = new PlayAction(playButton, pauseButton, unpauseButton, stopButton, slider1, prevButton, nextButton);
        setTitle("HEH");
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        openItem.addActionListener(e -> {
            action.open();
            fileName = action.getFileName();
            action.getSongName();
            playAction.runSong(fileName);
        });

        playAction.getRunButton();
        playAction.pauseSong();
        playAction.getPauseButton();
        playAction.unPauseSong();
        playAction.getUnPauseButton();
        playAction.stopSong();
        playAction.getStopButton();
        playAction.prevTrack();
        playAction.getPrevButton();
        playAction.nextTrack();
        playAction.getNextButton();
        playAction.setSliderVolume();
        playAction.getSlider1();


        pauseButton = new JButton();
        prevButton = new JButton();




        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JFXPanel();
            }
        });



        setContentPane(panel);
        pack();
    }

}
