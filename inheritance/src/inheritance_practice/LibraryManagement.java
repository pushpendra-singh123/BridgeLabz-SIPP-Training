package inheritance_practice;
//Single Level Inheritance
class Book {
    String title;
    int publicationYear;

    // Constructor 
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Method to display book info
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

//Subclass
class Author extends Book {
 String name;
 String bio;

 // Constructor for Author
 public Author(String title, int publicationYear, String name, String bio) {
	// Call superclass constructor
     super(title, publicationYear);  
     this.name = name;
     this.bio = bio;
 }

//Overriding the displayInfo() method
 @Override
 public void displayInfo() {
     super.displayInfo();  // Display book info first
     System.out.println("Author Name: " + name);
     System.out.println("Author Bio: " + bio);
 }
}


public class LibraryManagement {
    public static void main(String[] args) {
        // Create Author object (which includes Book details)
        Author author = new Author("The Art of Coding", 2023, "Khushi Goyal", "A passionate programmer and writer.");

        author.displayInfo();
    }
}
