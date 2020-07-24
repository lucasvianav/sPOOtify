package view;

import model.*;
import myutil.Util;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginForm {
    private JPanel paneLogin;
    private JTextField txtUser;
    private JButton btnLogin;
    private JPasswordField passPassword;
    private JButton btnCreateAccount;

    private User user = null;

    private final JFrame currentFrame;

    private List<Album> allAlbuns;
    private List<Podcast> allPodcasts;

    public LoginForm(JFrame frame) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.currentFrame = frame;

        btnLogin.addActionListener(listener -> {
            String email = txtUser.getText();
            String password = new String(passPassword.getPassword());

            try {
                if(login(email, password)) {
                    // send user object to another form
                    JOptionPane.showMessageDialog(null, "Bem-vindo " + user.getName() + "!");

                    // open a new window and close the currentFrame
                    MainScreen.openWindow(user, allAlbuns, allPodcasts);
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

        setAllAudios();
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

    public static Image createImage(String path) throws IOException {
        File sourceimage = new File(path);
        return ImageIO.read(sourceimage);
    }

    public static ArrayList<Util.Domain> createDomainAL(Util.Domain domain){
        ArrayList<Util.Domain> domainAL = new ArrayList<>();
        domainAL.add(domain);
        return domainAL;
    }

    private void setAllAudios() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Initializing tracks
        Music circles1 = new Music("Circles",createAudioIS("./src/media/ALBUM_Circles-Mac_Miller/01.Circles.mp3"),createGenreAL(Util.MusicalGenres.RAP));
        Music circles2 = new Music("Good News",createAudioIS("./src/media/ALBUM_Circles-Mac_Miller/04.Good_News.mp3"),createGenreAL(Util.MusicalGenres.RAP));
        Music circles3 = new Music("Everybody",createAudioIS("./src/media/ALBUM_Circles-Mac_Miller/06.Everybody.mp3"),createGenreAL(Util.MusicalGenres.RAP));
        Music circles4 = new Music("Woods",createAudioIS("./src/media/ALBUM_Circles-Mac_Miller/07.Woods.mp3"),createGenreAL(Util.MusicalGenres.RAP));
        Music circles5 = new Music("That's On Me",createAudioIS("./src/media/ALBUM_Circles-Mac_Miller/09.That's_On_Me.mp3"),createGenreAL(Util.MusicalGenres.RAP));
        Artist macmiller = new Artist("Mac Miller", "USA", "1992-01-19",createGenreAL(Util.MusicalGenres.RAP),createInstrumentsAL(Util.Instruments.GUITARRA));
        ArrayList<Music> circleslist = new ArrayList<>();
        circleslist.add(circles1);
        circleslist.add(circles2);
        circleslist.add(circles3);
        circleslist.add(circles4);
        circleslist.add(circles5);
        // ALBUM CIRCLES
        Album circles = new Album("Circles",macmiller,"2019",createImage("./src/media/ALBUM_Circles-Mac_Miller/cover.jpg"),circleslist);

        Music lofi1 = new Music("Lofi 1", createAudioIS("./src/media/ALBUM_music/lofi1.mp3"), createGenreAL(Util.MusicalGenres.POP));
        Music lofi2 = new Music("Lofi 2", createAudioIS("./src/media/ALBUM_music/lofi2.mp3"), createGenreAL(Util.MusicalGenres.POP));
        Music lofi3 = new Music("Lofi 3", createAudioIS("./src/media/ALBUM_music/lofi3.mp3"), createGenreAL(Util.MusicalGenres.POP));
        Music lofi4 = new Music("Lofi 4", createAudioIS("./src/media/ALBUM_music/lofi4.mp3"), createGenreAL(Util.MusicalGenres.POP));
        Artist unknow = new Artist("Chilled Cow", "USA", "2000-01-01", createGenreAL(Util.MusicalGenres.POP), createInstrumentsAL(Util.Instruments.FLAUTA));
        ArrayList<Music> lofiList = new ArrayList<>();
        // Adding the musics
        lofiList.add(lofi1);
        lofiList.add(lofi2);
        lofiList.add(lofi3);
        lofiList.add(lofi4);
        // ALBUM LOFI
        Album lofi = new Album("Lofi Album", unknow, "2020", createImage("./src/media/ALBUM_music/cover.jpg"), lofiList);

        allAlbuns.add(circles);
        allAlbuns.add(lofi);

        String desc1 = "Quando uma busca simples para descobrir o primeiro jogo de vídeo game a usar uma voz te leva à história da obcessão humana por criar um ser artificial e a ponderar sobre o futuro da espécie, só há uma solução: gravar um DASH.\n" + "\n" + "André, Sushi e Rafa recebem Fernanda Dias, compositora e designer de som no Studio Pixel Punk, para juntos viajarem através desde as primeiras máquinas de voz até o lento surgimento dos sons feitos por zeros e uns que ouvimos hoje em dia.\n" + "\n" + "Quem inaugurou a voz num jogo? Como as limitações levaram às mais criativas soluções para que pudéssemos diálogos e canções pudessem existir onde não deviam? Como a popularização da mídia ótica mudou a preocupação da quantidade para a qualidade?\n" + "\n" + "Afinal, quais nossos usos favoritos de vozes em jogos? E o que o futuro nos guarda?";
        String desc2 = "Depois de um início muito focado no espaço sideral, uma vez que comidas passaram a dar as caras em jogos, sua presença neles tornou-se cada vez mais e mais indissociável.\n" + "\n" + "Seja emprestando seu significado imediatamente assimilável, seja como uma mecânica secundária, seja buscando representar o aspecto social de comer ou mesmo transformando o ato de cozinhar no objetivo principal, André Campos, Eduardo Sushi e Fernando Mucioli recebem Gus Lanzetta para discutir e explorar a história da representação da comida nos jogos.\n" + "\n" + "De onde vem a busca pela beleza na gastronomia? Como nossa compreensão alimentícia pode ser usada a favor dos jogos? O que é o “pós-comida”? E quais rangos dos jogos mais nos deixaram famintos?";
        Episode dashVoz = new Episode("DASH #109 - A Voz nos Jogos", createAudioIS("./src/media/PODCAST_DASH-Jogabilidade/dash109_voz.mp3"),desc1,createImage("./src/media/PODCAST_DASH-Jogabilidade/cover.png"));
        Episode dashComidas = new Episode("DASH #118 - Comidas nos Jogos", createAudioIS("./src/media/PODCAST_DASH-Jogabilidade/dash118_comida.mp3"),desc2,createImage("./src/media/PODCAST_DASH-Jogabilidade/cover.png"));
        ArrayList<Episode> dashlist = new ArrayList<>();
        dashlist.add(dashVoz);
        dashlist.add(dashComidas);
        Podcaster andreC = new Podcaster("André Campos", "Brasil", "1989-05-03", createDomainAL(Util.Domain.GAMES));
        Podcaster sushi = new Podcaster("Eduardo Fonseca", "Brasil", "1989-05-03", createDomainAL(Util.Domain.GAMES));
        Podcaster rafa = new Podcaster("Rafael Quina", "Brasil", "1989-05-03", createDomainAL(Util.Domain.GAMES));
        Podcaster tengu = new Podcaster("Fernando Muciolli", "Brasil", "1989-05-03", createDomainAL(Util.Domain.GAMES));
        ArrayList<Podcaster> jogabilidade = new ArrayList<>();
        jogabilidade.add(andreC);
        jogabilidade.add(sushi);
        jogabilidade.add(rafa);
        jogabilidade.add(tengu);
        //PODCAST DASH
        Podcast dash = new Podcast("DASH", dashlist, jogabilidade);

        Episode sinapse1 = new Episode("Sinapse - Episode 1", createAudioIS("./src/PODCAST_Sinapse/podcast-sinapse-1.mp3"), "First Episode of the Podcast", createImage("./src/PODCAST_Sinapse/cover.jpg"));
        ArrayList<Episode> sinapse_Episodes = new ArrayList<>();
        sinapse_Episodes.add(sinapse1);
        ArrayList <Util.Domain> sinapse_domains = new ArrayList<>();
        sinapse_domains.add(Util.Domain.TECNOLOGIA);
        Podcaster sinapse_presenter = new Podcaster("Pedro", "Brazil", "2000-01-01", sinapse_domains);
        ArrayList<Podcaster> sinapse_hosts = new ArrayList<>();
        sinapse_hosts.add(sinapse_presenter);
        // PODCAST SINAPSE
        Podcast sinapse = new Podcast("Sinapse", sinapse_Episodes, sinapse_hosts);

        this.allPodcasts.add(dash);
        this.allPodcasts.add(sinapse);
    }

    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        JFrame frame = new JFrame("Login do Sistema");
        frame.setContentPane(new LoginForm(frame).paneLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 200));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
