package model;

import java.util.ArrayList;

public abstract class AudioList {

    // ATTRIBUTES ___________________________________________________________________________________________

    private int length = 0;
    protected ArrayList<Music> tracks;

    // METHODS ______________________________________________________________________________________________

    // Empty constructor
    public AudioList(){}

    // Constructor
    public AudioList(ArrayList<Music> tracks){
        this.setTracks(tracks);
    }
    
    // Getters
    public int getLength() {
        return length;
    }

    public ArrayList<Music> getTracks() {
        return tracks;
    }
    
    // Setters
    public void setTracks(ArrayList<Music> tracks) {
        this.tracks.clear();
        this.tracks.addAll(tracks);
        this.setLength();
    }

    // gets the length from the tracks, so no argument needed
    public void setLength(){
        this.length = 0;
        for (Music track : this.tracks){
            this.length += track.getLength();
        }
    }

    //Other methods
    public void addLength(Music track){
        this.length += track.getLength();
    }

    public void removeLength(Music track){
        this.length -= track.getLength();
    }


}
