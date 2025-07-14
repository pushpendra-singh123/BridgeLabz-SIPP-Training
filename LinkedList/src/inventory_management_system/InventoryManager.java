package inventory_management_system;

import java.util.Scanner;

public class InventoryManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryList inventory = new InventoryList();
        int choice;

        do {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Item ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search Item");
            System.out.println("7. Display All");
            System.out.println("8. Total Inventory Value");
            System.out.println("9. Sort Inventory");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int id, qty, pos;
            double price;
            String name;

            switch (choice) {
                case 1:
                    System.out.print("Enter Name, ID, Qty, Price: ");
                    name = sc.next(); id = sc.nextInt(); qty = sc.nextInt(); price = sc.nextDouble();
                    inventory.addAtBeginning(name, id, qty, price);
                    break;

                case 2:
                    System.out.print("Enter Name, ID, Qty, Price: ");
                    name = sc.next(); id = sc.nextInt(); qty = sc.nextInt(); price = sc.nextDouble();
                    inventory.addAtEnd(name, id, qty, price);
                    break;

                case 3:
                    System.out.print("Enter Position, Name, ID, Qty, Price: ");
                    pos = sc.nextInt(); name = sc.next(); id = sc.nextInt(); qty = sc.nextInt(); price = sc.nextDouble();
                    inventory.addAtPosition(pos, name, id, qty, price);
                    break;

                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    id = sc.nextInt();
                    inventory.removeById(id);
                    break;

                case 5:
                    System.out.print("Enter Item ID and new Quantity: ");
                    id = sc.nextInt(); qty = sc.nextInt();
                    inventory.updateQuantity(id, qty);
                    break;

                case 6:
                    System.out.print("Enter Item ID or Name to search: ");
                    name = sc.next();
                    inventory.searchItem(name);
                    break;

                case 7:
                    inventory.displayAll();
                    break;

                case 8:
                    inventory.calculateTotalValue();
                    break;

                case 9:
                    System.out.print("Sort by (name/price): ");
                    String sortBy = sc.next();
                    System.out.print("Ascending? (true/false): ");
                    boolean asc = sc.nextBoolean();
                    inventory.sort(sortBy, asc);
                    break;

                case 10:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 10);
        sc.close();
    }
}

