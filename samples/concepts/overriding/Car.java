public class Car extends Vehicle {
  private int numberOfDoors;

  public Car(String brand, String model, int numberOfWheels, int numberOfDoors) {
    // The 'super' keyword calls the constructor of the parent class (Vehicle).
    super(brand, model, numberOfWheels);

    this.numberOfDoors = numberOfDoors;

    System.out.println("A new Car has been created.");
  }

  // A unique method for the Car class
  public void openLuggageTrunk() {
    System.out.println("Luggage trunk open!");
  }

  // Method overriding: providing a specific implementation for startEngine()
  @Override
  public void startEngine() {
    System.out.println("The car's engine was started using ignition starter.");
  }

  // @Override keyword is optional in Java
  public void displayInfo() {
    super.displayInfo(); // Calling the inherited method from the superclass

    System.out.println("Number of Doors: " + numberOfDoors);
  }
}
