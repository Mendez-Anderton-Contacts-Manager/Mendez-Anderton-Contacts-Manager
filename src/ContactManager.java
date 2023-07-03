import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ContactManager {
    private final List<String> contactsFromFile;
    private final Path contactsPath;
    private final Input input;

    public ContactManager(String filePath, Input input) throws IOException {
        this.contactsPath = Paths.get(filePath);
        this.input = input;
        if (! Files.exists(contactsPath)) {
            Files.createFile(contactsPath);
        }
        this.contactsFromFile = Files.readAllLines(contactsPath);
    }

    public void printContacts(String contact, int i) {
        if (i == 0) {
            System.out.println("Name        | Phone Number  |");
            System.out.println("-----------------------------");
        }
        System.out.println(contact);
    }

    public void viewContacts() {
        for (int i = 0; i < contactsFromFile.size(); i += 1) {
            printContacts(contactsFromFile.get(i), i);
        }
        System.out.println();
    }

    public void createContact() {
        System.out.println("Enter contact name:");
        String userInputName = input.getString();
        System.out.println("Enter contact phone number:");
        String userInputPhone = input.getString();

        Contact contact = new Contact(userInputName, userInputPhone);

        contactsFromFile.add(contact.toString());
    }

    public void searchContact() {
        System.out.println("Enter contact name to search:");
        String userSearch = input.getString();
        int i = 0;
        for (String contactpers : contactsFromFile) {
            if (contactpers.contains(userSearch)) {
                i++;
                System.out.println("Contact found");
                System.out.println(contactpers);
                System.out.println();
            }
        }
        if (i == 0) {
            System.out.println("Contact not found");
        }

    }

    public void deleteContact() {
        System.out.println("Enter contact to delete:");
        String userSearch = input.getString();
        int i = 0;
        for (String contactpers : contactsFromFile) {
            if (contactpers.contains(userSearch)) {
                i++;
                System.out.println("Contact deleted");
                contactsFromFile.remove(contactpers);
                break;
            }
        }
        if (i == 0) {
            System.out.println("Contact not found");
        }
    }

    public void saveContacts() throws IOException {
        Files.write(contactsPath, contactsFromFile);
    }
}

