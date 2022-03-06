package Axe3D;

import java.util.ArrayList;

public class Mobilephone {
    private String mynumber;
    private ArrayList<Contact> mycontacts;

    public Mobilephone(String mynumber) {
        this.mynumber = mynumber;
        this.mycontacts = new ArrayList<Contact>();
    }
    public boolean Addcontact(Contact contact){
        if(findcontact(contact.getNom())>=0){
            System.out.println("contact is already on file");
            return false;
        }
        mycontacts.add(contact);
        return true;
    }
    public boolean updatecontact(Contact oldcontact,Contact newcontact){
        int i=findcontact(oldcontact.getNom());
        String newname=newcontact.getNom();
        int j=findcontact(newname);
        if(i>=0 && j==-1){
            this.mycontacts.set(i,newcontact);
            System.out.println("contact has been updated.");
                 return true;
        }

        else if(j>=0){
            System.out.println("contact with same name is already on file");
            return false;
        }
        else
        {
        System.out.println(oldcontact.getNom()+ "not found");
        return false;
        }
    }

    private int findcontact(String name){
      for(int i=0;i<mycontacts.size();i++){
          Contact contact=this.mycontacts.get(i);
          if(contact.getNom().equals(name))
              return i;
      }
      return -1;
    }
    private int findcontact(Contact contact){
        return this.mycontacts.indexOf(contact);
    }
      /**public String querycontact(Contact contact){
        if(findcontact(contact)>=0){
            return contact.getNom();
        }
        return null;
      }/*/
      public Contact querycontact(String name){
        int i=findcontact(name);
          if(i>=0){
              return this.mycontacts.get(i);
          }
          return null;
      }
      public boolean removecontact(Contact contact){
          if(findcontact(contact.getNom())>=0){
              this.mycontacts.remove(contact);
              System.out.println("contact was deleted");
              return true;
          }
          else {
              System.out.println(contact.getNom()+" not found");

              return false;
          }
      }
      public void printcontact(){
        for(int i=0;i<this.mycontacts.size();i++){
            System.out.println((i+1)+"-"+this.mycontacts.get(i).getNom()+"->"+this.mycontacts.get(i).getPhonenumber());
        }
      }

}
