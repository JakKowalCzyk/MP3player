package com.player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DK on 2015-06-15.
 */
class OpenAction extends JFrame  {
    public OpenAction(JFileChooser chooser, JLabel songName) {
        this.chooser = chooser;
        this.songName = songName;
    }

    public void open(){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("mp3 files", "mp3");
        chooser.setFileFilter(filter);
        int result = chooser.showOpenDialog(OpenAction.this);
        if(result == JFileChooser.APPROVE_OPTION){
            fileName = chooser.getSelectedFile().toURI().toString();
            name = chooser.getSelectedFile().getName();
            songName.setText(name);
        }
    }

    public String getFileName(){
        return fileName;
    }
    public JLabel getSongName(){
        return songName;
    }

    private String fileName;
    private JFileChooser chooser;
    private String name;
    private JLabel songName;
}
