package spootify;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;

public abstract class Audio {
    
    protected String name;
    protected int length;
    protected List<People> cast;
    protected Media audio;

    public Audio(String name, int length, List<People> cast, Media audio) {
        this.name = name;
        this.length = length;
        this.audio = audio;
        
        this.cast = new ArrayList<>();
        cast.forEach((people) -> {
            this.cast.add(people);
        });
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getLenght() {
        return length;
    }

    public List<People> getCast() {
        return cast;
    }

    public Media getAudio() {
        return audio;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLenght(int length) {
        this.length = length;
    }

    public void setCast(List<People> cast) {
        while(this.cast.size() > 0)
            this.cast.remove(0);
        
        cast.forEach((people) -> {
            this.cast.add(people);
        });
    }

    public void setAudio(Media audio) {
        this.audio = audio;
    }
    
}
