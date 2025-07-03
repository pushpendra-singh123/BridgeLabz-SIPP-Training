package inheritance_practice;
//Hybrid Inheritance


//Interface
interface Worker {
	void performDuties();
}

//Superclass
class Person {
	String name;
	int id;
 
 // Constructor for Person
	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	 }

    // Method to display person details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

//Subclass 1 - Chef (Inheriting from Person and implementing Worker)
class Chef extends Person implements Worker {

	String specialty;

	public Chef(String name, int id, String specialty) {
		super(name, id);
		this.specialty = specialty;
	}
	@Override
	public void performDuties() {
		System.out.println("Duties: Preparing dishes, specializing in " + specialty + ".");
	}
}

//Subclass 2 - Waiter (Inheriting from Person and implementing Worker)
class Waiter extends Person implements Worker {
		String assignedSection;

	    public Waiter(String name, int id, String assignedSection) {
	        super(name, id);
	        this.assignedSection = assignedSection;
	    }

	    @Override
	    public void performDuties() {
	        System.out.println("Duties: Serving customers in the " + assignedSection + " section.");
	    }
	}

public class RestaurantManagement {
	 public static void main(String[] args) {
	        // Create Chef object
	        Chef chef = new Chef("Khushi Goyal", 101, "Italian Cuisine");
	        chef.displayDetails();
	        chef.performDuties();

	        System.out.println();

	        // Create Waiter object
	        Waiter waiter = new Waiter("Ananya Sharma", 202, "Outdoor Seating");
	        waiter.displayDetails();
	        waiter.performDuties();
	    }

}
