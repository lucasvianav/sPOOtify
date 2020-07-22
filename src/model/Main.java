package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static File accounts = new File("accounts.in");

    public static void main(String args[]) throws FileNotFoundException {

    }

    public static void login(String email, String password) throws FileNotFoundException {
        Scanner read = new Scanner(accounts);
        String auxEmail, auxPassword;

        while(read.hasNextLine()){ // Reads each line of the list
            auxEmail = read.nextLine(); // Saves the line x as an email
            auxPassword = read.nextLine(); // and the line x+1 as a password

            if(auxEmail.equals(email)){ // If it finds the entered email, check the password
                if(auxPassword.equals(password)){ // If the password was corrected, login is successful
                    // conseguiu logar

                    break; // Breaks the while loop
                }

                else{
                    System.out.println("The password entered is incorrect.");

                    break; // Breaks the while loop
                }
            }

            if(!read.hasNextLine()){ // If all the lines were read and the entered email wasn't found
                System.out.println("There are no account with this email address.");
            }
        }
    }

}
