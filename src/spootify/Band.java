package spootify;

import java.util.ArrayList;
import java.util.List;

public class Band {
    
    private String name;
    private List<Artist> members;

    public Band(String name, List<Artist> members) {
        this.name = name;
        this.members = new ArrayList<>();
        
        members.forEach((member) -> {
            this.members.add(member);
        });
    }
    
    // Getters
    public String getName() {
        return name;
    }

    public List<Artist> getMembers() {
        return members;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(List<Artist> members) {
        this.members = members;
    }
    
    // Outros metodos
    public void addMembers(Artist member) {
        this.members.add(member);
    }
    
    public void addMembers(List<Artist> members) {
        members.forEach((member) -> {
            this.members.add(member);
        });
    }
    
    public void removeMembers(Artist member) {
        this.members.remove(member);
    }
    
    public void removeMembers(int index) {
        if(0 <= index && index < members.size())
            this.members.remove(index);
    }
    
}
