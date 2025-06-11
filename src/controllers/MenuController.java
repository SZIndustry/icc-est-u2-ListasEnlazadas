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
                    consoleView.showMessage("Saliendo del sistema...");
                    break;
                default:
                    consoleView.showMessage("Opción inválida. Por favor intente nuevamente.");
            }
        }
    }

    private void addContact() {
        String name = consoleView.getInput("Ingrese el nombre: ");
        String phone = consoleView.getInput("Ingrese el teléfono: ");

        Contact<String, String> newContact = new Contact<>(name, phone);
        contactManager.addContact(newContact);
        consoleView.showMessage("Contacto agregado exitosamente!");
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
        contactManager.deleteContactByName(name);
        consoleView.showMessage("Contacto borrado exitosamente!");
    }

    private void showAllContacts() {
        consoleView.showMessage("\n--- Lista de Contactos ---");
        contactManager.printList();
    }
}