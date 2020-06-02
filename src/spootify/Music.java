package spootify;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;

public class Music extends Audio {
    
    private List<Util.MusicalGenres> genres;

    public Music(String name, int lenght, List<People> cast, Media audio, List<Util.MusicalGenres> genres) {
        super(name, lenght, cast, audio);
        
        this.genres = new ArrayList<>();
        genres.forEach((genre) -> {
            genres.add(genre);
        });
    }

    public List<Util.MusicalGenres> getGenre() {
        return genres;
    }

    public void setGenre(List<Util.MusicalGenres> genres) {
        while(this.genres.size() > 0)
            this.genres.remove(0);
        
        genres.forEach((genre) -> {
            this.genres.add(genre);
        });
    }
    
}
