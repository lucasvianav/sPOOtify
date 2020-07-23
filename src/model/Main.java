package model;

import myutil.Util;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static User user;
    static Playlist myPlaylist;

    // MAIN _________________________________________________________________________________________________

    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Você quer criar uma conta? Digite y para sim ou n para não.");
        String answer = sc.nextLine();
        System.out.println();

        if (answer.equals("y")){
            System.out.println();
            System.out.println("CRIAR CONTA");
            System.out.println();
            System.out.println("Seu nome:");
            String auxName = sc.nextLine();
            System.out.println("Seu país:");
            String auxCountry = sc.nextLine();
            System.out.println("Sua data de nascimento (no formato AAAA-MM-DD):");
            String auxDate = sc.nextLine();
            System.out.println("Seu email:");
            String auxMail = sc.nextLine();
            System.out.println("Sua senha:");
            System.out.println("Mínimo de 8 caracteres, com pelo menos uma letra maiúscula, uma minúscula, um número e um caractere especial.");
            String auxPassword = sc.nextLine();
            System.out.println();
            User.createAccount(auxName,auxCountry,auxDate,auxMail,auxPassword);
        }

        System.out.println("Você quer fazer login? Digite y para sim ou n para não.");
        answer = sc.nextLine();
        System.out.println();

        if(answer.equals("y")) {
            System.out.println();
            System.out.println("LOGIN");
            System.out.println();
            System.out.println("Seu email:");
            String auxMaill = sc.nextLine();
            System.out.println("Sua senha:");
            String auxPasswordd = sc.nextLine();
            System.out.println();
            sc.close();


            boolean canLogin = login(auxMaill, auxPasswordd);
            if (canLogin) {
                user.showInfo();

                myPlaylist = new Playlist(user,"Minha playlist");

                System.out.println("Uma playlist com nome '" + myPlaylist.getName() + "' foi criada com sucesso para o usuário " + user.getName());
            }
        }
    }

    // METHODS ______________________________________________________________________________________________

    public static boolean login(String email, String password) throws IOException {
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
        String auxEmail, auxPassword, auxName, auxCountry, auxDate;

        // Reads each line of the list
        while(read.hasNextLine()){
            auxEmail = read.nextLine(); // Saves the line x as an email
            auxPassword = read.nextLine(); // and the line x+1 as a password
            auxName = read.nextLine();
            auxCountry = read.nextLine();
            auxDate = read.nextLine();

            if(auxEmail.equals(email)){ // If it finds the entered email, check the password
                if(auxPassword.equals(password)){ // If the password was corrected, login is successful
                    user = new User(auxName,auxCountry,auxDate,auxEmail,auxPassword);

                    return true;
                }

                else{
                    System.out.println("The password entered is incorrect.");

                    return false;
                }
            }
        }

        // Will be executed only if all the lines were read and the entered email wasn't found
        System.out.println("The email entered is incorrect.");

        return false;
    }



}
