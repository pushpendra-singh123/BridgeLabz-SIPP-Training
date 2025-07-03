package inheritance_practice;
//Single Level Inheritance

//Superclass
class Device {
 String deviceId;
 String status;

 // Constructor for Device
 public Device(String deviceId, String status) {
     this.deviceId = deviceId;
     this.status = status;
 }

//Method to display device status
 public void displayStatus() {
     System.out.println("Device ID: " + deviceId);
     System.out.println("Status: " + status);
 }
}


class Thermostat extends Device {
    double temperatureSetting;

    // Constructor for Thermostat
    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);  // Call superclass constructor
        this.temperatureSetting = temperatureSetting;
    }

 // Overriding the displayStatus() method
    @Override
    public void displayStatus() {
        super.displayStatus();  // Display common device info
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}


public class SmartHomeSystem {
	 public static void main(String[] args) {
	        // Create a Thermostat device
	        Thermostat thermostat = new Thermostat("TH-101", "Active", 22.5);

	        // Display thermostat status
	        thermostat.displayStatus();
	    }

}
