package spootify;

public class Featuring {

    /** What is this class?
     * This class was created in order to make possible the use of an ArrayList that stores either 'Artist', 'Band' or
     * 'Podcaster' by instead storing 'Featuring'. In 'Album', 'Music' and 'Episode' there's an ArrayList/Featuring\ feat
     * that'll store any special apparition in that media - each element will be a 'Featuring' object that contains only
     * one of the three attributes (the others being null).
     */

    // ATTRIBUTES ___________________________________________________________________________________________

    private final Artist ARTIST;
    private final Band BAND;
    private final Podcaster PODCASTER;

    // METHODS ______________________________________________________________________________________________

    // Artist constructor
    public Featuring(Artist artist){
        this.ARTIST = artist;
        this.BAND = null;
        this.PODCASTER = null;
    }

    // Band constructor
    public Featuring(Band band){
        this.ARTIST = null;
        this.BAND = band;
        this.PODCASTER = null;
    }

    // Podcaster constructor
    public Featuring(Podcaster podcaster){
        this.ARTIST = null;
        this.BAND = null;
        this.PODCASTER = podcaster;
    }

    // Getter
    public Object getFeaturing(){
        if(this.ARTIST != null && this.BAND == null && this.PODCASTER == null){
            return this.ARTIST;
        }

        else if(this.ARTIST == null && this.BAND != null &&  this.PODCASTER == null) {
            return this.BAND;
        }

        else if (this.ARTIST == null && this.BAND == null && this.PODCASTER != null){
            return this.PODCASTER;
        }

        else{
            return null;
        }
    }
}
