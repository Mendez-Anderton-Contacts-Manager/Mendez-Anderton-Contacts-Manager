import util.Input;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();

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
                    break;
                case 2:
                    //createContact method
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