package com.player;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.MediaPlayer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DK on 2015-06-15.
 */
class MP3gui extends JFrame {

    private JPanel panel;
    private JButton nextButton;
    private JButton previousButton;
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
    private String name;
    private PlayAction playAction;

    public MP3gui() {
        chooser = new JFileChooser();

        OpenAction action = new OpenAction(chooser, songName);
        playAction = new PlayAction(playButton, pauseButton, unpauseButton, stopButton);
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

        PrevAction prevAction = new PrevAction(previousButton);
        prevAction.getPrevButton();

        pauseButton = new JButton();
        nextButton = new JButton();

        slider1 = new JSlider();


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JFXPanel();
            }
        });



        setContentPane(panel);
        pack();
    }

}
