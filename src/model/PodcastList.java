package model;

import java.awt.*;
import java.util.ArrayList;

public class PodcastList {
    // ATTRIBUTES ___________________________________________________________________________________________

    protected String name, description;
    protected Image cover;
    protected ArrayList<Podcast> podcasts;
    protected int size; // number of podcasts in the list
    private final User CREATOR;

    // METHODS ______________________________________________________________________________________________

    // Empty-list constructor
    public PodcastList(User creator, String name){
        this.setName(name);
        this.CREATOR = creator;
    }

    // Simple constructor
    public PodcastList(User creator, String name, ArrayList<Podcast> podcasts) {
        this.setPodcasts(podcasts);
        this.setName(name);
        this.CREATOR = creator;
    }

    // Description constructor
    public PodcastList(User creator, String name, String description, ArrayList<Podcast> podcasts) {
        this.setPodcasts(podcasts);
        this.setName(name);
        this.setDescription(description);
        this.CREATOR = creator;
    }

    // Cover constructor
    public PodcastList(User creator, String name, Image cover, ArrayList<Podcast> podcasts) {
        this.setPodcasts(podcasts);
        this.setName(name);
        this.setCover(cover);
        this.CREATOR = creator;
    }

    // Complete constructor
    public PodcastList(User creator, String name, String description, Image cover, ArrayList<Podcast> podcasts) {
        this.setPodcasts(podcasts);
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

    public ArrayList<Podcast> getPodcasts(){
        return this.podcasts
    }

    // Setters
    public void setPodcasts(ArrayList<Podcast> podcasts) {
        this.podcasts.clear();
        this.podcasts.addAll(podcasts);
        this.size = this.podcasts.size();
    }

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
    public void addPodcast(Podcast podcast) {
        if(!this.podcasts.contains(podcast)) {
            this.podcasts.add(podcast);
            this.size = this.podcasts.size();
        }
    }

    public void addPodcasts(ArrayList<Podcast> podcasts) {
        for(Podcast podcast : podcasts) {
            addPodcast(podcast);
        }
    }

    public void removePodcast(Podcast podcast) {
        if(this.podcasts.contains(podcast)) {
            this.podcasts.remove(podcast);
        }
        this.size = this.podcasts.size();
    }

    public void removePodcast(int index) {
        this.podcasts.remove(index);
        this.size = this.podcasts.size();
    }

    public void removePodcasts(ArrayList<Podcast> podcasts) {
        for(Podcast podcast : podcasts) {
            this.removePodcast(podcast);
        }
    }

    public void removePodcasts(int[] indexes){
        for(int index : indexes){
            this.removePodcast(index);
        }
    }


}
