package inheritance_practice;
//Hierarchical

class Person {
    String name;
    int age;

    // Constructor for Person
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Common method to display person details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

//Subclass 1 - Teacher
class Teacher extends Person {
 String subject;

 public Teacher(String name, int age, String subject) {
     super(name, age);
     this.subject = subject;
 }

 public void displayRole() {
     displayDetails();
     System.out.println("Role: Teacher");
     System.out.println("Subject: " + subject);
 }
 }

 // Subclass 2 - Student
 class Student extends Person {
     String grade;

     public Student(String name, int age, String grade) {
         super(name, age);
         this.grade = grade;
     }
     
     public void displayRole() {
         displayDetails();
         System.out.println("Role: Student");
         System.out.println("Grade: " + grade);
     }
 }
//Subclass 3 - Staff
class Staff extends Person {

    String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRole() {
        displayDetails();
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

// Main Class
public class SchoolSystem {
    public static void main(String[] args) {
        // Create a Teacher object
        Teacher teacher = new Teacher("Khushi Goyal", 30, "Mathematics");
        teacher.displayRole();

        System.out.println();

        // Create a Student object
        Student student = new Student("Ananya Sharma", 16, "10th Grade");
        student.displayRole();

        System.out.println();

        // Create a Staff object
        Staff staff = new Staff("Rajesh Verma", 40, "Administration");
        staff.displayRole();
    }
}