import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hashtable<String, Integer> phonebook = new Hashtable<>();
        phonebook.put("Jason", 332324);
        phonebook.put("Mace", 443259);
        boolean programOver = false;

        while (!programOver) {
            printMenu();
            int userChoice = -1;

            while (userChoice < 0 || userChoice > 5) {
                userChoice = input.nextInt();
            }
            input.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.println("You have " + phonebook.size() + " contacts.");
                    listEntries(phonebook);
                    break;

                case 2:
                    System.out.println("Add the name, then phone number:");
                    String name = input.nextLine();
                    int phoneNumber = input.nextInt();
                    phonebook.put(name, phoneNumber);
                    break;

                case 3:
                    System.out.println("Enter the name you want to update:");
                    String oldName = input.nextLine();
                    if (phonebook.containsKey(oldName)) {
                        System.out.println("Enter the new name:");
                        String newName = input.nextLine();
                        System.out.println("Enter the new phone number:");
                        int newPhoneNumber = input.nextInt();
                        phonebook.remove(oldName);
                        phonebook.put(newName, newPhoneNumber);
                    } else {
                        System.out.println("Name not found. Please try again.");
                    }
                    break;

                case 4:
                    System.out.println("Enter the name you want to remove:");
                    String nameToRemove = input.nextLine();
                    if (phonebook.remove(nameToRemove) != null) {
                        System.out.println("Entry removed.");
                    } else {
                        System.out.println("Name not found. Please try again.");
                    }
                    break;

                case 5:
                    programOver = true;
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Welcome to the phonebook app!");
        System.out.println("What would you like to do?");
        System.out.println("1. Read the phone book");
        System.out.println("2. Add new entry");
        System.out.println("3. Update an entry");
        System.out.println("4. Remove an entry");
        System.out.println("5. Exit");
    }

    public static void listEntries(Hashtable<String, Integer> phonebook) {
        Enumeration<String> keys = phonebook.keys();
        Enumeration<Integer> values = phonebook.elements();

        System.out.println("Phonebook entries:");
        while (keys.hasMoreElements() && values.hasMoreElements()) {
            String key = keys.nextElement();
            Integer value = values.nextElement();
            System.out.println(key + ": " + value);
        }
    }
}
