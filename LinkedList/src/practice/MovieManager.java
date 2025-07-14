package practice;

import java.util.Scanner;

class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode prev, next;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

class MovieDoublyLinkedList {
    private MovieNode head, tail;

    // Add at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add at end
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add at specific position (1-based)
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 1 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode current = head;
        int count = 1;

        while (current.next != null && count < position - 1) {
            current = current.next;
            count++;
        }

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }

        current.next = newNode;
    }

    // Remove by title
    public void removeByTitle(String title) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Movie \"" + title + "\" removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    // Search by director or rating
    public void searchByDirectorOrRating(String director, Double rating) {
        MovieNode current = head;
        boolean found = false;

        while (current != null) {
            if ((director != null && current.director.equalsIgnoreCase(director)) ||
                (rating != null && current.rating == rating)) {
                System.out.println("Title: " + current.title + ", Director: " + current.director +
                        ", Year: " + current.year + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No matching movies found.");
        }
    }

    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("\nMovies (Forward):");
        MovieNode current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director +
                    ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("\nMovies (Reverse):");
        MovieNode current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director +
                    ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Update rating by title
    public void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for movie: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }
}

public class MovieManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();
        int choice;

        do {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add at Beginning\n2. Add at End\n3. Add at Position");
            System.out.println("4. Remove by Title\n5. Search by Director\n6. Search by Rating");
            System.out.println("7. Display Forward\n8. Display Reverse\n9. Update Rating\n10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            String title, director;
            int year, pos;
            double rating;

            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = sc.nextLine(); director = sc.nextLine();
                    year = sc.nextInt(); rating = sc.nextDouble();
                    movieList.addAtBeginning(title, director, year, rating);
                    break;

                case 2:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = sc.nextLine(); director = sc.nextLine();
                    year = sc.nextInt(); rating = sc.nextDouble();
                    movieList.addAtEnd(title, director, year, rating);
                    break;

                case 3:
                    System.out.print("Enter Position, Title, Director, Year, Rating: ");
                    pos = sc.nextInt(); sc.nextLine();
                    title = sc.nextLine(); director = sc.nextLine();
                    year = sc.nextInt(); rating = sc.nextDouble();
                    movieList.addAtPosition(pos, title, director, year, rating);
                    break;

                case 4:
                    System.out.print("Enter Movie Title to remove: ");
                    title = sc.nextLine();
                    movieList.removeByTitle(title);
                    break;

                case 5:
                    System.out.print("Enter Director to search: ");
                    director = sc.nextLine();
                    movieList.searchByDirectorOrRating(director, null);
                    break;

                case 6:
                    System.out.print("Enter Rating to search: ");
                    rating = sc.nextDouble();
                    movieList.searchByDirectorOrRating(null, rating);
                    break;

                case 7:
                    movieList.displayForward();
                    break;

                case 8:
                    movieList.displayReverse();
                    break;

                case 9:
                    System.out.print("Enter Movie Title and New Rating: ");
                    title = sc.nextLine(); rating = sc.nextDouble();
                    movieList.updateRating(title, rating);
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

