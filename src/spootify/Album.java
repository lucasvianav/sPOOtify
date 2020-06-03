package spootify;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class Album extends AudioList {

    /** FALTA IMPLEMENTAR
     * produtor, gravadora, features (artistas convidados, daí ele puxa das músicas)
     * criar classes single e EP, herdando daqui?
     */

    // ATTRIBUTES ___________________________________________________________________________________________

    private final String NAME;
    private final Image COVER;
    private final ArrayList<Util.MusicalGenres> MUSICALGENRES;
    // private final ArrayList<Artist> FEATURING;

    // METHODS ______________________________________________________________________________________________

    // Constructor
    public Album(String name, Image cover, ArrayList<Music> tracks, ArrayList<Util.MusicalGenres> musicalGenres) {
        super(tracks);
        
        this.NAME = name;
        this.COVER = cover;
        this.MUSICALGENRES = new ArrayList<>();
        this.MUSICALGENRES.addAll(musicalGenres);
    }

    // Getters
    public String getName(){
        return this.NAME;
    }

    public Image getCover(){
        return this.COVER;
    }

    public ArrayList<Util.MusicalGenres> getMusicalGenres() {
        return this.MUSICALGENRES;
    }

    /** Setters
     * the setters override the parent class' and do nothing, in order to
     * prevent the Album's attributes from being altered
     */ @Override
    public void setTracks(ArrayList<Music> tracks) {
        assert(true);
    }

    public void setLength(){
        assert (true);
    }

    /** Other methods
     * the setters override the parent class' and do nothing, in order to
     * prevent the Album's attributes from being altered
     */ @Override
    public void addLength(Music track){
        assert(true);
    }

    public void removeLength(Music track){
        assert(true);
    }


}
