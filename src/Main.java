import util.Input;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Input input = new Input();
        ContactManager manager = new ContactManager("contacts.txt", input);

        boolean choice = true;
        while (choice) {
            System.out.println("""
                1: View all contacts
                2: Add new contact
                3: Search contact by name
                4: Delete existing contact
                5: Exit""");

            int userOption = input.getInt("Enter an option (1, 2, 3, 4, or 5)\n");

            switch (userOption) {
                case 1 -> manager.viewContacts();
                case 2 -> manager.createContact();
                case 3 -> manager.searchContact();
                case 4 -> manager.deleteContact();
                case 5 -> {
                    choice = false;
                    manager.saveContacts();
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
