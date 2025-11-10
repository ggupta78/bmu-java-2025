public abstract class Vehicle {
  // Superclass properties
  protected String brand;
  protected String model;
  protected int numberOfWheels;
  private static int vehicleCount;

  public Vehicle(String brand, String model, int numberOfWheels) {
    this.brand = brand;
    this.model = model;
    this.numberOfWheels = numberOfWheels;
    vehicleCount++;

    System.out.println("A new Vehicle has been created.");
  }

  // Common behavior for all vehicles
  public abstract void startEngine();

  public int getNumberOfWheels() {
    return numberOfWheels;
  }

  public void displayInfo() {
    System.out.println("Brand: " + brand + ", Model: " + model
        + ", Wheels: " + numberOfWheels);
  }

  public static int getVehicleCount() {
    return vehicleCount;
  }
}
