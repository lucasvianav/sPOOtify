package model;

import myutil.Util;

import java.awt.Image;
import java.util.ArrayList;

public class Podcaster extends People {

    // ATTRIBUTES ___________________________________________________________________________________________

    private ArrayList<Util.Domain> domains;

    // METHODS ______________________________________________________________________________________________

    // Basic constructor
    public Podcaster(String name, String Country, String birth, ArrayList<Util.Domain> domains) {
        super(name, Country, birth);

        setDomains(domains);
    }

    // Complete constructor
    public Podcaster(String name, String Country, String birth, ArrayList<Util.Domain> domains, Image avatar) {
        super(name, Country, birth, avatar);

        setDomains(domains);
    }

    // Getters
    public ArrayList<Util.Domain> getDomain() {
        return this.domains;
    }
    
    public ArrayList<String> getDomainsStrings() {
        ArrayList<String> domainsStrings = new ArrayList<>();

        // loops through each element of the domains ArrayList and stores it's description in the new ArrayList
        for (Util.Domain domain : this.domains) {
            domainsStrings.add(domain.toString());
        }

        return domainsStrings;
    }

    // Setters
    public void setDomains(ArrayList<Util.Domain> domains) {
        this.domains.clear();
        this.domains.addAll(domains);
    }
    
    // Outros metodos
    /** "add" methods
     * they add every new item (either genre or instrument) that wasn't
     * already in the artist's list
     */
    public void addDomains(ArrayList<Util.Domain> newDomains){
        for(Util.Domain newDomain : newDomains){
            if(!this.domains.contains(newDomain)){
                this.domains.add(newDomain);
            }
        }
    }

    public void addDomain(Util.Domain newDomain){
        if(!this.domains.contains(newDomain)){
            this.domains.add(newDomain);
        }
    }

    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("\tDOMAINS:");
        Util.printArrayList(this.domains);
        System.out.println();
    } // Prints the user's attributes
}
