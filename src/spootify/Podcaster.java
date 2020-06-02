package spootify;

public class Podcaster extends People {
    
    private Util.Domain domain;
    
    public Podcaster(String name, String Country, String birth, Util.Domain domain) {
        super(name, Country, birth);
        this.domain = domain;
    }
    
    // Getter
    public Util.Domain getDomain() {
        return domain;
    }
    
    public String getStringDomain() {
        return domain.toString();
    }
    // Setter
    public void setDomain(Util.Domain domain) {
        this.domain = domain;
    }
    
    // Outros metodos
    public void showPodcasterInfo(){ // Mostrar todas as informações
        super.showInfo();
        System.out.println("\tDomain: " + this.getDomain());
    }
}
