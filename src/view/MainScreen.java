package view;

import model.Album;
import model.AlbumTableModel;
import model.Podcast;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MainScreen {
    private JPanel pane;
    private JTabbedPane tabPanes;
    private JLabel lblTopName;
    private JPanel paneMusicsAlbuns;
    private JPanel panePodcasts;
    private JPanel paneMyPlaylists;
    private JPanel paneMyPodcasts;
    private JTable tabMusicAlbum;

    private final User currentUser;

    private final AlbumTableModel albumTableModel = new AlbumTableModel();

    private List<Album> allAlbuns;
    private List<Podcast> allPodcasts;

    public MainScreen() {
        JOptionPane.showMessageDialog(null, "Não foi passado nenhum usuário para se carregar...",
                "Nenhum usuário logado", JOptionPane.INFORMATION_MESSAGE);

        this.currentUser = null;
        initComponents();
    }

    public MainScreen(User user) {
        if(user == null) {
            JOptionPane.showMessageDialog(null, "O usuário é inválido...",
                    "Usuário Inválido", JOptionPane.ERROR_MESSAGE);
            this.currentUser = null;
        } else {
            initComponents();

            this.currentUser = user;
            lblTopName.setText(this.currentUser.getName());
            tabMusicAlbum.setModel(this.albumTableModel);

            loadMedia();
        }
    }

    public MainScreen(User user, List<Album> allAlbuns, List<Podcast> allPodcasts) {
        if(user == null) {
            JOptionPane.showMessageDialog(null, "O usuário é inválido...",
                    "Usuário Inválido", JOptionPane.ERROR_MESSAGE);
            this.currentUser = null;
        } else {
            initComponents();

            this.currentUser = user;
            this.allAlbuns = allAlbuns;
            this.allPodcasts = allPodcasts;
            
            lblTopName.setText(this.currentUser.getName());
            tabMusicAlbum.setModel(this.albumTableModel);

            loadMedia();
        }
    }

    private void initComponents() {
        tabMusicAlbum.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(tabMusicAlbum.getSelectedRow() > -1) {
                    int row = tabMusicAlbum.getSelectedRow(),
                            column = tabMusicAlbum.getSelectedColumn();
                    Album album = albumTableModel.getAlbumAt(row, column);
                    JOptionPane.showMessageDialog(null, "Título do Álbum");
                }
            }
        });

        loadMedia();
    }

    private void loadMedia() {
        // add musics and podcasts to the tabbedPane based in the current pane
        switch(tabPanes.getSelectedIndex()) {
            case 0: // musisc and albuns

                break;
            case 1: // podcasts

                break;
            case 2: // my musics and albuns

                break;
            case 3: // my podcasts

                break;
        }
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

    public static void openWindow(User user, List<Album> allAlbuns, List<Podcast> allPodcasts) {
        JFrame frame = new JFrame("sPOOtify");

        MainScreen newScreen = new MainScreen(user, allAlbuns, allPodcasts);
        frame.setContentPane(newScreen.pane);

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
