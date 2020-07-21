package model;

import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;

public class Episode extends Audio {
    
    private String description;
    
    /*
    public Episode(String name, int lenght, List<People> cast, AudioInputStream audio, String description) {
        super(name, lenght, cast, audio);
        this.description = description;
    }
    */

    public Episode(String name, AudioInputStream audio) {
        super(name, audio);
    }

    public Episode(String name, AudioInputStream audio, ArrayList<Featuring> feat) {
        super(name, audio, feat);
    }

    public Episode(String name, AudioInputStream audio, Featuring feat) {
        super(name, audio, feat);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
