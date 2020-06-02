package spootify;

import java.util.List;
import javafx.scene.image.Image;

public class Album extends AudioList {
    
    private List<String> genres;

    public Album(String name, String description, Image cover, List<Music> musics, List<String> genres) {
        super(name, description, cover, musics);
        
        genres.forEach((genre) -> {
            genres.add(genre);
        });
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        while(this.genres.size() > 0)
            this.genres.remove(0);
        
        genres.forEach((genre) -> {
            genres.add(genre);
        });
    }
    
}
