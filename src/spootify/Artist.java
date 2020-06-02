package spootify;

import java.util.ArrayList;
import java.util.List;

public class Artist extends People {

    // ATTRIBUTES ___________________________________________________________________________________________

    private String artisticName;
    private ArrayList<Util.MusicalGenres> musicalGenres = new ArrayList<>();
    private ArrayList<String> instruments = new ArrayList<>();

    // METHODS ______________________________________________________________________________________________

    // Basic constructor
    public Artist(String name, String Country, String birth, ArrayList<Util.MusicalGenres> musicalGenres, ArrayList<String> instruments) {
        super(name, Country, birth);

        setMusicalGenres(musicalGenres);
        setInstruments(instruments);
    }

    // Complete constructor
    public Artist(String name, String artisticName, String Country, String birth, ArrayList<Util.MusicalGenres> musicalGenres, ArrayList<String> instruments) {
        super(name, Country, birth);

        setArtisticName(artisticName);
        setMusicalGenres(musicalGenres);
        setInstruments(instruments);
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
    public void showArtistInfo(){ // Mostrar todas as informações
        super.showInfo();
        System.out.println("\tARTISTIC NAME: " + getArtisticName());
        System.out.println("\tMUSICAL GENRES: ");
        Util.printArrayList(this.musicalGenres);
        System.out.println("\tINSTRUMENTS: ");
        Util.printArrayList(this.instruments);
        System.out.println();
    }
}
