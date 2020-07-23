package view;

import model.Main;
import model.User;

import javax.swing.*;
import java.awt.*;

public class MainScreen {
    private JPanel pane;
    private JTabbedPane tabPanes;
    private JLabel lblTopName;
    private JPanel paneMusicsAlbuns;
    private JPanel panePodcasts;
    private JPanel paneMyPlaylists;
    private JPanel paneMyPodcasts;

    private final User currentUser;

    public MainScreen() {
        JOptionPane.showMessageDialog(null, "Não foi passado nenhum usuário para se carregar...",
                "Nenhum usuário logado", JOptionPane.INFORMATION_MESSAGE);

        this.currentUser = null;
    }

    public MainScreen(User user) {
        if(user == null) {
            JOptionPane.showMessageDialog(null, "O usuário é inválido...",
                    "Usuário Inválido", JOptionPane.ERROR_MESSAGE);
            this.currentUser = null;
        } else {
            this.currentUser = user;
            lblTopName.setText(this.currentUser.getName());

            loadMedia();
        }
    }

    private void loadMedia() {
        // add musics and podcasts to the tabbedPane and load the saved media by user

    }

    public static void openWindow(User user) {
        JFrame frame = new JFrame("sPOOtify");
        frame.setContentPane(new MainScreen(user).pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        openWindow(null);
    }
}
