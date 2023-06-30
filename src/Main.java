import util.Input;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Input input = new Input();

        String filename = "contacts.txt";

        Path dataFile = Paths.get(filename);

        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }





//        Files.write(
//                Paths.get("contacts.txt"),
//                Arrays.asList("eggs"), // list with one item
//                StandardOpenOption.APPEND
//        );
//
//        List<String> lines = Files.readAllLines(Paths.get("data", "groceries.txt"));
//
//        List<String> newList = new ArrayList<>();
//
//        for (String line : lines) {
//            if (line.equals("milk")) {
//                newList.add("cream");
//                continue;
//            }
//            newList.add(line);
//        }
//
//        Files.write(Paths.get("data", "groceries.txt"), newList);
        Path contactsPath = Paths.get( "contacts.txt");
        List<String> contactsFromFile = Files.readAllLines(contactsPath);

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
                    for (int i = 0; i < contactsFromFile.size(); i += 1) {
                        System.out.println(contactsFromFile.get(i));
                    }
                    System.out.println();
                    break;
                case 2:
                    //createContact method
                    String userInputName = input.getString();
                    String userInputPhone = input.getString();

                    Contact contact = new Contact(userInputName, userInputPhone);
                    List<String> contactList = Arrays.asList(contact.toString());

                    Path filepath = Paths.get("contacts.txt");
//
                    Files.write(filepath, contactList);



                    break;
                case 3:
                    //searchContact method
                    break;
                case 4:
                    //deleteContact method
                    break;
                case 5:
                    choice = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

}