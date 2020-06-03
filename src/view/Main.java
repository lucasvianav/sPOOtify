package view;

import java.lang.reflect.Array;
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

        /** people is abstract
        // Criando uma pessoa
        People p1 = new People("Bruno", "Brazil", "2000-09-03");
        System.out.println("Exemplo de pessoa:");
        p1.showInfo();
         */

        // Criando um user
        User u1 = new User("Bruno", "Brazil", "2000-09-03", "brunopagno@usp.br", "batata1234");
        System.out.println("Exemplo de User:");
        u1.showInfo();

        // Criando um artista
        ArrayList <String> instruments = new ArrayList<>();
        instruments.add("Berinbal");
        instruments.add("Uculêlê");
        instruments.add("Gaita");
        ArrayList<Util.MusicalGenres> genres = new ArrayList<>();
        genres.add(Util.MusicalGenres.POP);
        System.out.println("Exemplo de Artista:");
        Artist a1 = new Artist("Michael Jackson", "USA", "1090-09-09", genres, instruments);
        a1.showInfo();

        // Criando um Podcaster
        ArrayList<Util.Domain> dom1 = new ArrayList<>();
        dom1.add(Util.Domain.FISICA_QUANTICA);
        Podcaster pod1 = new Podcaster("NaoSei", "Ajerbaijão", "1999-03-03", dom1);
        System.out.println("Exemplo de Podcaster");
        pod1.showInfo();
        
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
