package model;

import java.awt.Image;

import java.time.LocalDate;
import java.time.Period;

public abstract class  People {

    // ATTRIBUTES ___________________________________________________________________________________________

    protected final String NAME, COUNTRY;
    protected final LocalDate BIRTHDATE; // String format YYYY-MM-DD
    protected int age;
    protected Image avatar;

    // METHODS ______________________________________________________________________________________________

    // Simple Constructor
    public People(String name, String country, String birthdate) {
        this.NAME = name;
        this.COUNTRY = country;

        /** storing the birthdate and calculating the age
         * sets the age as the difference between the current date and the birthdate
         * the if-else statement prevents from registering a person that was born in the current year or later (in the future)
        */
        {
            age = Period.between(LocalDate.parse(birthdate), LocalDate.now()).getYears();
            if (age > 0) {
                this.BIRTHDATE = LocalDate.parse(birthdate);
                age = Period.between(this.BIRTHDATE, LocalDate.now()).getYears();
            }
            else {
                this.BIRTHDATE = null;
                age = -1;
            }
        }
    }

    // Complete Constructor
    public People(String name, String country, String birthdate, Image avatar) {
        this.NAME = name;
        this.COUNTRY = country;

        setAvatar(avatar);

        /** storing the birthdate and calculating the age
         * sets the age as the difference between the current date and the birthdate
         * the if-else statement prevents from registering a person that was born in the current year or later (in the future)
         */
        {
            age = Period.between(LocalDate.parse(birthdate), LocalDate.now()).getYears();
            if (age > 0) {
                this.BIRTHDATE = LocalDate.parse(birthdate);
                age = Period.between(this.BIRTHDATE, LocalDate.now()).getYears();
            }
            else {
                this.BIRTHDATE = null;
                age = -1;
            }
        }
    }

    // Setter
    public void setAvatar(Image avatar){
        this.avatar = avatar;
    }

    // Getters
    public String getName() {
        return this.NAME;
    }

    public String getCountry() {
        return this.COUNTRY;
    }

    public String getBirthdate() {
        /** for debugging purposes
         if(age > 0) {
             return this.BIRTHDATE.toString();
         }
         else if (age == -1){
             System.out.println("No valid birthdate was set.");
             return null;
         }
         */

        return this.BIRTHDATE.toString();
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
    
    // Other methods
    public void showInfo() {
        System.out.println("\n\tNAME: " + this.getName());
        System.out.println("\tCOUNTRY: " + this.getCountry());
        System.out.println("\tBIRTHDATE: " + this.getBirthdate());
        System.out.println("\tAGE: " + this.getAge() + " years old.");
    } // Prints the person's attributes
}
