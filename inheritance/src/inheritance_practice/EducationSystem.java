package inheritance_practice;

//Mutltilevel Inheritance

//Base Class
class Course {
 String courseName;
 int duration; // in hours

 // Constructor for Course
 public Course(String courseName, int duration) {
     this.courseName = courseName;
     this.duration = duration;
 }

 // Method to display course details
 public void displayDetails() {
	  System.out.println("Course Name: " + courseName);
      System.out.println("Duration: " + duration + " hours");
  }
}

//First Level Subclass
class OnlineCourse extends Course {
 String platform;
 boolean isRecorded;

 // Constructor for OnlineCourse
 public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
     super(courseName, duration);  // Call Course constructor
     this.platform = platform;
     this.isRecorded = isRecorded;
 }

//Overriding displayDetails
 @Override
 public void displayDetails() {
     super.displayDetails();
     System.out.println("Platform: " + platform);
     System.out.println("Recorded Sessions: " + (isRecorded ? "Yes" : "No"));
 }
}


//Second Level Subclass
class PaidOnlineCourse extends OnlineCourse {
 double fee;
 double discount;  // in percentage

 // Constructor for PaidOnlineCourse
 public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
     super(courseName, duration, platform, isRecorded);  // Call OnlineCourse constructor
     this.fee = fee;
     this.discount = discount;
 }

//Overriding displayDetails
 @Override
 public void displayDetails() {
     super.displayDetails();
     System.out.println("Course Fee: ₹" + fee);
     System.out.println("Discount: " + discount + "%");
     double finalAmount = fee - (fee * discount / 100);
     System.out.println("Final Payable Amount: ₹" + finalAmount);
 }
}


public class EducationSystem {
    public static void main(String[] args) {
        // Creating a PaidOnlineCourse object
        PaidOnlineCourse paidCourse = new PaidOnlineCourse(
            "Java Programming", 40, "Udemy", true, 4000, 20
        );

        // Display full course details
        paidCourse.displayDetails();
    }
}

