import java.util.ArrayList;
import java.util.Scanner;

public class Soups {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> soups = new ArrayList<>();
        boolean running = true;

        System.out.println("Will's Favorite Soups");

        while (running) {
            System.out.println("\n1. Add a soup");
            System.out.println("2. Remove a soup");
            System.out.println("3. Edit a soup");
            System.out.println("4. Display soups");
            System.out.println("5. Quit");
            System.out.print("\nSelection [1-5]? ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    System.out.print("Enter the name of the soup: ");
                    soups.add(scanner.nextLine().trim());
                    break;

                case "2":
                    if (handleIfEmpty(soups)) break;
                    System.out.print("Which soup do you want to pour out? ");
                    String toRemove = scanner.nextLine().trim();
                    System.out.println(soups.remove(toRemove) ? toRemove + " has been removed." : toRemove + " is not in the list.");
                    break;

                case "3":
                    if (handleIfEmpty(soups)) break;
                    System.out.print("Which soup do you want to edit? ");
                    String toEdit = scanner.nextLine().trim();
                    if (soups.contains(toEdit)) {
                        System.out.print("How do you want it to read? ");
                        soups.set(soups.indexOf(toEdit), scanner.nextLine().trim());
                    } else {
                        System.out.println(toEdit + " is not in the list.");
                    }
                    break;

                case "4":
                    if (handleIfEmpty(soups)) break;
                    System.out.println("Here's the list:");
                    soups.forEach(System.out::println);
                    break;

                case "5":
                    running = false;
                    System.out.println("\nHere's the list:");
                    soups.forEach(System.out::println);
                    System.out.println("done.");
                    break;

                default:
                    System.out.println("Invalid selection. Please choose a number between 1 and 5.");
            }
        }
        scanner.close();
    }

    private static boolean handleIfEmpty(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("No items in the list.");
            return true;
        }
        return false;
    }
}
