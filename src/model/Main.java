package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    // MAIN _________________________________________________________________________________________________

    public static void main(String args[]) throws IOException {

    }

    // METHODS ______________________________________________________________________________________________

    public static boolean login(String email, String password) throws FileNotFoundException {
        // Checks if the email and password are valid - and if they aren't, return false.
        {
            if (!Util.isValidEmailAddress(email)) {
                System.out.println("The entered email is invalid.");
                return false;
            }

            else if (!Util.isValidPassword(password)) {
                System.out.println("The entered password is invalid.");
                return false;
            }
        }

        Scanner read = new Scanner(Util.accountsDatabase);
        String auxEmail, auxPassword;

        // Reads each line of the list
        while(read.hasNextLine()){
            auxEmail = read.nextLine(); // Saves the line x as an email
            auxPassword = read.nextLine(); // and the line x+1 as a password

            if(auxEmail.equals(email)){ // If it finds the entered email, check the password
                if(auxPassword.equals(password)){ // If the password was corrected, login is successful
                    return true;
                }

                else{
                    System.out.println("The password entered is incorrect.");

                    return false;
                }
            }
        }

        // Will be executed only if all the lines were read and the entered email wasn't found
        System.out.println("There are no account with this email address.");

        return false;
    }

}
