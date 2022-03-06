package Axe3D;

import java.util.Scanner;

public class Main {
    private static Scanner sc=new Scanner(System.in);
    private static Mobilephone mobilephone=new Mobilephone("0682160173") ;
    public static void main(String[] args) {
	actions();
    boolean quit=false;
    while(!quit){
        System.out.println("enter a choose");
        int choice=sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 0:
                System.out.println("shutting down");
                quit=true;
                break;
            case 1:
                mobilephone.printcontact();
                break;
            case 2:
                  addcontact();
                  break;
            case 3:
                updatecontact();
                break;
            case 4:
                removecontact();
                break;
            case 5:
                querycontact();
                break;
            case 6:
                actions();
                break;
        }
    }
    }
    private static void addcontact(){
        System.out.println("enter name ");
        String name=sc.nextLine();
        System.out.println("enter the phone number");
        String phonenumber =sc.nextLine();
        Contact contact=Contact.createcontact(name,phonenumber);
       if(mobilephone.Addcontact(contact))
           System.out.println("new contact added "+contact.getNom());
    }
    private static void updatecontact(){
        System.out.println("enter existing name ");
        String oldname=sc.nextLine();
        Contact existingcontact=mobilephone.querycontact(oldname);
        if(existingcontact==null){
            System.out.println("contact not found");
            return;
        }
        System.out.println("enter new name");
        String newname=sc.nextLine();
        System.out.println("enter a phone number");
        String newnumber=sc.nextLine();
        Contact newcontact=Contact.createcontact(newname,newnumber);
        mobilephone.updatecontact(existingcontact,newcontact);

    }
    private static void removecontact(){
        System.out.println("enter existing name ");
        String oldname=sc.nextLine();
        Contact existingcontact=mobilephone.querycontact(oldname);
        if(existingcontact==null){
            System.out.println("contact not found");
            return;
        }
        mobilephone.removecontact(existingcontact);
    }
    private static void actions(){
        System.out.println("available actions: ");
        System.out.println("0-shutdown");
        System.out.println("1-print contacts");
        System.out.println("2-to add contact");
        System.out.println("3-to update contact");
        System.out.println("4-to remove contact");
        System.out.println("5-query a contact");
        System.out.println("6-to print list of actions");
        System.out.println("choose action");
    }
    private static void querycontact(){
        System.out.println("enter existing name ");
        String oldname=sc.nextLine();
        Contact existingcontact=mobilephone.querycontact(oldname);
        if(existingcontact==null){
            System.out.println("contact not found");
            return;
        }
        System.out.println("name: "+existingcontact.getNom()+" phone number "+existingcontact.getPhonenumber());
    }

}
