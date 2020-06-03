package spootify;

import javafx.scene.image.Image;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

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
    private ArrayList<Music> musics = new ArrayList<>();

    // METHODS ______________________________________________________________________________________________

    /** FALTA IMPLEMENTAR
     * construtores que contemplem logo, musicalGenres e albums
     * incluir a puxada de instruments dos members nos construtores
     * incuir a puxada de musics dos albums no setAlbum
     * método showInfo()
     */

    // Basic constructor
    public Band(String name, ArrayList<Artist> members, String originYear, String originCountry) {
        this.COUNTRY = originCountry;

        /** storing the the origin year and calculating the age
         * sets the age as the difference between the current date and the origin year
         * the if-else statement prevents from registering a band that was founded in the current year or later (in the future)
         */
        {
            age = Period.between(LocalDate.parse(originYear), LocalDate.now()).getYears();
            if (age > 0) {
                this.YEAR = LocalDate.parse(originYear);
                age = Period.between(this.YEAR, LocalDate.now()).getYears();
            }
            else {
                this.YEAR = null;
                age = -1;
            }
        }

        // sets name and members
        {
            setName(name);
            setMembers(members);
        }
    }

    // Getters
    public String getName() {
        return name;
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

    public String getOriginYear() {
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
    }

    public void setAlbums(ArrayList<Album> albums){
        this.albums.clear();
        this.albums.addAll(albums);
    }

    public void setLogo(Image logo){
        this.logo = logo;
    }

    public void setMusicalGenres(ArrayList<Util.MusicalGenres> musicalGenres) {
        this.musicalGenres.clear();
        this.musicalGenres.addAll(musicalGenres);
    }
    
    // Outros metodos
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

    public void addMember(Artist newMember) {
        if(!this.members.contains(newMember)){
            this.members.add(newMember);
        }
    }
    
    public void addMembers(ArrayList<Artist> newMembers) {
        for(Artist newMember : newMembers){
            if(!this.members.contains(newMember)){
                this.members.add(newMember);
            }
        }
    }
    
    public void removeMember(Artist member) {
        this.members.remove(member);
    }

    public void removeMember(int index){
        this.members.remove(index);
    }
    
    public void removeMembers(ArrayList<Artist> members) {
        this.members.removeAll(members);
    }

    public void removeMembers(int[] indexes){
        for(int index : indexes){
            this.members.remove(index);
        }
    }

    public void showinfo(){

    }
    
}
