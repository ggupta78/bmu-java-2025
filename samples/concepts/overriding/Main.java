public class Main {
  public static void main(String[] args) {
    // // Create an object of the Superclass Vehicle
    // System.out.println("\n--- Vehicle Actions ---");
    // Vehicle vehicle = new Vehicle("Some brand", "Some model", 3);
    // vehicle.startEngine();
    // vehicle.displayInfo();

    // System.out.println("\n--- Car Actions ---");
    // // Create an object of the Car class
    // Car myCar = new Car("Honda", "City", 4, 4);
    // myCar.displayInfo(); // Calls the Car's info method, which uses the parent's
    // method
    // myCar.startEngine(); // Calls the overridden startEngine method in Car
    // myCar.openLuggageTrunk(); // Calls the unique method in Car

    // System.out.println("\n--- Motorcycle Actions ---");
    // // Create an object of the Motorcycle class
    // Motorcycle myMotorcycle = new Motorcycle("Honda", "H'ness CB350", 2, false);
    // myMotorcycle.displayInfo();
    // myMotorcycle.startEngine();
    // myMotorcycle.performWheelie();

    // ---------------------------------------------
    // Using the Superclass to manipulate the child class

    System.out.println("\n--- City Actions ---");
    Vehicle city = new Car("Honda", "City", 4, 4);
    city.startEngine(); // Calls the overridden startEngine method in Car
    city.displayInfo(); // Calls the Car's info method, which calls parent's method
    // An example of Downcasting
    ((Car) city).openLuggageTrunk(); // Calls the unique method in Car

    // System.out.println("\n--- H'ness CB350 Actions ---");
    // Vehicle cb350 = new Motorcycle("Honda", "H'ness CB350", 2, false);
    // cb350.startEngine();
    // cb350.displayInfo();
    // An example of Downcasting
    // ((Motorcycle) cb350).performWheelie();

    // System.out.println("Total Vehicle Count: " + Vehicle.getVehicleCount());

  }
}
