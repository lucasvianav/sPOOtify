package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AudioScreen {
    private JLabel lblAudioTitle;
    private JList listAudios;
    private JButton btnPrevious;
    private JButton btnPausePlay;
    private JButton btnNext;
    private JLabel lblAudiolCover;
    private JPanel paneAudio;

    private Album album;
    private Podcast podcast;
    private int audioIndex = 0;
    private final int MAX_INDEX;

    public AudioScreen(Album album) {
        lblAudioTitle.setText(album.getName());
        lblAudiolCover.setIcon(new ImageIcon(album.getCover()));
        this.album = album;
        this.MAX_INDEX = album.getTracks().size();

        btnPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(audioIndex > 0)
                    audioIndex--;
                playAudio();
            }
        });
        btnPausePlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(audioIndex < MAX_INDEX - 1)
                    audioIndex++;
                playAudio();
            }
        });
    }

    public AudioScreen(Podcast podcast) {
        lblAudioTitle.setText(podcast.getName());
        lblAudiolCover.setIcon(new ImageIcon(podcast.getLogo()));
        this.podcast = podcast;
        this.MAX_INDEX = podcast.getNumberOfEpisodes();

        btnPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(audioIndex > 0)
                    audioIndex--;
                playAudio();
            }
        });
        btnPausePlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(audioIndex < MAX_INDEX - 1)
                    audioIndex++;
                playAudio();
            }
        });
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

    private void playAudio() {
        if(this.album != null) {

        } else {

        }
    }

    public static void main(String[] args) {

    }
}
