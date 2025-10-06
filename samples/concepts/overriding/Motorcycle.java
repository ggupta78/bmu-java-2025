public class Motorcycle extends Vehicle {
  private boolean hasSidecar;

  public Motorcycle(String brand, String model, int numberOfWheels, boolean hasSidecar) {
    super(brand, model, numberOfWheels);

    this.hasSidecar = hasSidecar;

    System.out.println("A new Motorcycle has been created.");
  }

  // A unique method for the Motorcycle class
  public void performWheelie() {
    System.out.println("Performing Wheelie!");
  }

  // Method overriding: providing a specific implementation for startEngine()
  @Override
  public void startEngine() {
    System.out.println("The motorcycle's engine was kick-started.");
  }

  // @Override keyword is optional in Java
  public void displayInfo() {
    super.displayInfo(); // Calling the inherited method from the superclass

    System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
  }
}
