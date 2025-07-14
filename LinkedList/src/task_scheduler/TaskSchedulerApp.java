package task_scheduler;
import java.util.*;
public class TaskSchedulerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();
        int choice;

        do {
            System.out.println("\n--- Task Scheduler ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Task ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Move to Next Task");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Search by Priority");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int id, pos, priority;
            String name, dueDate;

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Priority, DueDate: ");
                    id = sc.nextInt();
                    name = sc.next();
                    priority = sc.nextInt();
                    dueDate = sc.next();
                    scheduler.addAtBeginning(id, name, priority, dueDate);
                    break;
                case 2:
                    System.out.print("Enter ID, Name, Priority, DueDate: ");
                    id = sc.nextInt();
                    name = sc.next();
                    priority = sc.nextInt();
                    dueDate = sc.next();
                    scheduler.addAtEnd(id, name, priority, dueDate);
                    break;
                case 3:
                    System.out.print("Enter Position, ID, Name, Priority, DueDate: ");
                    pos = sc.nextInt();
                    id = sc.nextInt();
                    name = sc.next();
                    priority = sc.nextInt();
                    dueDate = sc.next();
                    scheduler.addAtPosition(pos, id, name, priority, dueDate);
                    break;
                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    id = sc.nextInt();
                    scheduler.removeById(id);
                    break;
                case 5:
                    scheduler.viewCurrentTask();
                    break;
                case 6:
                    scheduler.moveToNextTask();
                    break;
                case 7:
                    scheduler.displayAllTasks();
                    break;
                case 8:
                    System.out.print("Enter priority to search: ");
                    priority = sc.nextInt();
                    scheduler.searchByPriority(priority);
                    break;
                case 9:
                    System.out.println("Exiting Task Scheduler...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        sc.close();
    }
}

