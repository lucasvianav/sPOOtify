package spootify;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;

public abstract class Audio {

    // ATTRIBUTES ___________________________________________________________________________________________

    protected final String NAME;
    protected final int LENGTH;
    protected final Media AUDIO;
    protected final ArrayList<Featuring> FEAT;

    // METHODS ______________________________________________________________________________________________

    // No-feat constructor
    public Audio(String name, Media audio) {
        this.NAME = name;
        this.LENGTH = (int) Math.round(audio.getDuration().toMinutes());
        this.AUDIO = audio;

        this.FEAT = null;
    }

    // Multiple feat constructor
    public Audio(String name, Media audio, ArrayList<Featuring> feat) {
        this.NAME = name;
        this.LENGTH = (int) Math.round(audio.getDuration().toMinutes());
        this.AUDIO = audio;

        this.FEAT = new ArrayList<>();
        this.FEAT.addAll(feat);
    }

    // Single feat constructor
    public Audio(String name, Media audio, Featuring feat) {
        this.NAME = name;
        this.LENGTH = (int) Math.round(audio.getDuration().toMinutes());
        this.AUDIO = audio;

        this.FEAT = new ArrayList<>();
        this.FEAT.add(feat);
    }

    // Getters
    public String getName() {
        return this.NAME;
    }

    public int getLength() {
        return this.LENGTH;
    }

    public Media getAudio() {
        return this.AUDIO;
    }

    public ArrayList<Featuring> getFEAT(){
        return this.FEAT;
    }

    // Other methods
    public void showInfo(){
        System.out.println("\tNAME: " + this.getName());
        System.out.println("\tLENGTH: " + this.getLength());
        if(this.FEAT != null) {
            System.out.println("\tFEATURES:");
            Util.printFeatures(this.FEAT);
        }
    }

}