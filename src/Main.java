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
                case 1:
                    ContactManager.viewContacts();
                    break;
                case 2:
                    ContactManager.createContact();
                    break;
                case 3:
                    ContactManager.searchContact();
                    break;
                case 4:
                    ContactManager.deleteContact();
                    break;
                case 5:
                    choice = false;
                    manager.saveContacts();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
