package controllers;

import models.Contact;
import models.LinkedList;

public class ContactManager {
    private LinkedList<Contact<String, String>> contacts;

    public ContactManager() {
        this.contacts = new LinkedList<>();
    }

    public void addContact(Contact<String, String> contact) {
        contacts.appendToTail(contact);
    }

    public Contact<String, String> findContactByName(String name) {
        Contact<String, String> temp = new Contact<>(name, "");
        return contacts.findByValue(temp);
    }

    public void deleteContactByName(String name) {
        Contact<String, String> temp = new Contact<>(name, "");
        contacts.deleteByValue(temp);
    }

    public void printList() {
        if (contacts.getSize() == 0) {
            System.out.println("Contactos vacíos");
            return;
        }
        System.out.println("Lista de contactos");
        contacts.print();
    }
}