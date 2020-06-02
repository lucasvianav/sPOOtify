package spootify;

import java.util.List;
import javafx.scene.image.Image;

public class Playlist extends AudioList {
    
    private User creator;

    public Playlist(User creator, String name, String description, Image cover, List<Music> musics) {
        super(name, description, cover, musics);
        this.creator = creator;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
    
    public void addMusic(Music music) {
        this.musics.add(music);
        this.length += music.getLenght();
    }
    
    public void removeMusic(Music music) {
        this.musics.remove(music);
        this.length -= music.getLenght();
    }
    
    public void removeMusic(int index) {
        this.length -= this.musics.get(index).getLenght();
        this.musics.remove(index);
    }
    
}
