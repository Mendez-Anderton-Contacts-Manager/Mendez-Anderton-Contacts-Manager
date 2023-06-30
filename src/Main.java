import util.Input;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static Path contactsPath = Paths.get( "contacts.txt");
    public static List<String> contactsFromFile;
    public static Input input = new Input();

    static {
        try {
            contactsFromFile = Files.readAllLines(contactsPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void viewContacts() {
        for (int i = 0; i < contactsFromFile.size(); i += 1) {
            System.out.println(contactsFromFile.get(i));
        }
        System.out.println();
    }

    public static void createContact() {
        System.out.println("Enter contact name:");
        String userInputName = input.getString();
        System.out.println("Enter contact phone number:");
        String userInputPhone = input.getString();

        Contact contact = new Contact(userInputName, userInputPhone);

        contactsFromFile.add(contact.toString());
    }

    public static void searchContact() {
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

    public static void deleteContact() {
        System.out.println("Enter contact to delete:");
        String userSearch = input.getString();
        int i = 0;
        for (String contactpers : contactsFromFile) {
            if (contactpers.contains(userSearch)) {
                i++;
                System.out.println("Contact deleted");
                contactsFromFile.remove(contactsFromFile.indexOf(contactpers));
                break;
            }
        }
        if (i == 0) {
            System.out.println("Contact not found");
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "contacts.txt";

        Path dataFile = Paths.get(filename);

        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

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
                    //viewContact method
                    viewContacts();
                    break;
                case 2:
                    //createContact method
                    createContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    //deleteContact method
                    deleteContact();
                    break;
                case 5:
                    choice = false;
                    Path filepath = Paths.get("contacts.txt");
                    Files.write(filepath, contactsFromFile);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

}