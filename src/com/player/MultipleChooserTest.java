package com.player;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.*;
import java.io.FilenameFilter;
import java.util.List;
/**
 * Created by DK on 2015-06-16.
 */
class MultipleChooserTest extends JFrame {
    public MultipleChooserTest(JFileChooser chooser, JButton listButton, JLabel songName) {
        this.chooser = chooser;
        this.listButton = listButton;
        this.songName = songName;
    }
    public void open() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("mp3 files", "mp3");
        chooser.setFileFilter(filter);
        int result = chooser.showOpenDialog(MultipleChooserTest.this);
        if (result == JFileChooser.APPROVE_OPTION) {
            files = chooser.getCurrentDirectory().listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".mp3");
                }
            });

            fileName = chooser.getSelectedFile().toURI().toString();
            players = new ArrayList<>();
            names = new ArrayList<>();
            for (File f : files) {
                players.add(createPlayer(f.toURI().toString()));
                names.add(f.getName());
            }
        }
    }
    private MediaPlayer createPlayer(String source) {
        final Media media = new Media(source);
        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnError(new Runnable() {
            @Override
            public void run() {

            }
        });
        return mediaPlayer;
    }
    public ArrayList<String> getNames(){
        return names;
    }
    public List<MediaPlayer> getPlayers(){
        return players;
    }

    private JLabel songName;
    private JFileChooser chooser;
    private JButton listButton;
    private String fileName;
    private String name;
    private File[] files;
    private List<MediaPlayer> players;
    private ArrayList<String> names;
}

