package spootify;

import javafx.scene.image.Image;

public class User extends People {

    // ATTRIBUTES ___________________________________________________________________________________________

    /** email requirements
     * email must have format username@lowerleveldomain.higherleveldomain (ex: email@gmail.com)
     * the higher level domain (after the last dot) must consist of of two to six letter only
     * can contain any characters permitted by RFC 5322 (such as !, #, $, etc)
    */
    private String email;
    /** password requirements
     * be at least 8 characters-long
     * contain at lest 1 uppercase letter
     * contain at least 1 lowercase letter
     * contain at least 1 digit
     * contain at least 1 special character (@, #, %, $, ^, *, &, etc)
     * does not contain whitespace
     */
    private String password;
    protected Image avatar;

    // METHODS ______________________________________________________________________________________________

    // Basic constructor
    public User(String name, String country, String birth, String email, String password) {
        super(name, country, birth); // uses the parent's constructor

        // sets email and password
        {
            setEmail(email);
            setPassword(password);
        }
    }

    // Complete constructor
    public User(String name, String country, String birth, String email, String password, Image avatar) {
        super(name, country, birth); // uses the parent's constructor

        // sets email, password and avatar
        {
            setEmail(email);
            setPassword(password);
            setAvatar(avatar);
        }
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    // Setters
    public void setEmail(String email) {
        // the if-else statement shuts down the program if an invalid email is entered
        if (Util.isValidEmailAddress(email)) {
            this.email = email;
        }
        else {
            System.out.println("\tNo valid email entered.");
            System.exit(1);
        }
    }

    public void setPassword(String password) {
        // the if-else statement shuts down the program if an invalid password is entered
        if (Util.isValidPassword(password)) {
            this.password = password;
        }
        else {
            System.out.println("\tNo valid password entered.");
        }
    }

    public void setAvatar(Image avatar){
        this.avatar = avatar;
    }
    
    // Other methods
    public void showUserInfo(){
        super.showInfo();
        System.out.println("\tEMAIL: " + this.getEmail());
        System.out.println("\tPASSWORD: " + this.getPassword() + "\n");
    } // Prints the person's attributes

}
