package view;

import model.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AudioScreen {
    private JLabel lblAudioTitle;
    private JList<String> listAudios;
    private JButton btnPrevious;
    private JButton btnPausePlay;
    private JButton btnNext;
    private JLabel lblAudiolCover;
    private JPanel paneAudio;

    private Album album;
    private Podcast podcast;
    private int audioIndex = 0;
    private final int MAX_INDEX;

    Long currentFrame;
    Clip clip;
    String status = "";

    public AudioScreen(Album album) {
        lblAudioTitle.setText(album.getName());
        lblAudiolCover.setText("");
        lblAudiolCover.setIcon(new ImageIcon(album.getCover()));
        this.album = album;
        this.MAX_INDEX = album.getTracks().size();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(Music music : album.getTracks())
            listModel.addElement(music.getName());

        listAudios.setModel(listModel);

        play();

        btnPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(audioIndex > 0)
                    audioIndex--;
                play();
            }
        });
        btnPausePlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnPausePlay.getText().equals("Reproduzir")) {
                    resumeAudio();
                    btnPausePlay.setText("Pausar");
                } else {
                    pause();
                    btnPausePlay.setText("Reproduzir");
                }
            }
        });
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(audioIndex < MAX_INDEX - 1)
                    audioIndex++;
                play();
            }
        });
    }

    public AudioScreen(Podcast podcast) {
        this.MAX_INDEX = 0;
    }

    public static void openWindow(Album album) {
        JFrame frame = new JFrame("sPOOtify");
        frame.setContentPane(new AudioScreen(album).paneAudio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void openWindow(Podcast podcast) {
        JFrame frame = new JFrame("sPOOtify");
        frame.setContentPane(new AudioScreen(podcast).paneAudio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    // Method to play the audio
    public void play() {
        try {
            clip = AudioSystem.getClip();

            // open audioInputStream to the clip
            clip.open(this.album.getTracks().get(audioIndex).getAudio());

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            //start the clip
            clip.start();
            status = "play";

        } catch (IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Method to pause the audio
    public void pause() {
        if (status.equals("paused")) {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame = this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    // Method to resume the audio
    public void resumeAudio() {
        if (status.equals("play")) {
            System.out.println("Audio is already "+
                    "being played");
            return;
        }
        clip.close();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    public static void main(String[] args) {

    }
}
