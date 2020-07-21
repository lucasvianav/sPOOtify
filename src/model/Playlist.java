package model;

import java.util.ArrayList;
import java.awt.Image;

public class Playlist extends AudioList {

    // ATTRIBUTES ___________________________________________________________________________________________

    protected String name, description;
    protected Image cover;
    private final User CREATOR;

    // METHODS ______________________________________________________________________________________________

    // Simple constructor
    public Playlist(User creator, String name, ArrayList<Music> tracks) {
        super(tracks);

        this.setName(name);
        this.CREATOR = creator;
    }

    // Description constructor
    public Playlist(User creator, String name, String description, ArrayList<Music> tracks) {
        super(tracks);

        this.setName(name);
        this.setDescription(description);
        this.CREATOR = creator;
    }

    // Cover constructor
    public Playlist(User creator, String name, Image cover, ArrayList<Music> tracks) {
        super(tracks);

        this.setName(name);
        this.setCover(cover);
        this.CREATOR = creator;
    }

    // Complete constructor
    public Playlist(User creator, String name, String description, Image cover, ArrayList<Music> tracks) {
        super(tracks);

        this.setName(name);
        this.setDescription(description);
        this.setCover(cover);
        this.CREATOR = creator;
    }

    // Getters
    public User getCreator() {
        return this.CREATOR;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Image getCover(){
        return this.cover;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCover(Image cover){
        this.cover = cover;
    }

    // Other methods
    /** "add" methods
     * they add every new item that wasn't
     * already in the list
     */
    public void addTrack(Music track) {
        if(!this.tracks.contains(track)) {
            this.tracks.add(track);
            this.addLength(track);
        }
    }

    public void addTracks(ArrayList<Music> tracks) {
        for(Music track : tracks){
            if(!this.tracks.contains(track)){
                this.tracks.add(track);
                this.addLength(track);
            }
        }
    }
    
    public void removeTrack(Music track) {
        this.tracks.remove(track);
        this.removeLength(track);
    }
    
    public void removeTrack(int index) {
        this.removeLength(this.tracks.get(index));
        this.tracks.remove(index);
    }

    public void removeTracks(ArrayList<Music> tracks) {
        this.tracks.removeAll(tracks);
        for(Music track : tracks){
            this.removeLength(track);
        }
    }

    public void removeTracks(int[] indexes){
        for(int index : indexes){
            this.removeLength(this.tracks.get(index));
            this.tracks.remove(index);
        }
    }
    
}
