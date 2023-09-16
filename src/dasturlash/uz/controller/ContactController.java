package dasturlash.uz.controller;


import dasturlash.uz.dto.Contact;
import dasturlash.uz.service.ContactService;

import java.util.Scanner;

public class ContactController {
    private ContactService contactService = new ContactService();
    private Scanner strScanner = new Scanner(System.in);
    private Scanner numScanner = new Scanner(System.in);

    public void start() {
        boolean b = true;

        while (b) {
            showMenu();
            int action = getAction();

            switch (action) {
                case 1:
                    System.out.println("Add dto.Contact");
                    addContact();
                    break;
                case 2:
                    System.out.println("dto.Contact List");
                    contactList();
                    break;
                case 3:
                    System.out.println("Delete dto.Contact");
                    deleteContact();
                    break;
                case 4:
                    System.out.println("Search");
                    search();
                    break;
                case 0:
                    System.out.println("Exit");
                    b = false;
                    break;
                default:
                    b = false;
            }

        }
    }

    public void showMenu() {
        System.out.println("*** Menu ***");
        System.out.println("1. Add dto.Contact");
        System.out.println("2. dto.Contact List");
        System.out.println("3. Delete dto.Contact");
        System.out.println("4. Search dto.Contact");
        System.out.println("0. Exit");
    }

    public int getAction() {
        System.out.println("Enter action: ");
        return numScanner.nextInt();
    }

    public void addContact() {
        System.out.println("Enter name: ");
        String name = strScanner.next();

        System.out.println("Enter surname: ");
        String surname = strScanner.next();

        System.out.println("Enter phone: ");
        String phone = strScanner.next();

        Contact contact = new Contact();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);

        contactService.addContact(contact);
    }

    public void contactList() {
        contactService.contactList();
    }

    public void deleteContact() {
        System.out.println("Enter Phone: ");
        String phone = strScanner.next();
        contactService.deleteContact(phone);
    }

    public void search() {
        System.out.println("Enter query: ");
        String query = strScanner.next();
        contactService.search(query);
    }

}
