package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Podcast {

    // ATTRIBUTES ___________________________________________________________________________________________

    private String name;
    private int numberOfEpisodes;
    private ArrayList<Episode> episodes = new ArrayList<>();
    private ArrayList<Podcaster> hosts = new ArrayList<>();
    private Image logo;
    // gênero

    // METHODS ______________________________________________________________________________________________

    // Basic constructor
    public Podcast(String name, ArrayList<Episode> episodes, ArrayList<Podcaster> hosts) {
        this.name = name;
        this.setEpisodes(episodes);
        this.setHosts(hosts);
    }

    // Logo constructor
    public Podcast(String name, Image logo, ArrayList<Episode> episodes, ArrayList<Podcaster> hosts) {
        this.name = name;
        this.logo = logo;
        this.setEpisodes(episodes);
        this.setHosts(hosts);
    }

    // Genre constructor

    // Complete constructor

    // Getters
    public String getName() {
        return this.name;
    }

    public ArrayList<Episode> getEpisodes() {
        return this.episodes;
    }

    public ArrayList<Podcaster> getHosts() {
        return this.hosts;
    }

    public Image getLogo(){
        return this.logo;
    }

    public int getNumberOfEpisodes(){
        return this.numberOfEpisodes;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes.clear();
        this.episodes.addAll(episodes);
        this.numberOfEpisodes = this.episodes.size();
    }

    public void setHosts(ArrayList<Podcaster> hosts) {
        this.hosts.clear();
        this.hosts.addAll(hosts);
    }

    public void setNumberOfEpisodes(){
        this.numberOfEpisodes = this.episodes.size();
    }

    // Other methods
    /** "add" methods
     * they add every new item that wasn't
     * already in the list
     */

    public void addEpisode(Episode newEpisode) {
        if(!this.episodes.contains(newEpisode)) {
            this.episodes.add(newEpisode);
            this.setNumberOfEpisodes();
        }
    }

    public void addEpisodes(ArrayList<Episode> newEpisodes){
        for(Episode newEpisode : newEpisodes){
            this.addEpisode(newEpisode);
        }
    }

    public void removeEpisode(Episode episode){
        if (this.episodes.contains(episode)){
            this.episodes.remove(episode);
            this.setNumberOfEpisodes();
        }
    }

    public void removeEpisode(int index){
        this.episodes.remove(index);
        this.setNumberOfEpisodes();
    }

    public void removeEpisodes(ArrayList<Episode> episodes){
        for(Episode episode : episodes){
            this.removeEpisode(episode);
        }
    }

    public void removeEpisodes(int[] indexes){
        for (int index : indexes){
            this.removeEpisode(index);
        }
    }

    public void addHost(Podcaster newHost){
        if(!this.hosts.contains(newHost)){
            this.hosts.add(newHost);
        }
    }

    public void addHosts(ArrayList<Podcaster> newHosts){
        for(Podcaster newHost : newHosts){
            this.addHost(newHost);
        }
    }

    public void removeHost(Podcaster exHost){
        if(this.hosts.contains(exHost)){
            this.hosts.remove(exHost);
        }
    }

    public void removeHost(int index){
        this.hosts.remove(index);
    }

    public void removeHosts(ArrayList<Podcaster> exHosts){
        for(Podcaster exHost : exHosts){
            this.removeHost(exHost);
        }
    }

    public void removeHosts(int[] indexes){
        for(int index : indexes){
            this.removeHost(index);
        }
    }
    
}
