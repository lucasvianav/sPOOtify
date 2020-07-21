package model;

import java.awt.Image;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Band {

    // ATTRIBUTES ___________________________________________________________________________________________

    private String name;
    private final String COUNTRY;
    private final LocalDate YEAR; // String format YYYY-MM-DD
    private int age;
    private Image logo;
    private ArrayList<Artist> members = new ArrayList<>();
    private ArrayList<Util.MusicalGenres> musicalGenres = new ArrayList<>();
    private ArrayList<String> instruments = new ArrayList<>();
    private ArrayList<Album> albums = new ArrayList<>();
    private ArrayList<Music> music = new ArrayList<>();

    // METHODS ______________________________________________________________________________________________

    // Basic constructor
    public Band(String name, ArrayList<Artist> members, String originYear, String originCountry) {
        this.COUNTRY = originCountry;

        /** storing the the origin year and calculating the age
         * sets the age as the difference between the current date and the origin year
         * the if-else statement prevents from registering a band that was founded in the current year or later (in the future)
         */
        {
            this.age = Period.between(LocalDate.parse(originYear), LocalDate.now()).getYears();
            if (this.age > 0) {
                this.YEAR = LocalDate.parse(originYear);
                age = Period.between(this.YEAR, LocalDate.now()).getYears();
            }
            else {
                this.YEAR = null;
                this.age = -1;
            }
        }

        // sets name, members and instruments
        {
            this.setName(name);
            this.setMembers(members);
            this.setInstruments();
        }


    }

    // Album constructor
    public Band(String name, ArrayList<Artist> members, String originYear, String originCountry, ArrayList<Album> albums) {
        this.COUNTRY = originCountry;

        /** storing the the origin year and calculating the age
         * sets the age as the difference between the current date and the origin year
         * the if-else statement prevents from registering a band that was founded in the current year or later (in the future)
         */
        {
            this.age = Period.between(LocalDate.parse(originYear), LocalDate.now()).getYears();
            if (this.age > 0) {
                this.YEAR = LocalDate.parse(originYear);
                age = Period.between(this.YEAR, LocalDate.now()).getYears();
            }
            else {
                this.YEAR = null;
                this.age = -1;
            }
        }

        // sets name, members, instruments, albums, tracks and genres
        {
            this.setName(name);
            this.setMembers(members); // already sets members and instruments
            this.setAlbums(albums); // already sets albums and tracks
        }


    }

    // Logo constructor
    public Band(String name, Image logo, ArrayList<Artist> members, String originYear, String originCountry) {
        this.COUNTRY = originCountry;

        /** storing the the origin year and calculating the age
         * sets the age as the difference between the current date and the origin year
         * the if-else statement prevents from registering a band that was founded in the current year or later (in the future)
         */
        {
            this.age = Period.between(LocalDate.parse(originYear), LocalDate.now()).getYears();
            if (this.age > 0) {
                this.YEAR = LocalDate.parse(originYear);
                age = Period.between(this.YEAR, LocalDate.now()).getYears();
            }
            else {
                this.YEAR = null;
                this.age = -1;
            }
        }

        // sets name, logo, members and instruments
        {
            this.setName(name);
            this.setMembers(members); // already set members and instruments
            this.setLogo(logo);
        }


    }

    // Musical genres constructor
    public Band(String name, ArrayList<Artist> members, ArrayList<Util.MusicalGenres> musicalGenres, String originYear, String originCountry) {
        this.COUNTRY = originCountry;

        /** storing the the origin year and calculating the age
         * sets the age as the difference between the current date and the origin year
         * the if-else statement prevents from registering a band that was founded in the current year or later (in the future)
         */
        {
            this.age = Period.between(LocalDate.parse(originYear), LocalDate.now()).getYears();
            if (this.age > 0) {
                this.YEAR = LocalDate.parse(originYear);
                age = Period.between(this.YEAR, LocalDate.now()).getYears();
            }
            else {
                this.YEAR = null;
                this.age = -1;
            }
        }

        // sets name, members, instruments and musical genres
        {
            this.setName(name);
            this.setMembers(members); // already sets members and instruments
            this.setMusicalGenres(musicalGenres);
        }


    }

    // No logo constructor
    public Band(String name, ArrayList<Artist> members, ArrayList<Util.MusicalGenres> musicalGenres, String originYear, String originCountry, ArrayList<Album> albums) {
        this.COUNTRY = originCountry;

        /** storing the the origin year and calculating the age
         * sets the age as the difference between the current date and the origin year
         * the if-else statement prevents from registering a band that was founded in the current year or later (in the future)
         */
        {
            this.age = Period.between(LocalDate.parse(originYear), LocalDate.now()).getYears();
            if (this.age > 0) {
                this.YEAR = LocalDate.parse(originYear);
                age = Period.between(this.YEAR, LocalDate.now()).getYears();
            }
            else {
                this.YEAR = null;
                this.age = -1;
            }
        }

        // sets name, logo, members, instruments, albums, tracks and musical genres
        {
            this.setName(name);
            this.setMembers(members); // already sets members and instruments
            this.setMusicalGenres(musicalGenres);
            this.setAlbums(albums); // already sets albums and tracks
        }


    }

    // Complete constructor
    public Band(String name, Image logo, ArrayList<Artist> members, ArrayList<Util.MusicalGenres> musicalGenres, String originYear, String originCountry, ArrayList<Album> albums) {
        this.COUNTRY = originCountry;

        /** storing the the origin year and calculating the age
         * sets the age as the difference between the current date and the origin year
         * the if-else statement prevents from registering a band that was founded in the current year or later (in the future)
         */
        {
            this.age = Period.between(LocalDate.parse(originYear), LocalDate.now()).getYears();
            if (this.age > 0) {
                this.YEAR = LocalDate.parse(originYear);
                age = Period.between(this.YEAR, LocalDate.now()).getYears();
            }
            else {
                this.YEAR = null;
                this.age = -1;
            }
        }

        // sets name, logo, members, instruments, albums, tracks and musical genres
        {
            this.setName(name);
            this.setLogo(logo);
            this.setMembers(members); // already sets members and instruments
            this.setMusicalGenres(musicalGenres);
            this.setAlbums(albums); // already sets albums and tracks
        }


    }

    // Getters
    public String getName() {
        return this.name;
    }

    public ArrayList<Artist> getMembers() {
        return members;
    }

    public ArrayList<Album> getAlbums(){
        return this.albums;
    }

    public Album getAlbum(int index){
        return this.albums.get(index);
    }

    public Album getAlbum(String albumName){
        for(Album album : this.albums){
            if (album.getName().equals(albumName)){
                return album;
            }
        }

        // System.out.println("That album doesn't belong to this band.");

        return null;
    }

    public Image getLogo(){
        return this.logo;
    }

    public String getOriginYearString() {
        /** for debugging purposes
         if(age > 0) {
         return this.YEAR.toString();
         }
         else if (age == -1){
         System.out.println("No valid origin year was set.");
         return null;
         }
         */

        return this.YEAR.toString();
    }

    public LocalDate getOriginYear() {
        /** for debugging purposes
         if(age > 0) {
         return this.YEAR.toString();
         }
         else if (age == -1){
         System.out.println("No valid origin year was set.");
         return null;
         }
         */

        return this.YEAR;
    }

    public int getAge() {
        /** for debugging purposes
         if(age > 0) {
         return age;
         }
         else if (age == -1){
         System.out.println("No valid birthdate was set.");
         }
         */

        return age;
    }

    public String getOriginCountry() {
        return this.COUNTRY;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(ArrayList<Artist> members) {
        this.members.clear();
        this.members.addAll(members);
        this.setInstruments();
    }

    public void setAlbums(ArrayList<Album> albums){
        this.albums.clear();
        this.albums.addAll(albums);
        this.setMusic(); // refreshes the tracks
        this.setMusicalGenres(); // refreshes the genres
    }

    public void setLogo(Image logo){
        this.logo = logo;
    }

    public void setMusicalGenres(ArrayList<Util.MusicalGenres> musicalGenres) {
        this.musicalGenres.clear();
        this.musicalGenres.addAll(musicalGenres);
    }

    // gets the genres from the albums, so no argument needed
    public void setMusicalGenres(){
        // doesn't lear the genres ArrayList, so the intent is to only add new genres present on the albums, if any
        for(Album album : this.albums){
            for(Util.MusicalGenres genre : album.getMusicalGenres()){
                if(!this.musicalGenres.contains(genre)){
                    this.musicalGenres.add(genre);
                }
            }
        }
    }

    // gets the instruments from the members, so no argument needed
    public void setInstruments(){
        this.instruments.clear(); // clears the instruments ArrayList, leaving it empty
        for(Artist member : this.members){ // loops through the band's members in order to check their instruments
            for(String instrument :  member.getInstruments()){ // loops through each member's instruments
                if(!this.instruments.contains(instrument)){ // if the instrument isn't in the ArrayList already, add it
                    this.instruments.add(instrument);
                }
            }
        }
    }

    // gets all the music from the albums, so no argument needed
    public void setMusic(){
        this.music.clear();
        for(Album album : this.albums){
            for(Music track : album.getTracks()){
                if(!this.music.contains(track)){
                    this.music.add(track);
                }
            }
        }
    }
    
    // Outros metodos
    /** "add" methods
     * they add every new item that wasn't
     * already in the list
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

    public void addMember(Artist newMember) {
        if(!this.members.contains(newMember)){
            this.members.add(newMember);
        }
        this.setInstruments(); // refresh instruments
    }
    
    public void addMembers(ArrayList<Artist> newMembers) {
        for(Artist newMember : newMembers){
            if(!this.members.contains(newMember)){
                this.members.add(newMember);
            }
        }
        this.setInstruments(); // refresh instruments
    }
    
    public void removeMember(Artist member) {
        this.members.remove(member);
        this.setInstruments(); // refresh instruments
    }

    public void removeMember(int index){
        this.members.remove(index);
        this.setInstruments(); // refresh instruments
    }
    
    public void removeMembers(ArrayList<Artist> members) {
        this.members.removeAll(members);
        this.setInstruments(); // refresh instruments
    }

    public void removeMembers(int[] indexes){
        for(int index : indexes){
            this.members.remove(index);
        }
        this.setInstruments(); // refresh instruments
    }

    public void addAlbums(ArrayList<Album> newAlbums){
        for(Album newAlbum : newAlbums){
            if(!this.albums.contains(newAlbum)){
                this.albums.add(newAlbum);
            }
        }
        this.setMusic(); // refreshes the tracks
        this.setMusicalGenres(); // refreshes the genres
    }

    public void addAlbum(Album newAlbum){
        if(!this.albums.contains(newAlbum)){
            this.albums.add(newAlbum);
        }
        this.setMusic(); // refreshes the tracks
        this.setMusicalGenres(); // refreshes the genres
    }

    public void showInfo() {
        System.out.println("\n\tNAME: " + this.getName());
        System.out.println("\tORIGIN COUNTRY: " + this.getOriginCountry());
        System.out.println("\tORIGIN YEAR: " + this.getOriginYearString());
        System.out.println("\tAGE: " + this.getAge() + " years old.");
        System.out.println("\tMEMBERS:");
        Util.printArrayList(this.members);
        System.out.println("\tMUSICAL GENRES:");
        Util.printArrayList(this.musicalGenres);
        System.out.println("\tINSTRUMENTS:");
        Util.printArrayList(this.instruments);
        System.out.println("\tALBUMS:");
        Util.printArrayList(this.albums);
        System.out.println("\tMUSIC:");
        Util.printArrayList(this.music);
        System.out.println();
    } // Prints the band's attributes
    
}
