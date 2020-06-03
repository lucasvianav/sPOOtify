package spootify;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Artist extends People {

    // ATTRIBUTES ___________________________________________________________________________________________

    private String artisticName;
    private ArrayList<Util.MusicalGenres> musicalGenres = new ArrayList<>();
    private ArrayList<String> instruments = new ArrayList<>(); // maybe we should create an "instruments enum" in Util

    // METHODS ______________________________________________________________________________________________

    // Basic constructor
    public Artist(String name, String Country, String birth, ArrayList<Util.MusicalGenres> musicalGenres, ArrayList<String> instruments) {
        super(name, Country, birth);

        // sets musical genres and instruments
        {
            setMusicalGenres(musicalGenres);
            setInstruments(instruments);
        }
    }

    // Artistic name constructor
    public Artist(String name, String artisticName, String Country, String birth, ArrayList<Util.MusicalGenres> musicalGenres, ArrayList<String> instruments) {
        super(name, Country, birth);

        // sets artistic name, musical genres and instruments
        {
            setArtisticName(artisticName);
            setMusicalGenres(musicalGenres);
            setInstruments(instruments);
        }
    }

    // Avatar constructor
    public Artist(String name, String Country, String birth, ArrayList<Util.MusicalGenres> musicalGenres, ArrayList<String> instruments, Image avatar) {
        super(name, Country, birth, avatar);

        // sets musical genres and instruments
        {
            setMusicalGenres(musicalGenres);
            setInstruments(instruments);
        }
    }

    //Complete constructor
    public Artist(String name, String artisticName, String Country, String birth, ArrayList<Util.MusicalGenres> musicalGenres, ArrayList<String> instruments, Image avatar) {
        super(name, Country, birth);

        // sets artistic name, musical genres, instruments and avatar
        {
            setArtisticName(artisticName);
            setMusicalGenres(musicalGenres);
            setInstruments(instruments);
            setAvatar(avatar);
        }
    }

    // Getters
    public String getArtisticName(){
        return this.artisticName;
    }

    public ArrayList<Util.MusicalGenres> getMusicalGenres() {
        return this.musicalGenres;
    }
    
    public ArrayList<String> getMusicalGenresStrings() {
        ArrayList<String> genresStrings = new ArrayList<>();

        // loops through each element of the musicalGenres ArrayList and stores it's description in the new ArrayList
        for (Util.MusicalGenres musicalGenre : this.musicalGenres) {
            genresStrings.add(musicalGenre.toString());
        }

        return genresStrings;
    }

    public ArrayList<String> getInstruments() {
        return instruments;
    }
    
    // Setters
    public void setArtisticName(String name){
        this.artisticName = name;
    }

    public void setMusicalGenres(ArrayList<Util.MusicalGenres> musicalGenres) {
        this.musicalGenres.clear();
        this.musicalGenres.addAll(musicalGenres);
    }

    public void setInstruments(ArrayList<String> instruments) {
        this.instruments.clear();
        this.instruments.addAll(instruments);
    }
    
    // Other Methods
    /** "add" methods
     * they add every new item (either genre or instrument) that wasn't
     * already in the artist's list
     */
    public void addMusicalGenres(ArrayList<Util.MusicalGenres> newGenres){
        for(Util.MusicalGenres newGenre : newGenres){
            if(!this.musicalGenres.contains(newGenre)){
                this.musicalGenres.add(newGenre);
            }
        }
    }

    public void addMusicalGenre(Util.MusicalGenres newGenre){
        if(!this.musicalGenres.contains(newGenre)){
            this.musicalGenres.add(newGenre);
        }
    }

    public void addInstruments(ArrayList<String> newInstruments){
        for(String newInstrument : newInstruments){
            if(!this.instruments.contains(newInstrument)){
                this.instruments.add(newInstrument);
            }
        }
    }

    public void addInstrument(String newInstrument){
        if(!this.instruments.contains(newInstrument)){
            this.instruments.add(newInstrument);
        }
    }

    @Override
    public void showInfo(){ // Mostrar todas as informações
        super.showInfo();
        System.out.println("\tARTISTIC NAME: " + getArtisticName());
        System.out.println("\tMUSICAL GENRES:");
        Util.printArrayList(this.musicalGenres);
        System.out.println("\tINSTRUMENTS:");
        Util.printArrayList(this.instruments);
        System.out.println();
    } // Prints the artist's attributes


}
