package Axe3D;

public class Contact {
    private String nom;
    private String phonenumber;

    public Contact(String nom, String phonenumber) {
        this.nom = nom;
        this.phonenumber = phonenumber;
    }

    public String getNom() {
        return nom;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
    public static Contact createcontact(String name,String phonenumber){
        return new Contact(name,phonenumber);
    }
}
