package model;

import java.util.ArrayList;
import java.util.List;

public class Podcast {
    
    private String name;
    private List<Episode> episodes;
    private List<Podcaster> presenter;

    public Podcast(String name, List<Episode> episodes, List<Podcaster> presenter) {
        this.name = name;
        
        this.episodes = new ArrayList<>();
        episodes.forEach((episode) -> {
            this.episodes.add(episode);
        });
        
        this.presenter = new ArrayList<>();
        presenter.forEach((podcaster) -> {
            this.presenter.add(podcaster);
        });
    }

    public String getName() {
        return name;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public List<Podcaster> getPresenter() {
        return presenter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEpisodes(List<Episode> episodes) {
        while(this.episodes.size() > 0)
            this.episodes.remove(0);
        
        episodes.forEach((episode) -> {
            this.episodes.add(episode);
        });
    }

    public void setPresenter(List<Podcaster> presenter) {
        while(this.presenter.size() > 0)
            this.presenter.remove(0);
        
        this.presenter = new ArrayList<>();
        presenter.forEach((podcaster) -> {
            this.presenter.add(podcaster);
        });
    }
    
    public void addNewEpisode(Episode episode) {
        this.episodes.add(episode);
    }
    
}
