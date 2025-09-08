public class Vehicle {
  // Superclass properties
  protected String brand;
  protected String model;
  protected int numberOfWheels;

  public Vehicle(String brand, String model, int numberOfWheels) {
    this.brand = brand;
    this.model = model;
    this.numberOfWheels = numberOfWheels;

    System.out.println("A new Vehicle has been created.");
  }

  // Common behavior for all vehicles
  public void startEngine() {
    System.out.println("The vehicle's engine is starting.");
  }

  public int getNumberOfWheels() {
    return numberOfWheels;
  }

  public void displayInfo() {
    System.out.println("Brand: " + brand + ", Model: " + model
        + ", Wheels: " + numberOfWheels);
  }
}
