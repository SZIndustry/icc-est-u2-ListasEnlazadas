package controllers;

import views.ConsoleView;
import models.Contact;

public class MenuController {
    private ContactManager contactManager;
    private ConsoleView consoleView;

    public MenuController() {
        this.contactManager = new ContactManager();
        this.consoleView = new ConsoleView();
    }

    public void showMenu() {
        boolean exit = false;

        while (!exit) {
            consoleView.displayMenu();
            String choice = consoleView.getInput("Seleccione una opción: ");

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    findContact();
                    break;
                case "3":
                    deleteContact();
                    break;
                case "4":
                    showAllContacts();
                    break;
                case "5":
                    exit = true;
                    consoleView.showMessage("Saliendo");
                    break;
                default:
                    consoleView.showMessage("Opción inválida");
            }
        }
    }

    private void addContact() {
        String name = consoleView.getInput("Ingrese el nombre: ");
        String phone = consoleView.getInput("Ingrese el teléfono: ");

        Contact<String, String> newContact = new Contact<>(name, phone);
        if (contactManager.addContact(newContact)) {
            consoleView.showMessage("Contacto agregado ");
        } else {
            consoleView.showMessage("Ya existe un contacto con ese nombre.");
        }
    }

    private void findContact() {
        String name = consoleView.getInput("Ingrese el nombre a buscar: ");
        Contact<String, String> contact = contactManager.findContactByName(name);

        if (contact != null) {
            consoleView.showMessage("Contacto encontrado:\n" + contact);
        } else {
            consoleView.showMessage("Contacto no encontrado.");
        }
    }

    private void deleteContact() {
        String name = consoleView.getInput("Ingrese el nombre a borrar: ");
        if (contactManager.deleteContactByName(name)) {
            consoleView.showMessage("Contacto borrado ");
        } else {
            consoleView.showMessage("No se encontró el contacto.");
        }
    }

    private void showAllContacts() {
        contactManager.printList();
    }
}