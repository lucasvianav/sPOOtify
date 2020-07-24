package view;

import model.Album;
import model.Artist;
import model.Music;
import model.User;
import myutil.Util;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginForm {
    private JPanel paneLogin;
    private JTextField txtUser;
    private JButton btnLogin;
    private JPasswordField passPassword;
    private JButton btnCreateAccount;

    private User user = null;

    private final JFrame currentFrame;

    public LoginForm(JFrame frame) {
        this.currentFrame = frame;

        btnLogin.addActionListener(listener -> {
            String email = txtUser.getText();
            String password = new String(passPassword.getPassword());

            try {
                if(login(email, password)) {
                    // send user object to another form
                    JOptionPane.showMessageDialog(null, "Bem-vindo " + user.getName() + "!");

                    // open a new window and close the currentFrame
                    MainScreen.openWindow(user);
                    this.currentFrame.dispose();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar dados: " + e,
                        "Erro no login", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCreateAccount.addActionListener(listener -> {
            RegisterForm.openWindow();
            this.currentFrame.dispose();
        });
    }

    private boolean login(String email, String password) throws IOException {
        // Checks if the email and password are valid - and if they aren't, return false.
        if (!Util.isValidEmailAddress(email)) {
            JOptionPane.showMessageDialog(null, "O email informado é inválido!",
                    "Erro no login", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!Util.isValidPassword(password)) {
            JOptionPane.showMessageDialog(null, "A senha informada é inválida!",
                    "Erro no login", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Scanner read = new Scanner(Util.accountsDatabase);
        String auxEmail, auxPassword, auxName, auxCountry, auxDate;

        // Reads each line of the list
        while (read.hasNextLine()) {
            auxEmail = read.nextLine();     // Saves the line x as an email
            auxPassword = read.nextLine();  // and the line x+1 as a password
            auxName = read.nextLine();
            auxCountry = read.nextLine();
            auxDate = read.nextLine();

            if (auxEmail.equals(email)) {               // If it finds the entered email, check the password
                if (auxPassword.equals(password)) {     // If the password was corrected, login is successful
                    user = new User(auxName, auxCountry, auxDate, auxEmail, auxPassword);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "A senha informada está incorreta!",
                            "Erro no login", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }

        // Will be executed only if all the lines were read and the entered email wasn't found
        System.out.println("O email informado está incorreto!");

        read.close();
        return false;
    }

    public static AudioInputStream createAudioIS(String path) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        URL oUrl = new URL(path);
        Clip oclip = AudioSystem.getClip();
        AudioInputStream oStream = AudioSystem.getAudioInputStream(oUrl);
        return oStream;
    }

    public static ArrayList<Util.MusicalGenres> createGenreAL(Util.MusicalGenres genre){
        ArrayList<Util.MusicalGenres> genreAL = new ArrayList<>();
        genreAL.add(genre);
        return genreAL;
    }

    public static ArrayList<Util.Instruments> createInstrumentsAL(Util.Instruments instrument){
        ArrayList<Util.Instruments> instrumentAL = new ArrayList<>();
        instrumentAL.add(instrument);
        return instrumentAL;
    }

    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        // Initializing tracks
        Music circles1 = new Music("Circles",createAudioIS("./src/media/ALBUM_Circles-Mac_Miller/01.Circles.mp3"),createGenreAL(Util.MusicalGenres.RAP));
        Music circles2 = new Music("Good News",createAudioIS("./src/media/ALBUM_Circles-Mac_Miller/04.Good_News.mp3"),createGenreAL(Util.MusicalGenres.RAP));
        Music circles3 = new Music("Everybody",createAudioIS("./src/media/ALBUM_Circles-Mac_Miller/06.Everybody.mp3"),createGenreAL(Util.MusicalGenres.RAP));
        Music circles4 = new Music("Woods",createAudioIS("./src/media/ALBUM_Circles-Mac_Miller/07.Woods.mp3"),createGenreAL(Util.MusicalGenres.RAP));
        Music circles5 = new Music("That's On Me",createAudioIS("./src/media/ALBUM_Circles-Mac_Miller/09.That's_On_Me.mp3"),createGenreAL(Util.MusicalGenres.RAP));
        Artist macmiller = new Artist("Mac Miller", "USA", "1992-01-19",createGenreAL(Util.MusicalGenres.RAP),createInstrumentsAL(Util.Instruments.GUITARRA));
        Album circles = new Album("Circles",macmiller,"2019",);

        // public Album(String name, Artist artist, String releaseYear, Image cover, ArrayList<Music> tracks)


        JFrame frame = new JFrame("Login do Sistema");
        frame.setContentPane(new LoginForm(frame).paneLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 200));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
