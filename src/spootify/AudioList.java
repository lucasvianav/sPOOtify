package spootify;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public abstract class AudioList {
    
    protected String name, description;
    protected int length;
    protected Image cover;
    protected List<Music> musics;

    public AudioList(String name, String description, Image cover, List<Music> musics) {
        this.name = name;
        this.description = description;
        this.length = 0;
        this.cover = cover;
        
        this.musics = new ArrayList<>();
        musics.forEach((music) -> {
            this.musics.add(music);
        });
    }
    
    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLength() {
        return length;
    }

    public Image getCover() {
        return cover;
    }

    public List<Music> getMusics() {
        return musics;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCover(Image cover) {
        this.cover = cover;
    }

    public void setMusics(List<Music> musics) {
        while(this.musics.size() > 0)
            this.musics.remove(0);
        
        musics.forEach((music) -> {
            this.musics.add(music);
            this.length += music.getLenght();
        });
    }
    
}
