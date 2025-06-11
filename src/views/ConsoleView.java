package views;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("\n--- Contact Manager Menu ---");
        System.out.println("1. Agregar cntacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Borrar contacto");
        System.out.println("4. Mostrar todos los contactos");
        System.out.println("5. Salir");
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
