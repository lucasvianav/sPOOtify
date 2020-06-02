package spootify;

import java.util.List;
import javafx.scene.media.Media;

public class Episode extends Audio {
    
    private String description;
    
    public Episode(String name, int lenght, List<People> cast, Media audio, String description) {
        super(name, lenght, cast, audio);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
