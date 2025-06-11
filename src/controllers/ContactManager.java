package controllers;

import models.Contact;
import models.LinkedList;

public class ContactManager {
    private LinkedList<Contact<String, String>> contacts;

    public ContactManager() {
        this.contacts = new LinkedList<>();
    }

    public boolean addContact(Contact<String, String> contact) {
        if (findContactByName(contact.getName()) != null) {
            return false; // Contacto ya existe
        }
        contacts.appendToTail(contact);
        return true;
    }

    public Contact<String, String> findContactByName(String name) {
        Contact<String, String> temp = new Contact<>(name, "");
        return contacts.findByValue(temp);
    }

    public boolean deleteContactByName(String name) {
        Contact<String, String> temp = new Contact<>(name, "");
        Contact<String, String> found = contacts.findByValue(temp);
        if (found != null) {
            contacts.deleteByValue(temp);
            return true;
        }
        return false;
    }

    public void printList() {
        if (contacts.getSize() == 0) {
            System.out.println("No hay contactos disponibles.");
            return;
        }
        System.out.println("--- Lista de Contactos ---");
        contacts.print();
    }
}