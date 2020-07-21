package model;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;

public class Episode extends Audio {

    // ATTRIBUTES ___________________________________________________________________________________________

    private String description;
    private final LocalDate DATE; // String format YYYY-MM-DD
    private Image cover;


    // METHODS ______________________________________________________________________________________________

    // Basic Constructor (current date)
    public Episode(String name, AudioInputStream audio, String description, Image cover) {
        super(name, audio);
        this.description = description;
        this.cover = cover;
        this.DATE = LocalDate.now();
    }

    // Single-feat Constructor (current date)
    public Episode(String name, AudioInputStream audio, Featuring feat, String description, Image cover) {
        super(name, audio, feat);
        this.description = description;
        this.cover = cover;
        this.DATE = LocalDate.now();
    }

    // Multiple-feat Constructor (current date)
    public Episode(String name, AudioInputStream audio, ArrayList<Featuring> feat, String description, Image cover) {
        super(name, audio, feat);
        this.description = description;
        this.cover = cover;
        this.DATE = LocalDate.now();
    }

    // Basic Constructor (specified date)
    public Episode(String name, AudioInputStream audio, String description, Image cover, String releaseDate) {
        super(name, audio);
        this.description = description;
        this.cover = cover;
        this.DATE = LocalDate.parse(releaseDate);
    }

    // Single-feat Constructor (specified date)
    public Episode(String name, AudioInputStream audio, Featuring feat, String description, Image cover, String releaseDate) {
        super(name, audio, feat);
        this.description = description;
        this.cover = cover;
        this.DATE = LocalDate.parse(releaseDate);
    }

    // Multiple-feat Constructor (specified date)
    public Episode(String name, AudioInputStream audio, ArrayList<Featuring> feat, String description, Image cover, String releaseDate) {
        super(name, audio, feat);
        this.description = description;
        this.cover = cover;
        this.DATE = LocalDate.parse(releaseDate);
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public Image getCover(){
        return this.cover;
    }

    public LocalDate getDATE(){
        return this.DATE;
    }

    // Setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setCover(Image cover){
        this.cover = cover;
    }

    // Other methods
    public void showInfo(){
        super.showInfo();
        System.out.println("\tDESCRIPTION: " + this.getDescription());
        System.out.println("\tDATE: " + this.getDATE().toString());
    }
    
}
