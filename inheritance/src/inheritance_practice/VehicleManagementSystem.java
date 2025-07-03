package inheritance_practice;


//Interface
interface Refuelable {
	void refuel();
}

//Superclass
class Vehicle {
	String model;
	int maxSpeed;
	// Constructor for Vehicle
    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    // Common method
    public void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}
//Subclass 1 - ElectricVehicle (Inherits from Vehicle)
class ElectricVehicle extends Vehicle {

 int batteryCapacity; // in kWh

 public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
     super(model, maxSpeed);
     this.batteryCapacity = batteryCapacity;
 }

 public void charge() {
     System.out.println("Charging... Battery Capacity: " + batteryCapacity + " kWh");
 }
}
//Subclass 2 - PetrolVehicle (Inherits from Vehicle and implements Refuelable)
class PetrolVehicle extends Vehicle implements Refuelable {

 int fuelTankCapacity; // in liters

 public PetrolVehicle(String model, int maxSpeed, int fuelTankCapacity) {
     super(model, maxSpeed);
     this.fuelTankCapacity = fuelTankCapacity;
 }

 @Override
 public void refuel() {
     System.out.println("Refueling... Fuel Tank Capacity: " + fuelTankCapacity + " liters");
 }
}

public class VehicleManagementSystem {
	   public static void main(String[] args) {
	        // Electric Vehicle object
	        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 250, 75);
	        ev.displayDetails();
	        ev.charge();

	        System.out.println();

	        // Petrol Vehicle object
	        PetrolVehicle pv = new PetrolVehicle("Honda City", 180, 40);
	        pv.displayDetails();
	        pv.refuel();
	    }

}
