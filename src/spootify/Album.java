package spootify;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class Album extends AudioList {

    // ATTRIBUTES ___________________________________________________________________________________________

    private final Featuring OWNER;
    private final String NAME;
    private final Image COVER;
    private final ArrayList<Util.MusicalGenres> MUSICALGENRES;
    private final LocalDate YEAR; // YYYY-MM-DD , year of release
    private int age;
    private final ArrayList<Featuring> FEAT;

    // METHODS ______________________________________________________________________________________________

    // Artist constructor
    public Album(String name, Artist artist, String releaseYear, Image cover, ArrayList<Music> tracks) {
        super(tracks);

        this.OWNER = new Featuring(artist);
        this.NAME = name;
        this.COVER = cover;
        this.MUSICALGENRES = new ArrayList<>();

        // storing the musical genres from each track
        {
            for(Music track : this.tracks){ // loops through the tracks
                for(Util.MusicalGenres genre : track.getMUSICALGENRES()){ // loops through the genres from each track
                    if(!this.MUSICALGENRES.contains(genre)){ // if the album's genre arraylist doesn't contain that genre
                        this.MUSICALGENRES.add(genre); // add it
                    }
                }
            }
        }

        /** storing the release year and calculating the age
         * sets the age as the difference between the current date and the release year
         * the if-else statement prevents from registering an album that was released in the current year or later (in the future)
         */
        {
            this.age = Period.between(LocalDate.parse(releaseYear), LocalDate.now()).getYears();
            if (this.age > 0) {
                this.YEAR = LocalDate.parse(releaseYear);
                age = Period.between(this.YEAR, LocalDate.now()).getYears();
            }
            else {
                this.YEAR = null;
                this.age = -1;
            }
        }

        // storing the features from each track
        {
            // if there isn't any feature in the album's tracks, assign FEAT to null - if there is, proceed to store it
            {
                boolean aux; // auxiliar variable that says represent the presence of a feature in the album

                for (Music track : tracks) {
                    if (track.getFEAT() != null) {
                        aux = true;
                        break;
                    }

                    aux = false;
                } // checks if there is at least one track with a feature

                if (aux = true) {
                    this.FEAT = new ArrayList<>();
                } // if there is, assign FEAT as an ArrayList

                else {
                    this.FEAT = null;
                } // if there isn't, assignt it as null
            }

            // if there is any feature in the album's tracks, store it
            for(Music track : tracks){
                if (track.getFEAT() != null) {
                    this.FEAT.addAll(track.getFEAT());
                }
            }
        }
    }

    // Band constructor
    public Album(String name, Band band, String releaseYear, Image cover, ArrayList<Music> tracks) {
        super(tracks);

        this.OWNER = new Featuring(band);
        this.NAME = name;
        this.COVER = cover;
        this.MUSICALGENRES = new ArrayList<>();

        // storing the musical genres from each track
        {
            for(Music track : this.tracks){ // loops through the tracks
                for(Util.MusicalGenres genre : track.getMUSICALGENRES()){ // loops through the genres from each track
                    if(!this.MUSICALGENRES.contains(genre)){ // if the album's genre arraylist doesn't contain that genre
                        this.MUSICALGENRES.add(genre); // add it
                    }
                }
            }
        }

        /** storing the release year and calculating the age
         * sets the age as the difference between the current date and the release year
         * the if-else statement prevents from registering an album that was released in the current year or later (in the future)
         */
        {
            this.age = Period.between(LocalDate.parse(releaseYear), LocalDate.now()).getYears();
            if (this.age > 0) {
                this.YEAR = LocalDate.parse(releaseYear);
                age = Period.between(this.YEAR, LocalDate.now()).getYears();
            }
            else {
                this.YEAR = null;
                this.age = -1;
            }
        }

        // storing the features from each track
        {
            // if there isn't any feature in the album's tracks, assign FEAT to null - if there is, proceed to store it
            {
                boolean aux; // auxiliar variable that says represent the presence of a feature in the album

                for (Music track : tracks) {
                    if (track.getFEAT() != null) {
                        aux = true;
                        break;
                    }

                    aux = false;
                } // checks if there is at least one track with a feature

                if (aux = true) {
                    this.FEAT = new ArrayList<>();
                } // if there is, assign FEAT as an ArrayList

                else {
                    this.FEAT = null;
                } // if there isn't, assignt it as null
            }

            // if there is any feature in the album's tracks, store it
            for(Music track : tracks){
                if (track.getFEAT() != null) {
                    this.FEAT.addAll(track.getFEAT());
                }
            }
        }
    }

    // Getters
    public String getName(){
        return this.NAME;
    }

    public Image getCover(){
        return this.COVER;
    }

    public ArrayList<Util.MusicalGenres> getMusicalGenres() {
        return this.MUSICALGENRES;
    }

    public LocalDate getReleaseYear(){
        return this.YEAR;
    }

    public String getReleaseYearString(){
        return this.YEAR.toString();
    }

    public int getAge(){
        return this.age;
    }

    public ArrayList<Featuring> getFEAT(){
        return this.FEAT;
    }

    public Object getOWNER() {
        return this.OWNER.getFeaturing();
    }

    /** Setters
     * the setters override the parent class' and do nothing, in order to
     * prevent the Album's attributes from being altered
     */ @Override
    public void setTracks(ArrayList<Music> tracks) {
        assert(true);
    }

    public void setLength(){
        assert (true);
    }

    /** Other methods
     * the setters override the parent class' and do nothing, in order to
     * prevent the Album's attributes from being altered
     */ @Override
    public void addLength(Music track){
        assert(true);
    }

    public void removeLength(Music track){
        assert(true);
    }

    public void showInfo() {
        if(this.getOWNER() instanceof Artist){
             System.out.println("\n\tARTIST: " + ((Artist) this.getOWNER()).getName());
         }
        else if (this.getOWNER() instanceof Band){
             System.out.println("\n\tBAND: " + ((Band) this.getOWNER()).getName());
         }
        System.out.println("\tNAME: " + this.getName());
        System.out.println("\tORIGIN YEAR: " + this.getReleaseYearString());
        System.out.println("\tAGE: " + this.getAge() + " years old.");
        System.out.println("\tMUSICAL GENRES:");
        Util.printArrayList(this.MUSICALGENRES);
        System.out.println("\tTRACKS:");
        Util.printArrayList(this.tracks);
        System.out.println("\tFEATURES:");
        Util.printFeatures(this.FEAT);
        System.out.println();
    } // Prints the album's attributes


}
