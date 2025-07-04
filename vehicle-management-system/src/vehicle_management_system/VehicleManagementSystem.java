package vehicle_management_system;

//Base Vehicle class
abstract class Vehicle {
 protected String brand;
 protected String model;
 protected String fuelType;

 public Vehicle(String brand, String model, String fuelType) {
     this.brand = brand;
     this.model = model;
     this.fuelType = fuelType;
 }

 public abstract double calculateServiceCost();

 public void printServiceDetails() {
     System.out.println("Vehicle: " + brand + " " + model);
     System.out.println("Fuel Type: " + fuelType);
     System.out.println("Standard service check");
 }
}

//Car subclass
class Car extends Vehicle {
 private int numDoors;

 public Car(String brand, String model, String fuelType, int numDoors) {
     super(brand, model, fuelType);
     this.numDoors = numDoors;
 }

 @Override
 public double calculateServiceCost() {
     // Car service cost includes basic service + door check
     return 100 + (numDoors * 10);
 }

 @Override
 public void printServiceDetails() {
     System.out.println("Car: " + brand + " " + model);
     System.out.println("Fuel Type: " + fuelType);
     System.out.println("Number of Doors: " + numDoors);
     System.out.println("Service Cost: $" + calculateServiceCost());
     System.out.println("Services include: oil change, tire rotation, door mechanism check");
 }
}

//Bike subclass
class Bike extends Vehicle {
 private String bikeType;

 public Bike(String brand, String model, String fuelType, String bikeType) {
     super(brand, model, fuelType);
     this.bikeType = bikeType;
 }

 @Override
 public double calculateServiceCost() {
     // Bike service cost is generally lower
     return bikeType.equals("Cruiser") ? 50 : 75;
 }

 @Override
 public void printServiceDetails() {
     System.out.println("Bike: " + brand + " " + model);
     System.out.println("Fuel Type: " + fuelType);
     System.out.println("Bike Type: " + bikeType);
     System.out.println("Service Cost: $" + calculateServiceCost());
     System.out.println("Services include: chain lubrication, brake adjustment, tire pressure check");
 }
}

//Truck subclass
class Truck extends Vehicle {
 private double maxLoad;

 public Truck(String brand, String model, String fuelType, double maxLoad) {
     super(brand, model, fuelType);
     this.maxLoad = maxLoad;
 }

 @Override
 public double calculateServiceCost() {
     // Truck service cost is higher and depends on load capacity
     return 200 + (maxLoad * 15);
 }

 @Override
 public void printServiceDetails() {
     System.out.println("Truck: " + brand + " " + model);
     System.out.println("Fuel Type: " + fuelType);
     System.out.println("Max Load Capacity: " + maxLoad + " tons");
     System.out.println("Service Cost: $" + calculateServiceCost());
     System.out.println("Services include: diesel system check, brake inspection, load bearing tests");
 }
}

//Garage class to manage multiple vehicles
class Garage {
 private Vehicle[] vehicles;
 private int count;

 public Garage(int capacity) {
     vehicles = new Vehicle[capacity];
     count = 0;
 }

 public void addVehicle(Vehicle vehicle) {
     if (count < vehicles.length) {
         vehicles[count++] = vehicle;
     } else {
         System.out.println("Garage is full!");
     }
 }

 public void serviceAllVehicles() {
     System.out.println("\nServicing all vehicles in the garage:");
     for (int i = 0; i < count; i++) {
         vehicles[i].printServiceDetails();
         System.out.println("------");
     }
 }

 public double calculateTotalServiceCost() {
     double total = 0;
     for (int i = 0; i < count; i++) {
         total += vehicles[i].calculateServiceCost();
     }
     return total;
 }
}

//Main class to demonstrate the system
public class VehicleManagementSystem {
 public static void main(String[] args) {
     // Create a garage with capacity for 5 vehicles
     Garage myGarage = new Garage(5);

     // Add different types of vehicles
     myGarage.addVehicle(new Car("Toyota", "Camry", "Gasoline", 4));
     myGarage.addVehicle(new Bike("Trek", "FX 2", "None", "Road"));
     myGarage.addVehicle(new Truck("Ford", "F-150", "Diesel", 2.5));
     myGarage.addVehicle(new Car("Tesla", "Model 3", "Electric", 4));
     myGarage.addVehicle(new Bike("Harley-Davidson", "Street 750", "Gasoline", "Cruiser"));

     // Demonstrate polymorphism by servicing all vehicles
     myGarage.serviceAllVehicles();

     // Show total service cost
     System.out.println("\nTotal service cost for all vehicles: $" + 
                       myGarage.calculateTotalServiceCost());
 }
}
