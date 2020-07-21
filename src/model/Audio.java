package model;

import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;

public abstract class Audio {

    // ATTRIBUTES ___________________________________________________________________________________________

    protected final String NAME;
    protected final int LENGTH;
    protected final AudioInputStream AUDIO;
    protected final ArrayList<Featuring> FEAT;

    // METHODS ______________________________________________________________________________________________

    // No-feat constructor
    public Audio(String name, AudioInputStream audio) {
        this.NAME = name;
        this.LENGTH = (int) (1000 * audio.getFrameLength() / audio.getFormat().getFrameRate());
        this.AUDIO = audio;

        this.FEAT = null;
    }

    // Multiple feat constructor
    public Audio(String name, AudioInputStream audio, ArrayList<Featuring> feat) {
        this.NAME = name;
        this.LENGTH = (int) (1000 * audio.getFrameLength() / audio.getFormat().getFrameRate());
        this.AUDIO = audio;

        this.FEAT = new ArrayList<>();
        this.FEAT.addAll(feat);
    }

    // Single feat constructor
    public Audio(String name, AudioInputStream audio, Featuring feat) {
        this.NAME = name;
        this.LENGTH = (int) (1000 * audio.getFrameLength() / audio.getFormat().getFrameRate());
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

    public AudioInputStream getAudio() {
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