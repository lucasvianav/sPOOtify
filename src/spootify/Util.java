package spootify;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    
    public enum MusicalGenres {
        ROCK {
            @Override
            public String toString() {
                return "Rock";
            }
        }, 
        POP {
            @Override
            public String toString() {
                return "Pop";
            }
        }, 
        SERTANEJO {
            @Override
            public String toString() {
                return "Sertanejo";
            }
        }, 
        PAGODE {
            @Override
            public String toString() {
                return "Pagode";
            }
        };
    }
    
    public enum Domain {
        FISICA_QUANTICA {
            @Override
            public String toString() {
                return "Física Quântica";
            }            
        };
    }

    public static boolean isValidEmailAddress(String email) {
        String regex = "\\A[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}\\z";
        /** regex explanation
         * email format: username@thirdlevel.secondlevel.com, in which "com" is the higher level domain
         * [\\w!#$%&’*+/=?`{|}~^-] - allows all characters as by RFC 5322 (which governs the email messa format)
         * (?:\\.[\\w!#$%&’*+/=?`{|}~^-]+) -  restrict leading, trailing or consecutive dots in the username
         * @ (?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6} - the domains can contain only lower and uppercase letters as well as digits and must contain at least one dot
         * [a-zA-Z]{2,6} - the higher level domain (last part after the dot) must consist of two to six letter only
         */

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean isValidPassword(String password){
        String regex = "\\A(?=\\S*?[0-9])(?=\\S*?[a-z])(?=\\S*?[A-Z])(?=\\S*?[@#$%^&,+=/*~}{|!'])\\S{8,}\\z";
        /** regex explanation
         * (?=\S*?[0-9]) - a digit must occur at least once
         * (?=\S*?[a-z]) - a lower case letter must occur at least once
         * (?=\S*?[A-Z]) - an upper case letter must occur at least once
         * (?=\S*?[@#$%^&+=/*~}{|!']) - a special character must occur at least once
         * \S{8,} - at least 8 characters
         * \S - no whitespace allowed
         */

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(password);

        return matcher.matches();

    }

    public static ArrayList<?> arrayListCopy(ArrayList<?> list) {
        if(list == null) {
            return null;
        }

        ArrayList listCopy = new ArrayList<>();

        listCopy.addAll(list);

        return listCopy;

    }

    public static void printArrayList(ArrayList<?> list){
        if (list != null && list.size() > 0) {
            for (Object element : list) {
                System.out.println("\t- " + element.toString());
            }
        }
        else{
            System.out.println("The list is empty.");
        }
    }
}
