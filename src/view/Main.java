package view;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spootify.Artist;
import spootify.People;
import spootify.Podcaster;
import spootify.User;
import spootify.Util;

public class Main extends Application {
    
    public static void main(String[] args) {
        // Criando uma pessoa
        People p1 = new People("Bruno", "Brazil", "2000-09-03");
        System.out.println("Exemplo de pessoa:");
        p1.showInfo();

        // Criando um user
        User u1 = new User("Bruno", "Brazil", "2000-09-03", "brunopagno@usp.br", "batata1234");
        System.out.println("Exemplo de User:");
        u1.showUserInfo();

        // Criando um artista
        ArrayList <String> instruments = new ArrayList<>();
        instruments.add("Berinbal");
        instruments.add("Uculêlê");
        instruments.add("Gaita");
        System.out.println("Exemplo de Artista:");
        Artist a1 = new Artist("Michael Jackson", "USA", "1090-09-09", Util.MusicalGenre.POP, instruments);
        a1.showArtistInfo();

        // Criando um Podcaster
        Podcaster pod1 = new Podcaster("NaoSei", "Ajerbaijão", "1999-03-03", Util.Domain.FISICA_QUANTICA);
        System.out.println("Exemplo de Podcaster");
        pod1.showPodcasterInfo();
        
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLInicio.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
}
