package model;

import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioInputStream;

public class Music extends Audio {

    // ATTRIBUTES ___________________________________________________________________________________________

    private final ArrayList<Util.MusicalGenres> MUSICALGENRES;
    private final Album ALBUM; // assim a gente meio que entra num loop... pra criar álbum precisa declarar as músicas no construtor
    // mas pra criar as músicas, precisa decalrar o álbum no construtor... não sei, tô confuso

    // METHODS ______________________________________________________________________________________________

    // No-feat constructor
    public Music(String name, AudioInputStream audio, Album album, List<Util.MusicalGenres> genres) {
        super(name,  audio);

        this.ALBUM = album;
        this.MUSICALGENRES = new ArrayList<>();
        this.MUSICALGENRES.addAll(genres);
    }

    // Multiple feat constructor
    public Music(String name, AudioInputStream audio, Album album, List<Util.MusicalGenres> genres, ArrayList<Featuring> feat) {
        super(name,  audio, feat);

        this.ALBUM = album;
        this.MUSICALGENRES = new ArrayList<>();
        this.MUSICALGENRES.addAll(genres);
    }

    // Single feat constructor
    public Music(String name, AudioInputStream audio, Album album, List<Util.MusicalGenres> genres, Featuring feat) {
        super(name,  audio, feat);

        this.ALBUM = album;
        this.MUSICALGENRES = new ArrayList<>();
        this.MUSICALGENRES.addAll(genres);
    }

    // Getters
    public ArrayList<Util.MusicalGenres> getMUSICALGENRES(){
        return this.MUSICALGENRES;
    }

    public Album getALBUM(){
        return this.ALBUM;
    }

    // Other methods
    public void showInfo() {
        if(this.getALBUM().getOWNER() instanceof Artist){
            System.out.println("\n\tARTIST: " + ((Artist) this.getALBUM().getOWNER()).getName());
        }
        else if (this.getALBUM().getOWNER() instanceof Band){
            System.out.println("\n\tBAND: " + ((Band) this.getALBUM().getOWNER()).getName());
        }
        System.out.println("\tALBUM: " + this.getALBUM().getName());
        super.showInfo();
        System.out.println("\tTRACK NUMBER: " + this.getALBUM().getTracks().indexOf(this));
        System.out.println("\tMUSICAL GENRES:");
        Util.printArrayList(this.MUSICALGENRES);
        System.out.println();
    } // Prints the songs's attributes
    
}
