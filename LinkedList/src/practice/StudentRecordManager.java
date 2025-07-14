package practice;

import java.util.Scanner;

class StudentNode {
    int rollNo;
    String name;
    int age;
    char grade;
    StudentNode next;

    public StudentNode(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private StudentNode head;

    // Add at beginning
    public void addAtBeginning(int rollNo, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(int rollNo, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Add at specific position (1-based)
    public void addAtPosition(int pos, int rollNo, String name, int age, char grade) {
        if (pos <= 1 || head == null) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }

        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        StudentNode current = head;
        for (int i = 1; i < pos - 1 && current.next != null; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete by roll number
    public void deleteByRollNo(int rollNo) {
        if (head == null) return;

        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }

        StudentNode current = head;
        while (current.next != null && current.next.rollNo != rollNo) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Student with roll number " + rollNo + " not found.");
        }
    }

    // Search by roll number
    public void searchByRollNo(int rollNo) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNo == rollNo) {
                System.out.println("Found: " + current.rollNo + ", " + current.name + ", " + current.age + ", " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with roll number " + rollNo + " not found.");
    }

    // Update grade
    public void updateGrade(int rollNo, char newGrade) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNo == rollNo) {
                current.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Student with roll number " + rollNo + " not found.");
    }

    // Display all records
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records to display.");
            return;
        }
        StudentNode current = head;
        while (current != null) {
            System.out.println("Roll No: " + current.rollNo + ", Name: " + current.name +
                    ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
}

public class StudentRecordManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;

        do {
            System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position");
            System.out.println("4. Delete by Roll No\n5. Search by Roll No\n6. Update Grade");
            System.out.println("7. Display All\n8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            int rollNo, age, pos;
            char grade;
            String name;

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No, Name, Age, Grade: ");
                    rollNo = sc.nextInt(); name = sc.next(); age = sc.nextInt(); grade = sc.next().charAt(0);
                    list.addAtBeginning(rollNo, name, age, grade);
                    break;

                case 2:
                    System.out.print("Enter Roll No, Name, Age, Grade: ");
                    rollNo = sc.nextInt(); name = sc.next(); age = sc.nextInt(); grade = sc.next().charAt(0);
                    list.addAtEnd(rollNo, name, age, grade);
                    break;

                case 3:
                    System.out.print("Enter Position, Roll No, Name, Age, Grade: ");
                    pos = sc.nextInt(); rollNo = sc.nextInt(); name = sc.next(); age = sc.nextInt(); grade = sc.next().charAt(0);
                    list.addAtPosition(pos, rollNo, name, age, grade);
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    rollNo = sc.nextInt();
                    list.deleteByRollNo(rollNo);
                    break;

                case 5:
                    System.out.print("Enter Roll No to search: ");
                    rollNo = sc.nextInt();
                    list.searchByRollNo(rollNo);
                    break;

                case 6:
                    System.out.print("Enter Roll No and new Grade: ");
                    rollNo = sc.nextInt(); grade = sc.next().charAt(0);
                    list.updateGrade(rollNo, grade);
                    break;

                case 7:
                    list.displayAll();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 8);

        sc.close();
    }
}
